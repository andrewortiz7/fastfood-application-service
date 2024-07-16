package com.fastfood.application.service.restaurant.service.domain;

import com.fastfood.application.service.domain.entity.DomainPage;
import com.fastfood.application.service.domain.valueobject.SortingValue;
import com.fastfood.application.service.restaurant.service.domain.dto.FindDishesRequest;
import com.fastfood.application.service.restaurant.service.domain.dto.FindDishesResponse;
import com.fastfood.application.service.restaurant.service.domain.entity.Dish;
import com.fastfood.application.service.restaurant.service.domain.entity.Ingredient;
import com.fastfood.application.service.restaurant.service.domain.mapper.RestaurantApplicationMapper;
import com.fastfood.application.service.restaurant.service.domain.repository.DishRepository;
import com.fastfood.application.service.restaurant.service.domain.service.RestaurantApplicationService;
import com.fastfood.application.service.restaurant.service.domain.valueobject.DishId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.mockito.Mockito.when;

@TestInstance(TestInstance.Lifecycle.PER_METHOD)
@SpringBootTest(classes = RestaurantTestConfiguration.class)
public class RestaurantApplicationServiceTest {

    @Autowired
    private RestaurantApplicationService restaurantApplicationService;
    @Autowired
    private RestaurantApplicationMapper restaurantApplicationMapper;
    @Autowired
    private DishRepository dishRepository;

    private Dish dish;
    private FindDishesResponse dishesResponse;
    private FindDishesRequest dishesRequest;

    private UUID dishId = UUID.fromString("5f7531e7-903d-49b0-b4b1-a99ba9e10391");
    private String dishName = "Frisoles";
    private Double basePrice = 10000.0;
    private List<Ingredient> ingredients = List.of(
            new Ingredient("Chicharron", 3000.0, "porcion"),
            new Ingredient("Aguacate", 1000.0, "aguacate"),
            new Ingredient("Chorizo", 2000.0, "porcion")
    );
    private Integer page = 0;
    private Integer size = 10;
    private String sortingValue = "DESC";

    @BeforeEach
    public void setup() {
        dish = Dish.builder()
                .id(new DishId(dishId))
                .name(dishName)
                .availableIngredients(ingredients)
                .basePrice(basePrice)
                .build();
        dishesRequest = new FindDishesRequest(page, size, sortingValue);
        dishesResponse = FindDishesResponse.builder()
                .id(dish.getId().getValue())
                .basePrice(dish.getBasePrice())
                .name(dish.getName())
                .build();
        when(restaurantApplicationMapper.dishToFindDishesResponse(dish))
                .thenReturn(dishesResponse);
    }

    @Test
    void givenAFindDishesRequest_whenAttemptToFindByCriteria_thenShouldReturnADomainPageFindDishesResponse() {
        when(dishRepository
                .findAllByParameters(dishesRequest.getPage()
                        , dishesRequest.getSize()
                        , SortingValue.valueOf(dishesRequest.getSortingValue())))
                .thenReturn(new DomainPage<>(
                                List.of(dish),
                                page,
                                size,
                                (long) List.of(dish).size()
                        )
                );
        DomainPage<FindDishesResponse> response = restaurantApplicationService
                .findDishesByCriteria(dishesRequest);
        Assertions.assertEquals(page, response.getPage());
        Assertions.assertEquals(size, response.getSize());
        Assertions.assertEquals(List.of(dishesResponse), response.getContent());
    }

}

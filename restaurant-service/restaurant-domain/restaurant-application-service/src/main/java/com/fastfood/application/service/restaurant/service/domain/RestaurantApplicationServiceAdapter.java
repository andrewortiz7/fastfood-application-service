package com.fastfood.application.service.restaurant.service.domain;

import com.fastfood.application.service.domain.entity.DomainPage;
import com.fastfood.application.service.domain.valueobject.SortingValue;
import com.fastfood.application.service.restaurant.service.domain.dto.FindDishesRequest;
import com.fastfood.application.service.restaurant.service.domain.dto.FindDishesResponse;
import com.fastfood.application.service.restaurant.service.domain.entity.Dish;
import com.fastfood.application.service.restaurant.service.domain.mapper.RestaurantApplicationMapper;
import com.fastfood.application.service.restaurant.service.domain.repository.DishRepository;
import com.fastfood.application.service.restaurant.service.domain.service.RestaurantApplicationService;

public class RestaurantApplicationServiceAdapter implements RestaurantApplicationService {

    private final DishRepository dishRepository;
    private final RestaurantApplicationMapper restaurantMapper;

    public RestaurantApplicationServiceAdapter(DishRepository dishRepository, RestaurantApplicationMapper restaurantMapper) {
        this.dishRepository = dishRepository;
        this.restaurantMapper = restaurantMapper;
    }

    @Override
    public DomainPage<FindDishesResponse> findDishesByCriteria(FindDishesRequest findDishesRequest) {
        DomainPage<Dish> dishes = dishRepository.findAllByParameters(
                findDishesRequest.getPage(),
                findDishesRequest.getSize(),
                SortingValue.valueOf(
                        !findDishesRequest.getSortingValue().equalsIgnoreCase("ASC") &&
                                !findDishesRequest.getSortingValue().equalsIgnoreCase("DESC")
                                ? "ASC" : findDishesRequest.getSortingValue().toUpperCase()
                )
        );
        return new DomainPage<>(
                dishes.getContent().stream().map(restaurantMapper::dishToFindDishesResponse).toList(),
                dishes.getPage(),
                dishes.getSize(),
                dishes.getTotalResult()
        );
    }
}

package com.fastfood.application.service.restaurant.service.domain;

import com.fastfood.application.service.restaurant.service.domain.mapper.RestaurantApplicationMapper;
import com.fastfood.application.service.restaurant.service.domain.repository.DishRepository;
import com.fastfood.application.service.restaurant.service.domain.service.RestaurantApplicationService;
import org.mockito.Mockito;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(scanBasePackages = "com.fastfood.application.service")
public class RestaurantTestConfiguration {

    @Bean
    public DishRepository dishRepository(){
        return Mockito.mock(DishRepository.class);
    }
    @Bean
    public RestaurantApplicationMapper restaurantApplicationMapper(){
        return Mockito.mock(RestaurantApplicationMapper.class);
    }
    @Bean
    public RestaurantApplicationService restaurantApplicationService(){
        return new RestaurantApplicationServiceAdapter(dishRepository(),restaurantApplicationMapper());
    }

}

package com.fastfood.application.service.restaurant.service.domain.mapper;

import com.fastfood.application.service.restaurant.service.domain.dto.FindDishesResponse;
import com.fastfood.application.service.restaurant.service.domain.entity.Dish;

public interface RestaurantApplicationMapper {
    FindDishesResponse dishToFindDishesResponse(Dish dish);
}

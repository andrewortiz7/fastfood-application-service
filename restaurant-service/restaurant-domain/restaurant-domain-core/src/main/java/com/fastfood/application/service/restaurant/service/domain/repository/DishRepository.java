package com.fastfood.application.service.restaurant.service.domain.repository;

import com.fastfood.application.service.restaurant.service.domain.entity.Dish;

import java.util.List;

public interface DishRepository {
    List<Dish> findAll();
}

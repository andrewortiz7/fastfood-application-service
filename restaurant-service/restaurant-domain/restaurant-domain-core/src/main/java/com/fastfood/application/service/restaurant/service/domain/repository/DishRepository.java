package com.fastfood.application.service.restaurant.service.domain.repository;

import com.fastfood.application.service.domain.entity.DomainPage;
import com.fastfood.application.service.domain.repository.BaseRepository;
import com.fastfood.application.service.domain.valueobject.SortingValue;
import com.fastfood.application.service.restaurant.service.domain.entity.Dish;
import com.fastfood.application.service.restaurant.service.domain.valueobject.DishId;

import java.util.List;

public interface DishRepository extends BaseRepository<Dish, DishId> {
    DomainPage<Dish> findAllByParameters(
            Integer page,
            Integer size,
            SortingValue sortingValue
    );
}

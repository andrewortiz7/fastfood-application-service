package com.fastfood.application.service.restaurant.service.domain.service;

import com.fastfood.application.service.domain.entity.DomainPage;
import com.fastfood.application.service.restaurant.service.domain.dto.FindDishesRequest;
import com.fastfood.application.service.restaurant.service.domain.dto.FindDishesResponse;

public interface RestaurantApplicationService {

    DomainPage<FindDishesResponse> findDishesByCriteria(FindDishesRequest findDishesRequest);

}

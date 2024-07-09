package com.fastfood.application.service.restaurant.service.domain.exception;

public class DishNotFoundException extends RestaurantDomainException{
    public DishNotFoundException(String message) {
        super(message);
    }

    public DishNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}

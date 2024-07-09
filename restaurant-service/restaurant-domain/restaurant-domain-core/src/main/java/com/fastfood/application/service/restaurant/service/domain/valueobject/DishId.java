package com.fastfood.application.service.restaurant.service.domain.valueobject;

import java.util.UUID;

public class DishId {
    private final UUID id;

    public DishId(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }
}

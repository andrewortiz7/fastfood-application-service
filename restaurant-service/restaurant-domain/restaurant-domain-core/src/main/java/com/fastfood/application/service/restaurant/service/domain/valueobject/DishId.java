package com.fastfood.application.service.restaurant.service.domain.valueobject;

import com.fastfood.application.service.domain.valueobject.BaseId;

import java.util.UUID;

public class DishId extends BaseId<UUID> {
    public DishId(UUID value) {
        super(value);
    }
}

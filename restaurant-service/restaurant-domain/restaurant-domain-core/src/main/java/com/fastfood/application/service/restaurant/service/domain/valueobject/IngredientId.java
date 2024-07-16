package com.fastfood.application.service.restaurant.service.domain.valueobject;

import com.fastfood.application.service.domain.valueobject.BaseId;

import java.util.UUID;

public class IngredientId extends BaseId<UUID> {
    public IngredientId(UUID value) {
        super(value);
    }
}

package com.fastfood.application.service.restaurant.service.domain.entity;

import com.fastfood.application.service.domain.entity.BaseEntity;
import com.fastfood.application.service.restaurant.service.domain.valueobject.IngredientId;

public class Ingredient extends BaseEntity<IngredientId> {
    private final String name;
    private final Double pricePerUnit;
    private final String unit;

    public Ingredient(String name, Double pricePerUnit, String unit) {
        this.name = name;
        this.pricePerUnit = pricePerUnit;
        this.unit = unit;
    }

    public String getName() {
        return name;
    }

    public Double getPricePerUnit() {
        return pricePerUnit;
    }

    public String getUnit() {
        return unit;
    }
}

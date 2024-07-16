package com.fastfood.application.service.restaurant.service.domain.entity;

import com.fastfood.application.service.domain.entity.BaseEntity;
import com.fastfood.application.service.domain.valueobject.BaseId;
import com.fastfood.application.service.restaurant.service.domain.valueobject.DishId;

import java.util.List;
import java.util.UUID;

public class Dish extends BaseEntity<DishId> {

    private final String name;
    private final List<Ingredient> availableIngredients;
    private final Double basePrice;

    private Dish(Builder builder) {
        super.setId(builder.id);
        name = builder.name;
        availableIngredients = builder.availableIngredients;
        basePrice = builder.basePrice;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getName() {
        return name;
    }

    public List<Ingredient> getAvailableIngredients() {
        return availableIngredients;
    }

    public Double getBasePrice() {
        return basePrice;
    }


    public static final class Builder {
        private DishId id;
        private String name;
        private List<Ingredient> availableIngredients;
        private Double basePrice;

        private Builder() {
        }

        public Builder id(DishId val) {
            id = val;
            return this;
        }

        public Builder name(String val) {
            name = val;
            return this;
        }

        public Builder availableIngredients(List<Ingredient> val) {
            availableIngredients = val;
            return this;
        }

        public Builder basePrice(Double val) {
            basePrice = val;
            return this;
        }

        public Dish build() {
            return new Dish(this);
        }
    }
}

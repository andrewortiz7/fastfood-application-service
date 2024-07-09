package com.fastfood.application.service.restaurant.service.domain.entity;

import com.fastfood.application.service.restaurant.service.domain.valueobject.DishId;

import java.util.List;
import java.util.UUID;

public class Dish {

    private DishId id;
    private String name;
    private List<String> ingredients;
    private Double totalPrice;

    private Dish(Builder builder) {
        id = builder.id;
        name = builder.name;
        ingredients = builder.ingredients;
        totalPrice = builder.totalPrice;
    }

    public static Builder builder() {
        return new Builder();
    }


    public static final class Builder {
        private DishId id;
        private String name;
        private List<String> ingredients;
        private Double totalPrice;

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

        public Builder ingredients(List<String> val) {
            ingredients = val;
            return this;
        }

        public Builder totalPrice(Double val) {
            totalPrice = val;
            return this;
        }

        public Dish build() {
            return new Dish(this);
        }
    }
}

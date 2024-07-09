package com.fastfood.application.service.restaurant.service.domain.entity;

import com.fastfood.application.service.domain.entity.BaseEntity;
import com.fastfood.application.service.domain.valueobject.BaseId;
import com.fastfood.application.service.restaurant.service.domain.valueobject.DishId;

import java.util.List;
import java.util.UUID;

public class Dish extends BaseEntity<DishId> {

    private final String name;
    private final List<String> ingredients;
    private final Double totalPrice;

    private Dish(Builder builder) {
        super.setId(builder.dishId);
        name = builder.name;
        ingredients = builder.ingredients;
        totalPrice = builder.totalPrice;
    }

    public String getName() {
        return name;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public static Builder builder() {
        return new Builder();
    }


    public static final class Builder {
        private DishId dishId;
        private String name;
        private List<String> ingredients;
        private Double totalPrice;

        private Builder() {
        }

        public Builder id(DishId val) {
            dishId = val;
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

package com.fastfood.application.service.restaurant.service.domain.dto;

import java.util.List;
import java.util.UUID;

public class FindDishesResponse {
    private final UUID id;
    private final String name;
    private final Double basePrice;

    private FindDishesResponse(Builder builder) {
        id = builder.id;
        name = builder.name;
        basePrice = builder.basePrice;
    }

    public static Builder builder() {
        return new Builder();
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getBasePrice() {
        return basePrice;
    }

    public static final class Builder {
        private UUID id;
        private String name;
        private Double basePrice;

        private Builder() {
        }

        public Builder id(UUID val) {
            id = val;
            return this;
        }

        public Builder name(String val) {
            name = val;
            return this;
        }

        public Builder basePrice(Double val) {
            basePrice = val;
            return this;
        }

        public FindDishesResponse build() {
            return new FindDishesResponse(this);
        }
    }
}

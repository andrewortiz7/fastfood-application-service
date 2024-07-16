package com.fastfood.application.service.restaurant.service.domain.dto;

public class FindDishesRequest {
    private final Integer page;
    private final Integer size;
    private final String sortingValue;

    public FindDishesRequest(Integer page, Integer size, String sortingValue) {
        this.page = page;
        this.size = size;
        this.sortingValue = sortingValue;
    }

    public Integer getPage() {
        return page;
    }

    public Integer getSize() {
        return size;
    }

    public String getSortingValue() {
        return sortingValue;
    }
}

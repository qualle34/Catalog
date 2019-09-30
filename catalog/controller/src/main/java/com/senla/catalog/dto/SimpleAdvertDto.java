package com.senla.catalog.dto;

import com.senla.catalog.entity.enums.AdvertType;

public class SimpleAdvertDto {

    private int id;
    private String title;
    private double price;
    private AdvertType type;

    public SimpleAdvertDto() {
    }

    public SimpleAdvertDto(int id, String title, double price, AdvertType type) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public AdvertType getType() {
        return type;
    }

    public void setType(AdvertType type) {
        this.type = type;
    }
}

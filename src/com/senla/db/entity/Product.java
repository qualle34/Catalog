package com.senla.db.entity;

public class Product {

    private String maker;
    private String model;
    private String type;

    public Product(String maker, String model, String type) {
        this.maker = maker;
        this.model = model;
        this.type = type;
    }

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {

        return maker + " " + model + " " + type;
    }
}

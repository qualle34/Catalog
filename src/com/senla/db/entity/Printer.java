package com.senla.db.entity;

public class Printer {

    private int code;
    private String model;
    private char color;
    private String type;
    private double price;

    public Printer() {
    }

    public Printer(int code, String model, char color, String type, double price) {
        this.code = code;
        this.model = model;
        this.color = color;
        this.type = type;
        this.price = price;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public char getColor() {
        return color;
    }

    public void setColor(char color) {
        this.color = color;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return code + " " + model + " " + color + " " + type + " " + price;
    }
}

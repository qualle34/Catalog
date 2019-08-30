package com.senla.db.entity;

public class Laptop {

    private int code;
    private String model;
    private int speed;
    private int ram;
    private int hd;
    private double price;
    private float screen;

    public Laptop() {
    }

    public Laptop(int code, String model, int speed, int ram, int hd, double price, float screen) {
        this.code = code;
        this.model = model;
        this.speed = speed;
        this.ram = ram;
        this.hd = hd;
        this.price = price;
        this.screen = screen;
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

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getHd() {
        return hd;
    }

    public void setHd(int hd) {
        this.hd = hd;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public float getScreen() {
        return screen;
    }

    public void setScreen(float screen) {
        this.screen = screen;
    }

    @Override
    public String toString() {
        return code + " " + model + " " + speed + " " + ram + " " + hd + " " + price + " " + screen;
    }
}

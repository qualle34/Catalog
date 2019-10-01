package com.senla.catalog.dto;

import java.util.List;

public class AdvertDto {

    private int id;
    private String title;
    private String description;
    private double price;
    private List<SimpleCommentDto> comments;

    public AdvertDto() {
    }

    public AdvertDto(String title, String description, double price) {
        this.title = title;
        this.description = description;
        this.price = price;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<SimpleCommentDto> getComments() {
        return comments;
    }

    public void setComments(List<SimpleCommentDto> comments) {
        this.comments = comments;
    }
}

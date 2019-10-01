package com.senla.catalog.dto;

import com.senla.catalog.entity.enums.AdvertType;

import java.util.List;

public class AdvertDto {

    private int id;
    private String title;
    private String description;
    private double price;
    private AdvertType type;
    private int userId;
    private int categoryId;
    private List<SimpleCommentDto> comments;

    public AdvertDto() {
    }

    public AdvertDto(String title, String description, double price, AdvertType type, int userId, int categoryId) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.type = type;
        this.userId = userId;
        this.categoryId = categoryId;
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

    public AdvertType getType() {
        return type;
    }

    public void setType(AdvertType type) {
        this.type = type;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public List<SimpleCommentDto> getComments() {
        return comments;
    }

    public void setComments(List<SimpleCommentDto> comments) {
        this.comments = comments;
    }

}

package com.senla.catalog.dto;

public class CommentDto {

    private int id;
    private String text;
    private int advertId;
    private int userId;

    public CommentDto() {
    }

    public CommentDto(String text, int advertId, int userId) {
        this.text = text;
        this.advertId = advertId;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getAdvertId() {
        return advertId;
    }

    public void setAdvertId(int advertId) {
        this.advertId = advertId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}

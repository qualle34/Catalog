package com.senla.catalog.dto.advert;

public class CommentDto {

    private long id;
    private String text;
    private long advertId;
    private long userId;

    public CommentDto() {
    }

    public CommentDto(String text, long advertId, long userId) {
        this.text = text;
        this.advertId = advertId;
        this.userId = userId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public long getAdvertId() {
        return advertId;
    }

    public void setAdvertId(long advertId) {
        this.advertId = advertId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}

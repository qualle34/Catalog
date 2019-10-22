package com.senla.catalog.dto.chat;

public class NewChatDto {

    private long userId;
    private String title;

    public NewChatDto() {
    }

    public NewChatDto(long userId, String title) {
        this.userId = userId;
        this.title = title;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

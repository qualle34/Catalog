package com.senla.catalog.dto.chat;

public class ChatDto {

    private long id;
    private String title;

    public ChatDto() {
    }

    public ChatDto(String title) {
        this.title = title;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

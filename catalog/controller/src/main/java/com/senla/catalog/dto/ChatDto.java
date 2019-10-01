package com.senla.catalog.dto;

public class ChatDto {

    private int id;
    private String title;

    public ChatDto() {
    }

    public ChatDto(String title) {
        this.title = title;
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
}

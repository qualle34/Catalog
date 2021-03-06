package com.senla.catalog.dto.chat;

import java.util.List;

public class ChatDto {

    private long id;
    private String title;
    private List<MessageDto> messages;

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

    public List<MessageDto> getMessages() {
        return messages;
    }

    public void setMessages(List<MessageDto> messages) {
        this.messages = messages;
    }
}

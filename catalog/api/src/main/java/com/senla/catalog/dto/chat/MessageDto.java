package com.senla.catalog.dto.chat;

import java.util.Date;

public class MessageDto {

    private long id;
    private String text;
    private Date sendDate;
    private long chatId;
    private long userId;

    public MessageDto() {
    }

    public MessageDto(String text, long chatId, long userId) {
        this.text = text;
        this.chatId = chatId;
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

    public Date getSendDate() {
        return sendDate;
    }

    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getChatId() {
        return chatId;
    }

    public void setChatId(long chatId) {
        this.chatId = chatId;
    }
}

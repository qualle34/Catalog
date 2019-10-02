package com.senla.catalog.dto;

import java.util.Date;

public class MessageDto {

    private int id;
    private String text;
    private int userId;
    private Date sendDate;

    public MessageDto() {
    }

    public MessageDto(String text, int userId, Date sendDate) {
        this.text = text;
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getSendDate() {
        return sendDate;
    }

    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }
}

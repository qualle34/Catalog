package com.senla.catalog.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class MessageEntityPK implements Serializable {
    private int messageId;
    private int chatId;
    private int userId;

    @Column(name = "message_id")
    @Id
    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    @Column(name = "chat_id")
    @Id
    public int getChatId() {
        return chatId;
    }

    public void setChatId(int chatId) {
        this.chatId = chatId;
    }

    @Column(name = "user_id")
    @Id
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MessageEntityPK that = (MessageEntityPK) o;

        if (messageId != that.messageId) return false;
        if (chatId != that.chatId) return false;
        if (userId != that.userId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = messageId;
        result = 31 * result + chatId;
        result = 31 * result + userId;
        return result;
    }
}

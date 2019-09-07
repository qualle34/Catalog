package com.senla.catalog.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class UserChatEntityPK implements Serializable {
    private int userId;
    private int chatId;

    @Column(name = "user_id")
    @Id
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Column(name = "chat_id")
    @Id
    public int getChatId() {
        return chatId;
    }

    public void setChatId(int chatId) {
        this.chatId = chatId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserChatEntityPK that = (UserChatEntityPK) o;

        if (userId != that.userId) return false;
        if (chatId != that.chatId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + chatId;
        return result;
    }
}

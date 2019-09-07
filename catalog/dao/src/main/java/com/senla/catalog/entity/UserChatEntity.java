package com.senla.catalog.entity;

import javax.persistence.*;

@Entity
@Table(name = "user_chat", schema = "catalog", catalog = "")
@IdClass(UserChatEntityPK.class)
public class UserChatEntity {
    private int userId;
    private int chatId;

    @Id
    @Column(name = "user_id")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Id
    @Column(name = "chat_id")
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

        UserChatEntity that = (UserChatEntity) o;

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

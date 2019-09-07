package com.senla.catalog.entity;

import javax.persistence.*;

@Entity
@Table(name = "chat", schema = "catalog", catalog = "")
public class ChatEntity {
    private int chatId;
    private String title;

    @Id
    @Column(name = "chat_id")
    public int getChatId() {
        return chatId;
    }

    public void setChatId(int chatId) {
        this.chatId = chatId;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ChatEntity that = (ChatEntity) o;

        if (chatId != that.chatId) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = chatId;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        return result;
    }
}

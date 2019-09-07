package com.senla.catalog.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "message", schema = "catalog", catalog = "")
@IdClass(MessageEntityPK.class)
public class MessageEntity {
    private int messageId;
    private int chatId;
    private int userId;
    private String text;
    private Date sendDate;

    @Id
    @Column(name = "message_id")
    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    @Id
    @Column(name = "chat_id")
    public int getChatId() {
        return chatId;
    }

    public void setChatId(int chatId) {
        this.chatId = chatId;
    }

    @Id
    @Column(name = "user_id")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "text")
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Basic
    @Column(name = "send_date")
    public Date getSendDate() {
        return sendDate;
    }

    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MessageEntity that = (MessageEntity) o;

        if (messageId != that.messageId) return false;
        if (chatId != that.chatId) return false;
        if (userId != that.userId) return false;
        if (text != null ? !text.equals(that.text) : that.text != null) return false;
        if (sendDate != null ? !sendDate.equals(that.sendDate) : that.sendDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = messageId;
        result = 31 * result + chatId;
        result = 31 * result + userId;
        result = 31 * result + (text != null ? text.hashCode() : 0);
        result = 31 * result + (sendDate != null ? sendDate.hashCode() : 0);
        return result;
    }
}

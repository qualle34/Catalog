package com.senla.catalog.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "chat")
public class Chat {

    @Id
    @Column(name = "chat_id")
    private int id;

    @Column(name = "title")
    private String title;

    @ManyToMany(mappedBy = "chatList")
    private List<User> userList;

    @OneToMany(mappedBy = "chat", fetch = FetchType.EAGER)
    private List<Message> messageList;

    public Chat() {
    }

    public Chat(String title, List<User> userList, List<Message> messageList) {
        this.title = title;
        this.userList = userList;
        this.messageList = messageList;
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

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public List<Message> getMessageList() {
        return messageList;
    }

    public void setMessageList(List<Message> messageList) {
        this.messageList = messageList;
    }

    @Override
    public String toString() {
        return id + " " + title;
    }
}

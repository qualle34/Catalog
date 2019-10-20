package com.senla.catalog.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.ManyToMany;
import javax.persistence.FetchType;

import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "chat")
public class Chat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "chat_id")
    private long id;

    @Column(name = "title")
    private String title;

    @ManyToMany(mappedBy = "chatSet", fetch = FetchType.LAZY)
    private Set<User> userSet;

    @OneToMany(mappedBy = "chat", fetch = FetchType.LAZY)
    private Set<Message> messageSet;

    public Chat() {
    }

    public Chat(String title, Set<User> userSet) {
        this.title = title;
        this.userSet = userSet;
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

    public Set<User> getUserSet() {
        return userSet;
    }

    public void setUserSet(Set<User> userSet) {
        this.userSet = userSet;
    }

    public Set<Message> getMessageSet() {
        return messageSet;
    }

    public void setMessageSet(Set<Message> messageSet) {
        this.messageSet = messageSet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Chat chat = (Chat) o;
        return id == chat.id &&
                Objects.equals(title, chat.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title);
    }

    @Override
    public String toString() {
        return id + " " + title;
    }
}

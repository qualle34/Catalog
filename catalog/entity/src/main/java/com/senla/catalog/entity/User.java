package com.senla.catalog.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "user")
public class User {

    @Id
    @Column(name = "user_id")
    private int id;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "birthdate", columnDefinition = "DATETIME")
    @Temporal(TemporalType.DATE)
    private Date birthdate;

    @Column(name = "phone")
    private String phone;

    @Column(name = "location")
    private String location;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private Creds creds;

    @OneToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private SellerRating rating;

    @OneToMany(mappedBy = "seller")
    private List<SalesHistory> salesHistoryList;

    @OneToMany(mappedBy = "user")
    private List<Advert> advertList;

    @OneToMany(mappedBy = "user")
    private List<Comment> commentList;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "user_chat",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "chat_id"))
    private List<Chat> chatList;

    @OneToMany(mappedBy = "user")
    private List<Message> messageList;

    public User() {
    }

    public User(String firstname, String lastname, Date birthdate, String phone, String location) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthdate = birthdate;
        this.phone = phone;
        this.location = location;
    }

    public User(String firstname, String lastname, Date birthdate, String phone, String location, Creds creds,
                SellerRating rating, List<SalesHistory> salesHistoryList, List<Advert> advertList,
                List<Comment> commentList, List<Chat> chatList, List<Message> messageList) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthdate = birthdate;
        this.phone = phone;
        this.location = location;
        this.creds = creds;
        this.rating = rating;
        this.salesHistoryList = salesHistoryList;
        this.advertList = advertList;
        this.commentList = commentList;
        this.chatList = chatList;
        this.messageList = messageList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Creds getCreds() {
        return creds;
    }

    public void setCreds(Creds creds) {
        this.creds = creds;
    }

    public SellerRating getRating() {
        return rating;
    }

    public void setRating(SellerRating rating) {
        this.rating = rating;
    }

    public List<SalesHistory> getSalesHistoryList() {
        return salesHistoryList;
    }

    public void setSalesHistoryList(List<SalesHistory> salesHistoryList) {
        this.salesHistoryList = salesHistoryList;
    }

    public List<Advert> getAdvertList() {
        return advertList;
    }

    public void setAdvertList(List<Advert> advertList) {
        this.advertList = advertList;
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }

    public List<Chat> getChatList() {
        return chatList;
    }

    public void setChatList(List<Chat> chatList) {
        this.chatList = chatList;
    }

    public List<Message> getMessageList() {
        return messageList;
    }

    public void setMessageList(List<Message> messageList) {
        this.messageList = messageList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                Objects.equals(firstname, user.firstname) &&
                Objects.equals(lastname, user.lastname) &&
                Objects.equals(birthdate, user.birthdate) &&
                Objects.equals(phone, user.phone) &&
                Objects.equals(location, user.location) &&
                Objects.equals(creds, user.creds) &&
                Objects.equals(rating, user.rating) &&
                Objects.equals(salesHistoryList, user.salesHistoryList) &&
                Objects.equals(advertList, user.advertList) &&
                Objects.equals(commentList, user.commentList) &&
                Objects.equals(chatList, user.chatList) &&
                Objects.equals(messageList, user.messageList);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, firstname, lastname, birthdate, phone, location, creds,
                rating, salesHistoryList, advertList, commentList, chatList, messageList);
    }

    @Override
    public String toString() {
        return firstname + " " + lastname + " " + birthdate.toString() + " " + phone + " " + location;
    }
}
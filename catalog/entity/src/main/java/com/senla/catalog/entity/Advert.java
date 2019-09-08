package com.senla.catalog.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "advert")
public class Advert {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "advert_id")
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private double price;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "advert", cascade = CascadeType.ALL)
    private List<Comment> commentList;

    public Advert() {
    }

    public Advert(String title, String description, double price, User user, Category category) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.user = user;
        this.category = category;
    }

    public Advert(String title, String description, double price, User user, Category category, List<Comment> commentList) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.user = user;
        this.category = category;
        this.commentList = commentList;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getType() {
        return price;
    }

    public void setType(double price) {
        this.price = price;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }

    @Override
    public String toString() {
        return id + " " + title + " " + description + " " + price;
    }
}

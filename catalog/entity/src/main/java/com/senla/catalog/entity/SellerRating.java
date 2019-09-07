package com.senla.catalog.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "seller_rating")
public class SellerRating {

    @Id
    @Column(name = "user_id")
    private int id;

    @Column(name = "rating")
    private int rating;

    @Column(name = "end_vip_date")
    private Date date;

    @OneToOne(mappedBy = "rating")
    private User user;

    public SellerRating() {
    }

    public SellerRating(int rating, Date date, User user) {
        this.rating = rating;
        this.date = date;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return id + " " + rating + " " + date.toString();
    }
}

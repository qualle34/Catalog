package com.senla.catalog.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "seller_rating")
public class SellerRating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int id;

    @Column(name = "rating")
    private float rating;

    @Column(name = "rating_count")
    private int ratingCount;

    @Column(name = "end_vip_date")
    private Date date;

    public SellerRating() {
    }

    public SellerRating(float rating, int ratingCount) {
        this.rating = rating;
        this.ratingCount = ratingCount;
    }

    public SellerRating(float rating, int ratingCount, Date date) {
        this.rating = rating;
        this.ratingCount = ratingCount;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public int getRatingCount() {
        return ratingCount;
    }

    public void setRatingCount(int ratingCount) {
        this.ratingCount = ratingCount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        String line = id + " " + rating + " " + ratingCount;
        if (date != null) {
            line += " " + date.toString();
        }
        return line;
    }
}

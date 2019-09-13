package com.senla.catalog.entity;

import com.senla.csvhelper.annotation.CsvEntity;
import com.senla.csvhelper.annotation.CsvProperty;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToOne;
import javax.persistence.JoinColumn;

import java.util.Date;

@Entity
@Table(name = "seller_rating")
@CsvEntity(directoryName = "D://data")
public class SellerRating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    @CsvProperty(propertyType = CsvProperty.Type.SimpleProperty, columnNumber = 0)
    private int id;

    @Column(name = "rating")
    @CsvProperty(propertyType = CsvProperty.Type.SimpleProperty, columnNumber = 1)
    private float rating;

    @Column(name = "rating_count")
    @CsvProperty(propertyType = CsvProperty.Type.SimpleProperty, columnNumber = 2)
    private int ratingCount;

    @Column(name = "end_vip_date")
    private Date date;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

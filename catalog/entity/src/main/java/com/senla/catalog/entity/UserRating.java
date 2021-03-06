package com.senla.catalog.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.OneToOne;
import javax.persistence.JoinColumn;
import javax.persistence.FetchType;
import javax.persistence.MapsId;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "user_rating")
public class UserRating implements Serializable {

    @Id
    @Column(name = "user_id")
    private long id;

    @Column(name = "rating")
    private float rating;

    @Column(name = "rating_count")
    private int ratingCount;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "user_id")
    private User user;

    public UserRating() {
    }

    public UserRating(float rating, int ratingCount) {
        this.rating = rating;
        this.ratingCount = ratingCount;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserRating that = (UserRating) o;
        return id == that.id &&
                Float.compare(that.rating, rating) == 0 &&
                ratingCount == that.ratingCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, rating, ratingCount);
    }

    @Override
    public String toString() {
        return id + " " + rating + " " + ratingCount;
    }
}

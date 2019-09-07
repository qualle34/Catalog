package com.senla.catalog.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "seller_rating", schema = "catalog", catalog = "")
public class SellerRatingEntity {
    private int userId;
    private int rating;
    private Date endVipDate;

    @Id
    @Column(name = "user_id")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "rating")
    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Basic
    @Column(name = "end_vip_date")
    public Date getEndVipDate() {
        return endVipDate;
    }

    public void setEndVipDate(Date endVipDate) {
        this.endVipDate = endVipDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SellerRatingEntity that = (SellerRatingEntity) o;

        if (userId != that.userId) return false;
        if (rating != that.rating) return false;
        if (endVipDate != null ? !endVipDate.equals(that.endVipDate) : that.endVipDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + rating;
        result = 31 * result + (endVipDate != null ? endVipDate.hashCode() : 0);
        return result;
    }
}

package com.senla.catalog.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class AdvertEntityPK implements Serializable {
    private int advertId;
    private int userId;
    private int categoryId;

    @Column(name = "advert_id")
    @Id
    public int getAdvertId() {
        return advertId;
    }

    public void setAdvertId(int advertId) {
        this.advertId = advertId;
    }

    @Column(name = "user_id")
    @Id
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Column(name = "category_id")
    @Id
    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AdvertEntityPK that = (AdvertEntityPK) o;

        if (advertId != that.advertId) return false;
        if (userId != that.userId) return false;
        if (categoryId != that.categoryId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = advertId;
        result = 31 * result + userId;
        result = 31 * result + categoryId;
        return result;
    }
}

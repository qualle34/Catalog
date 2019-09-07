package com.senla.catalog.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "sales_history", schema = "catalog", catalog = "")
public class SalesHistoryEntity {
    private int userId;
    private int buyerId;
    private String title;
    private Date saleDate;

    @Id
    @Column(name = "user_id")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "buyer_id")
    public int getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(int buyerId) {
        this.buyerId = buyerId;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "sale_date")
    public Date getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(Date saleDate) {
        this.saleDate = saleDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SalesHistoryEntity that = (SalesHistoryEntity) o;

        if (userId != that.userId) return false;
        if (buyerId != that.buyerId) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (saleDate != null ? !saleDate.equals(that.saleDate) : that.saleDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + buyerId;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (saleDate != null ? saleDate.hashCode() : 0);
        return result;
    }
}

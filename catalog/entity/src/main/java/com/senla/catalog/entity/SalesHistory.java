package com.senla.catalog.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "sales_history")
public class SalesHistory implements Serializable {

    @Column(name = "title")
    private String title;

    @Column(name = "sale_date")
    private Date date;

    @Id
    @ManyToOne
    @JoinColumn(name = "seller_id")
    private User seller;

    @ManyToOne
    @JoinColumn(name = "buyer_id")
    private User buyer;

    public SalesHistory() {
    }

    public SalesHistory(String title, Date date, User seller, User buyer) {
        this.title = title;
        this.date = date;
        this.seller = seller;
        this.buyer = buyer;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public User getSeller() {
        return seller;
    }

    public void setSeller(User seller) {
        this.seller = seller;
    }

    public User getBuyer() {
        return buyer;
    }

    public void setBuyer(User buyer) {
        this.buyer = buyer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SalesHistory that = (SalesHistory) o;
        return Objects.equals(title, that.title) &&
                Objects.equals(date, that.date) &&
                Objects.equals(seller, that.seller) &&
                Objects.equals(buyer, that.buyer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, date, seller, buyer);
    }

    @Override
    public String toString() {
        return title + " " + date.toString();
    }
}


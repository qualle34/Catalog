package com.senla.catalog.entity;

import com.senla.catalog.entity.enums.AdvertType;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.Enumerated;
import javax.persistence.EnumType;
import javax.persistence.OneToOne;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;

import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "advert")
public class Advert implements Comparable<Advert> {

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

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private AdvertType type;

    @OneToOne(mappedBy = "advert", optional = false, cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private VipInfo vipInfo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "advert", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Comment> commentSet;

    public Advert() {
    }

    public Advert(String title, String description, double price, AdvertType type, User user, Category category) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.type = type;
        this.user = user;
        this.category = category;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public AdvertType getType() {
        return type;
    }

    public void setType(AdvertType type) {
        this.type = type;
    }

    public VipInfo getVipInfo() {
        return vipInfo;
    }

    public boolean isVip() {
        return this.getVipInfo() != null;
    }

    public void setVipInfo(VipInfo vipInfo) {
        this.vipInfo = vipInfo;
        vipInfo.setAdvert(this);
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

    public Set<Comment> getCommentSet() {
        return commentSet;
    }

    public void setCommentSet(Set<Comment> commentSet) {
        this.commentSet = commentSet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Advert advert = (Advert) o;
        return id == advert.id &&
                Double.compare(advert.price, price) == 0 &&
                Objects.equals(title, advert.title) &&
                Objects.equals(description, advert.description) &&
                type == advert.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, price, type);
    }

    @Override
    public String toString() {
        return id + " " + title + " " + description + " " + price + " " + type;
    }

    @Override
    public int compareTo(Advert o) {
        int rating = Float.compare(this.getUser().getRating().getRating(), o.getUser().getRating().getRating());
        int vip = Boolean.compare(this.isVip(), o.isVip());

        if (vip == 1 || vip == 0 && rating == 1) {
            return 1;
        } else if (vip == 0 && rating == 0) {
            return 0;
        } else {
            return -1;
        }
    }
}

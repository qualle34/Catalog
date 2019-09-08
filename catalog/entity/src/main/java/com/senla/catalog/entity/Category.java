package com.senla.catalog.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private int id;

    @Column(name = "title")
    private String title;

    @OneToMany(mappedBy = "category")
    private List<Advert> advertList;

    public Category() {
    }

    public Category(String title, List<Advert> advertList) {
        this.title = title;
        this.advertList = advertList;
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

    public List<Advert> getAdvertList() {
        return advertList;
    }

    public void setAdvertList(List<Advert> advertList) {
        this.advertList = advertList;
    }

    @Override
    public String toString() {
        return id + " " + title;
    }
}

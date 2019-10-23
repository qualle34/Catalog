package com.senla.catalog.entity;

import com.senla.catalog.entity.enums.AdvertType;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.FetchType;
import javax.persistence.Enumerated;
import javax.persistence.EnumType;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "type")
public class Type {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "type_id")
    private int id;

    @Enumerated(EnumType.STRING)
    @Column(name = "name")
    private AdvertType type;

    @OneToMany(mappedBy = "type", fetch = FetchType.LAZY)
    private Set<Advert> advertSet;

    public Type() {
    }

    public Type(AdvertType type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public AdvertType getType() {
        return type;
    }

    public void setType(AdvertType type) {
        this.type = type;
    }

    public Set<Advert> getUserSet() {
        return advertSet;
    }

    public void setUserSet(Set<Advert> userSet) {
        this.advertSet = userSet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Type type1 = (Type) o;
        return id == type1.id &&
                type == type1.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type);
    }

    @Override
    public String toString() {
        return id + " " + type;
    }
}

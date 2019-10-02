package com.senla.catalog.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.OneToOne;
import javax.persistence.MapsId;
import javax.persistence.JoinColumn;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.FetchType;


import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "vip_info")
public class VipInfo {

    @Id
    @Column(name = "advert_id")
    private int id;

    @OneToOne(optional = false, fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "advert_id")
    private Advert advert;

    @Column(name = "buy_vip_date")
    @Temporal(TemporalType.DATE)
    private Date buyDate;

    public VipInfo() {
    }

    public VipInfo(Date buyDate) {
        this.buyDate = buyDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Advert getAdvert() {
        return advert;
    }

    public void setAdvert(Advert advert) {
        this.advert = advert;
    }

    public Date getBuyDate() {
        return buyDate;
    }

    public void setBuyDate(Date buyDate) {
        this.buyDate = buyDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VipInfo vipInfo = (VipInfo) o;
        return Objects.equals(advert, vipInfo.advert) &&
                Objects.equals(buyDate, vipInfo.buyDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(advert, buyDate);
    }

    @Override
    public String toString() {
        String line = buyDate.toString();

        if (advert != null) {
            line = advert.getId() + " " + line;
        }
        return line;
    }
}

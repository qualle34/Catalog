package com.senla.catalog.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.JoinColumn;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "vip_info")
public class VipInfo implements Serializable {

    @Id
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "advert_id")
    private Advert advert;

    @Column(name = "buy_vip_date")
    private Date buyDate;

    @Column(name = "end_vip_date")
    private Date endDate;

    public VipInfo(){
    }

    public VipInfo(Advert advert, Date buyDate, Date endDate) {
        this.advert = advert;
        this.buyDate = buyDate;
        this.endDate = endDate;
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

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VipInfo vipInfo = (VipInfo) o;
        return Objects.equals(advert, vipInfo.advert) &&
                Objects.equals(buyDate, vipInfo.buyDate) &&
                Objects.equals(endDate, vipInfo.endDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(advert, buyDate, endDate);
    }

    @Override
    public String toString() {
        return buyDate + " " + endDate;
    }
}

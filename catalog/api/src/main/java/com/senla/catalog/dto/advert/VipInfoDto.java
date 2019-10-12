package com.senla.catalog.dto.advert;

import java.util.Date;

public class VipInfoDto {

    private long id;
    private Date buyDate;

    public VipInfoDto() {
    }

    public VipInfoDto(long id, Date buyDate) {
        this.id = id;
        this.buyDate = buyDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getBuyDate() {
        return buyDate;
    }

    public void setBuyDate(Date buyDate) {
        this.buyDate = buyDate;
    }
}

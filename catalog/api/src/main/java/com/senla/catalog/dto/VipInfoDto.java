package com.senla.catalog.dto;

import java.util.Date;

public class VipInfoDto {

    private int id;
    private Date buyDate;

    public VipInfoDto() {
    }

    public VipInfoDto(int id, Date buyDate) {
        this.id = id;
        this.buyDate = buyDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getBuyDate() {
        return buyDate;
    }

    public void setBuyDate(Date buyDate) {
        this.buyDate = buyDate;
    }
}

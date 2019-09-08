package com.senla.catalog.dao;

import com.senla.catalog.daoapi.IAdvertDao;
import com.senla.catalog.entity.Advert;

public class AdvertDao extends AbstractDao<Advert, Integer> implements IAdvertDao {

    @Override
    protected String getSelectAllQuery() {
        return "SELECT a FROM Advert a";
    }

    @Override
    protected Class<Advert> getChildClass() {
        return Advert.class;
    }
}

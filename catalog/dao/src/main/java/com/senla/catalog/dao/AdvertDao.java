package com.senla.catalog.dao;

import com.senla.catalog.dao.basic.AbstractDao;
import com.senla.catalog.daoapi.IAdvertDao;
import com.senla.catalog.entity.Advert;
import org.hibernate.Session;

public class AdvertDao extends AbstractDao<Advert, Integer> implements IAdvertDao {

    public AdvertDao(Session session) {
        super(session);
    }

    @Override
    protected Class<Advert> getChildClass() {
        return Advert.class;
    }



}

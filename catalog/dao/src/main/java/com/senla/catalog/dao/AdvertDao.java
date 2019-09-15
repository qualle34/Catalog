package com.senla.catalog.dao;

import com.senla.catalog.dao.basic.AbstractDao;
import com.senla.catalog.daoapi.IAdvertDao;
import com.senla.catalog.entity.Advert;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

@Repository
public class AdvertDao extends AbstractDao<Advert, Integer> implements IAdvertDao {

    private static final Logger logger = LoggerFactory.getLogger(AdvertDao.class);

    @Autowired
    private Session session;

    @Override
    protected Class getChildClass() {
        return AdvertDao.class;
    }

    @Override
    protected Class<Advert> getEntityClass() {
        return Advert.class;
    }
}

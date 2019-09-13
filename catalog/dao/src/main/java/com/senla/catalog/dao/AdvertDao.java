package com.senla.catalog.dao;

import com.senla.catalog.dao.basic.AbstractDao;
import com.senla.catalog.daoapi.IAdvertDao;
import com.senla.catalog.entity.Advert;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AdvertDao extends AbstractDao<Advert, Integer> implements IAdvertDao {

    private static AdvertDao instance;
    private static final Logger logger = LoggerFactory.getLogger(AdvertDao.class);
    private Session session;

    private AdvertDao(Session session) {
        super(session);
        this.session = session;
    }

    @Override
    protected Class<Advert> getChildClass() {
        return Advert.class;
    }

    public static AdvertDao getInstance(Session session) {

        if (instance == null) {
            instance = new AdvertDao(session);
        }
        return instance;
    }
}

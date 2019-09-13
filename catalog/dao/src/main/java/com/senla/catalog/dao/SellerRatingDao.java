package com.senla.catalog.dao;

import com.senla.catalog.dao.basic.AbstractDao;
import com.senla.catalog.daoapi.ISellerRatingDao;
import com.senla.catalog.entity.SellerRating;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SellerRatingDao extends AbstractDao<SellerRating, Integer> implements ISellerRatingDao {

    private static SellerRatingDao instance;
    private static final Logger logger = LoggerFactory.getLogger(SellerRatingDao.class);
    private Session session;

    private SellerRatingDao(Session session) {
        super(session);
        this.session = session;
    }

    @Override
    protected Class<SellerRating> getChildClass() {
        return SellerRating.class;
    }

    public static SellerRatingDao getInstance(Session session) {

        if (instance == null) {
            instance = new SellerRatingDao(session);
        }
        return instance;
    }
}

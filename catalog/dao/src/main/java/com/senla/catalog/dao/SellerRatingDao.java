package com.senla.catalog.dao;

import com.senla.catalog.dao.basic.AbstractDao;
import com.senla.catalog.daoapi.ISellerRatingDao;
import com.senla.catalog.entity.SellerRating;
import org.hibernate.Session;

public class SellerRatingDao extends AbstractDao<SellerRating, Integer> implements ISellerRatingDao {

    public SellerRatingDao(Session session) {
        super(session);
    }

    @Override
    protected Class<SellerRating> getChildClass() {
        return SellerRating.class;
    }
}

package com.senla.catalog.dao;

import com.senla.catalog.dao.basic.AbstractDao;
import com.senla.catalog.daoapi.ISellerRatingDao;
import com.senla.catalog.entity.SellerRating;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SellerRatingDao extends AbstractDao<SellerRating, Integer> implements ISellerRatingDao {

    @Autowired
    private Session session;

    @Override
    protected Class<SellerRating> getEntityClass() {
        return SellerRating.class;
    }
}

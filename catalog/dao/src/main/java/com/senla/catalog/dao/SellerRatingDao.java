package com.senla.catalog.dao;

import com.senla.catalog.dao.basic.AbstractDao;
import com.senla.catalog.daoapi.ISellerRatingDao;
import com.senla.catalog.entity.SellerRating;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public class SellerRatingDao extends AbstractDao<SellerRating, Integer> implements ISellerRatingDao {

    private static final Logger logger = LoggerFactory.getLogger(SellerRatingDao.class);

    @Autowired
    private Session session;

    @Override
    protected Class getChildClass() {
        return SellerRatingDao.class;
    }

    @Override
    protected Class<SellerRating> getEntityClass() {
        return SellerRating.class;
    }
}

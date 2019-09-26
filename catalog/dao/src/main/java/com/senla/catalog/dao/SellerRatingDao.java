package com.senla.catalog.dao;

import com.senla.catalog.dao.basic.AbstractDao;
import com.senla.catalog.daoapi.ISellerRatingDao;
import com.senla.catalog.entity.SellerRating;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class SellerRatingDao extends AbstractDao<SellerRating, Integer> implements ISellerRatingDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    protected Class<SellerRating> getEntityClass() {
        return SellerRating.class;
    }
}

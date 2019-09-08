package com.senla.catalog.dao;

import com.senla.catalog.daoapi.ISellerRatingDao;
import com.senla.catalog.entity.SellerRating;

public class SellerRatingDao extends AbstractDao<SellerRating, Integer> implements ISellerRatingDao {

    @Override
    protected String getSelectAllQuery() {
        return "SELECT s FROM SellerRating s";
    }

    @Override
    protected Class<SellerRating> getChildClass() {
        return SellerRating.class;
    }
}

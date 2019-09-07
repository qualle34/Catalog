package com.senla.catalog.daoapi;

import com.senla.catalog.entity.SellerRating;

import java.util.List;

public interface ISellerRatingDao extends IGenericDao<SellerRating, Integer> {

    @Override
    List<SellerRating> getAll();

    @Override
    void add(SellerRating sellerRating);

    @Override
    SellerRating get(Integer integer);

    @Override
    void update(SellerRating sellerRating);

    @Override
    void delete(SellerRating sellerRating);
}

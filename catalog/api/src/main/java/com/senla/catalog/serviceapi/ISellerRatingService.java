package com.senla.catalog.serviceapi;

import com.senla.catalog.entity.SellerRating;

import java.util.List;

public interface ISellerRatingService {

    List<SellerRating> getAll();

    void add(SellerRating sellerRating);

    SellerRating get(Integer id);

    void update(SellerRating sellerRating);

    void delete(SellerRating sellerRating);
}

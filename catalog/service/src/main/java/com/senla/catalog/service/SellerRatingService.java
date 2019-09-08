package com.senla.catalog.service;

import com.senla.catalog.dao.SellerRatingDao;
import com.senla.catalog.daoapi.ISellerRatingDao;
import com.senla.catalog.entity.SellerRating;
import com.senla.catalog.serviceapi.ISellerRatingService;

import java.util.List;

public class SellerRatingService implements ISellerRatingService {

    private ISellerRatingDao sellerRatingDao;

    public SellerRatingService() {
        sellerRatingDao = new SellerRatingDao();
    }

    @Override
    public List<SellerRating> getAll() {
        return sellerRatingDao.getAll();
    }

    @Override
    public void add(SellerRating sr) {
        sellerRatingDao.add(sr);
    }

    @Override
    public SellerRating get(Integer id) {
        return sellerRatingDao.get(id);
    }

    @Override
    public void update(SellerRating sr) {
        sellerRatingDao.update(sr);
    }

    @Override
    public void delete(SellerRating sr) {
        sellerRatingDao.delete(sr);
    }
}

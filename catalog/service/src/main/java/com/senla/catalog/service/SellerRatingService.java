package com.senla.catalog.service;

import com.senla.catalog.daoapi.ISellerRatingDao;
import com.senla.catalog.entity.SellerRating;
import com.senla.catalog.service.basic.AbstractService;
import com.senla.catalog.serviceapi.ISellerRatingService;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SellerRatingService extends AbstractService<SellerRating, Integer> implements ISellerRatingService {

    private static final Logger logger = LoggerFactory.getLogger(SellerRatingService.class);
    private ISellerRatingDao sellerRatingDao;
    private Session session;

    public SellerRatingService(ISellerRatingDao sellerRatingDao, Session session) {
        super(sellerRatingDao, session);
        this.sellerRatingDao = sellerRatingDao;
        this.session = session;
    }


    @Override
    protected Class<SellerRating> getChildClass() {
        return null;
    }
}

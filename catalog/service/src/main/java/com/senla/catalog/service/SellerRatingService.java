package com.senla.catalog.service;

import com.senla.catalog.dao.SellerRatingDao;
import com.senla.catalog.daoapi.ISellerRatingDao;
import com.senla.catalog.entity.SellerRating;
import com.senla.catalog.service.basic.AbstractService;
import com.senla.catalog.serviceapi.ISellerRatingService;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SellerRatingService extends AbstractService<SellerRating, Integer> implements ISellerRatingService {

    private static SellerRatingService instance;
    private static final Logger logger = LoggerFactory.getLogger(SellerRatingService.class);
    private ISellerRatingDao sellerRatingDao;
    private Session session;

    private SellerRatingService(ISellerRatingDao sellerRatingDao, Session session) {
        super(sellerRatingDao, session);
        this.sellerRatingDao = sellerRatingDao;
        this.session = session;
    }

    @Override
    protected Class getChildClass() {
        return SellerRatingService.class;
    }

    @Override
    protected Class getEntityClass() {
        return SellerRating.class;
    }

    public static SellerRatingService getInstance(Session session) {
        ISellerRatingDao sellerRatingDao = SellerRatingDao.getInstance(session);

        if (instance == null) {
            instance = new SellerRatingService(sellerRatingDao, session);
        }
        return instance;
    }
}

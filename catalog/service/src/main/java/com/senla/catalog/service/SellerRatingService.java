package com.senla.catalog.service;

import com.senla.catalog.dao.util.HibernateUtil;
import com.senla.catalog.daoapi.ISellerRatingDao;
import com.senla.catalog.daoapi.basic.IGenericDao;
import com.senla.catalog.entity.SellerRating;
import com.senla.catalog.service.basic.AbstractService;
import com.senla.catalog.serviceapi.ISellerRatingService;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class SellerRatingService extends AbstractService<SellerRating, Integer> implements ISellerRatingService {

    private static final Logger logger = LoggerFactory.getLogger(SellerRatingService.class);

    @Autowired
    private Session session;

    @Autowired
    private ISellerRatingDao sellerRatingDao;

    @Override
    protected Class getChildClass() {
        return SellerRatingService.class;
    }

    @Override
    protected Class<SellerRating> getEntityClass() {
        return SellerRating.class;
    }

    @Override
    protected Session getSession() {
        return session;
    }

    @Override
    protected IGenericDao getDao() {
        return sellerRatingDao;
    }

    @Bean
    public SellerRatingService getInstance() {
        return new SellerRatingService();
    }
}

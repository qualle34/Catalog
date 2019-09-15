package com.senla.catalog.service;

import com.senla.catalog.daoapi.IAdvertDao;
import com.senla.catalog.daoapi.basic.IGenericDao;
import com.senla.catalog.entity.Advert;
import com.senla.catalog.service.basic.AbstractService;
import com.senla.catalog.serviceapi.IAdvertService;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class AdvertService extends AbstractService<Advert, Integer> implements IAdvertService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private Session session;

    @Autowired
    private IAdvertDao advertDao;

    @Override
    protected Class getChildClass() {
        return AdvertService.class;
    }

    @Override
    protected Class<Advert> getEntityClass() {
        return Advert.class;
    }

    @Override
    protected Session getSession() {
        return session;
    }

    @Override
    protected IGenericDao getDao() {
        return advertDao;
    }

    @Bean
    public AdvertService getInstance() {
        return new AdvertService();
    }
}

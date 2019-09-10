package com.senla.catalog.service;

import com.senla.catalog.daoapi.IAdvertDao;
import com.senla.catalog.entity.Advert;
import com.senla.catalog.service.basic.AbstractService;
import com.senla.catalog.serviceapi.IAdvertService;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AdvertService extends AbstractService<Advert, Integer> implements IAdvertService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);
    private IAdvertDao advertDao;
    private Session session;

    public AdvertService(IAdvertDao advertDao, Session session) {
        super(advertDao, session);
        this.advertDao = advertDao;
        this.session = session;
    }

    @Override
    protected Class getChildClass() {
        return AdvertService.class;
    }
}

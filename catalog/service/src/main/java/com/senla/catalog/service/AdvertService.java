package com.senla.catalog.service;

import com.senla.catalog.daoapi.IAdvertDao;
import com.senla.catalog.entity.Advert;
import com.senla.catalog.entity.Category;
import com.senla.catalog.service.basic.AbstractService;
import com.senla.catalog.serviceapi.IAdvertService;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdvertService extends AbstractService<Advert, Integer> implements IAdvertService {

    private static final Logger logger = LoggerFactory.getLogger(AdvertService.class);

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
    public List<Advert> getAdvertListByCategory(Category category) {
        return advertDao.getAdvertListByCategory(category);
    }
}

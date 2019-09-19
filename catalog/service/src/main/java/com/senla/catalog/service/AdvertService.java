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

import java.util.Collections;
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
    public List<Advert> getByCategory(Category category) {
        return advertDao.getByCategory(category);
    }

    @Override
    public List<Advert> getByTitle(String title) {
        return advertDao.getByTitle(title);
    }

    @Override
    public List<Advert> getSortedByRating() {
        List<Advert> advertList = advertDao.getWithUser();
        advertList.sort(Collections.reverseOrder());
        return advertList;
    }

    @Override
    public List<Advert> getByCategorySortedByRating(Category category) {
        List<Advert> advertList = advertDao.getByCategoryWithUser(category);
        advertList.sort(Collections.reverseOrder());
        return advertList;
    }
}

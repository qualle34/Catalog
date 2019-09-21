package com.senla.catalog.service;

import com.senla.catalog.daoapi.IAdvertDao;
import com.senla.catalog.entity.Advert;
import com.senla.catalog.entity.Category;
import com.senla.catalog.entity.constants.AdvertType;
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
    protected String getDaoClassName() {
        return "advertDao";
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
    public List<Advert> getByType(AdvertType type) {
        return advertDao.getByType(type);
    }

    @Override
    public List<Advert> getByCategoryAndType(Category category, AdvertType type) {
        return advertDao.getByCategoryAndType(category, type);
    }

    @Override
    public List<Advert> getByTitle(String title) {
        return advertDao.getByTitle(title);
    }

    @Override
    public List<Advert> getByTitleAndType(String title, AdvertType type) {
        return advertDao.getByTitleAndType(title, type);
    }

    @Override
    public List<Advert> getAllSortedByVipAndRating() {
        return sort(advertDao.getAllWithUser());
    }

    @Override
    public List<Advert> getByCategorySortedByVipAndRating(Category category) {
        return sort(advertDao.getByCategoryWithUser(category));
    }

    @Override
    public List<Advert> getByTypeSortedByVipAndRating(AdvertType type) {
        return sort(advertDao.getByTypeWithUser(type));
    }

    @Override
    public List<Advert> getByCategoryAndTypeSortedByVipAndRating(Category category, AdvertType type) {
        return sort(advertDao.getByCategoryAndTypeWithUser(category, type));
    }

    private List<Advert> sort(List<Advert> advertList){
        advertList.sort(Collections.reverseOrder());
        return advertList;
    }
}
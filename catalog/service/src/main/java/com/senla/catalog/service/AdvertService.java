package com.senla.catalog.service;

import com.senla.catalog.daoapi.IAdvertDao;
import com.senla.catalog.entity.Advert;
import com.senla.catalog.entity.Category;
import com.senla.catalog.entity.User;
import com.senla.catalog.entity.constants.AdvertType;
import com.senla.catalog.service.basic.AbstractService;
import com.senla.catalog.serviceapi.IAdvertService;
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

        try {
            return advertDao.getByCategory(category);

        } catch (RuntimeException e) {
            logger.error("Get advert list by category error: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public List<Advert> getByType(AdvertType type) {

        try {
            return advertDao.getByType(type);

        } catch (RuntimeException e) {
            logger.error("Get advert list by type error: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public List<Advert> getByCategoryAndType(Category category, AdvertType type) {

        try {
            return advertDao.getByCategoryAndType(category, type);

        } catch (RuntimeException e) {
            logger.error("Get advert list by category and type error: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public List<Advert> getByTitle(String title) {

        try {
            return advertDao.getByTitle(title);

        } catch (RuntimeException e) {
            logger.error("Get advert list by title error: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public List<Advert> getByUser(User user) {

        try {
            return advertDao.getByUser(user);

        } catch (RuntimeException e) {
            logger.error("Get advert list by user error: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public List<Advert> getByTitleAndType(String title, AdvertType type) {

        try {
            return advertDao.getByTitleAndType(title, type);

        } catch (RuntimeException e) {
            logger.error("Get advert list by title and type error: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public List<Advert> getAllSorted() {

        try {
            return sort(advertDao.getAllWithUser());

        } catch (RuntimeException e) {
            logger.error("Get adverts with users error: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public List<Advert> getByCategorySorted(Category category) {

        try {
            return sort(advertDao.getByCategoryWithUser(category));

        } catch (RuntimeException e) {
            logger.error("Get adverts by category with users error: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public List<Advert> getByTypeSorted(AdvertType type) {

        try {
            return sort(advertDao.getByTypeWithUser(type));

        } catch (RuntimeException e) {
            logger.error("Get adverts by type with users error: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public List<Advert> getByCategoryAndTypeSorted(Category category, AdvertType type) {

        try {
            return sort(advertDao.getByCategoryAndTypeWithUser(category, type));

        } catch (RuntimeException e) {
            logger.error("Get adverts by category and type with users error: " + e.getMessage());
            throw e;
        }
    }

    private List<Advert> sort(List<Advert> advertList) {
        advertList.sort(Collections.reverseOrder());
        return advertList;
    }
}
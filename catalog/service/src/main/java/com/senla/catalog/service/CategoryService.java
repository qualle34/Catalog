package com.senla.catalog.service;

import com.senla.catalog.daoapi.ICategoryDao;
import com.senla.catalog.entity.Category;
import com.senla.catalog.service.basic.AbstractService;
import com.senla.catalog.serviceapi.ICategoryService;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService extends AbstractService<Category, Integer> implements ICategoryService {

    private static final Logger logger = LoggerFactory.getLogger(CategoryService.class);

    @Autowired
    private Session session;

    @Autowired
    private ICategoryDao categoryDao;

    @Override
    protected Class getChildClass() {
        return CategoryService.class;
    }

    @Override
    protected String getDaoClassName() {
        return "categoryDao";
    }

    @Override
    protected Class<Category> getEntityClass() {
        return Category.class;
    }

    @Override
    public Category getWithAdvertsByName(String name) throws RuntimeException {

        try {
            return categoryDao.getWithAdvertsByName(name);

        } catch (RuntimeException e) {
            logger.error("" + e.getMessage());
            throw e;
        }
    }
}

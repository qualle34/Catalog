package com.senla.catalog.service;

import com.senla.catalog.dao.CategoryDao;
import com.senla.catalog.daoapi.ICategoryDao;
import com.senla.catalog.entity.Category;
import com.senla.catalog.service.basic.AbstractService;
import com.senla.catalog.serviceapi.ICategoryService;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CategoryService extends AbstractService<Category, Integer> implements ICategoryService {

    private static CategoryService instance;
    private static final Logger logger = LoggerFactory.getLogger(CategoryService.class);
    private ICategoryDao categoryDao;
    private Session session;

    private CategoryService(ICategoryDao categoryDao, Session session) {
        super(categoryDao, session);
        this.categoryDao = categoryDao;
        this.session = session;
    }

    @Override
    protected Class getChildClass() {
        return CategoryService.class;
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

    public static CategoryService getInstance(Session session) {
        ICategoryDao categoryDao = CategoryDao.getInstance(session);

        if (instance == null) {
            instance = new CategoryService(categoryDao, session);
        }
        return instance;
    }
}

package com.senla.catalog.service;

import com.senla.catalog.daoapi.ICategoryDao;
import com.senla.catalog.entity.Category;
import com.senla.catalog.service.basic.AbstractService;
import com.senla.catalog.serviceapi.ICategoryService;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CategoryService extends AbstractService<Category, Integer> implements ICategoryService {

    private static final Logger logger = LoggerFactory.getLogger(CategoryService.class);
    private ICategoryDao categoryDao;
    private Session session;

    public CategoryService(ICategoryDao categoryDao, Session session) {
        super(categoryDao, session);
        this.categoryDao = categoryDao;
        this.session = session;
    }

    @Override
    protected Class getChildClass() {
        return CategoryService.class;
    }
}

package com.senla.catalog.dao;

import com.senla.catalog.dao.basic.AbstractDao;
import com.senla.catalog.daoapi.ICategoryDao;
import com.senla.catalog.entity.Category;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CategoryDao extends AbstractDao<Category, Integer> implements ICategoryDao {

    private static CategoryDao instance;
    private static final Logger logger = LoggerFactory.getLogger(CategoryDao.class);
    private Session session;

    private CategoryDao(Session session) {
        super(session);
        this.session = session;
    }

    @Override
    protected Class<Category> getChildClass() {
        return Category.class;
    }

    public static CategoryDao getInstance(Session session) {

        if (instance == null) {
            instance = new CategoryDao(session);
        }
        return instance;
    }
}

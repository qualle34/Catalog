package com.senla.catalog.dao;

import com.senla.catalog.dao.basic.AbstractDao;
import com.senla.catalog.daoapi.ICategoryDao;
import com.senla.catalog.entity.Category;
import org.hibernate.Session;

public class CategoryDao extends AbstractDao<Category, Integer> implements ICategoryDao {

    public CategoryDao(Session session) {
        super(session);
    }

    @Override
    protected Class<Category> getChildClass() {
        return Category.class;
    }
}

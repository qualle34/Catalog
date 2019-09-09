package com.senla.catalog.dao;

import com.senla.catalog.dao.basic.AbstractDao;
import com.senla.catalog.daoapi.ICategoryDao;
import com.senla.catalog.entity.Category;

public class CategoryDao extends AbstractDao<Category, Integer> implements ICategoryDao {

    @Override
    protected Class<Category> getChildClass() {
        return Category.class;
    }
}

package com.senla.catalog.dao;

import com.senla.catalog.daoapi.ICategoryDao;
import com.senla.catalog.entity.Category;

public class CategoryDao extends AbstractDao<Category, Integer> implements ICategoryDao {

    @Override
    protected String getSelectAllQuery() {
        return "SELECT c FROM Category c";
    }

    @Override
    protected Class<Category> getChildClass() {
        return Category.class;
    }
}

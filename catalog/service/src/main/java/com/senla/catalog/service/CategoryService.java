package com.senla.catalog.service;

import com.senla.catalog.dao.CategoryDao;
import com.senla.catalog.daoapi.ICategoryDao;
import com.senla.catalog.entity.Category;
import com.senla.catalog.serviceapi.ICategoryService;

import java.util.List;

public class CategoryService implements ICategoryService {

    private ICategoryDao categoryDao;

    public CategoryService() {
        categoryDao = new CategoryDao();
    }

    @Override
    public List<Category> getAll() {
        return categoryDao.getAll();
    }

    @Override
    public void add(Category category) {
        categoryDao.add(category);
    }

    @Override
    public Category get(Integer id) {
        return categoryDao.get(id);
    }

    @Override
    public void update(Category category) {
        categoryDao.update(category);
    }

    @Override
    public void delete(Category category) {
        categoryDao.delete(category);
    }
}

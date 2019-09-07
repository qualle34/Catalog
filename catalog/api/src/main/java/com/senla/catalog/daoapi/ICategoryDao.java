package com.senla.catalog.daoapi;

import com.senla.catalog.entity.Category;

import java.util.List;

public interface ICategoryDao extends IGenericDao<Category, Integer>  {

    @Override
    List<Category> getAll();

    @Override
    void add(Category category);

    @Override
    Category get(Integer integer);

    @Override
    void update(Category category);

    @Override
    void delete(Category category);
}

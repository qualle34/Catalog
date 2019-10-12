package com.senla.catalog.daoapi;

import com.senla.catalog.daoapi.basic.IGenericDao;
import com.senla.catalog.entity.Category;

import java.util.List;

public interface ICategoryDao extends IGenericDao<Category, Integer> {

    List<Category> getByTitle(String title);

    void delete(int id);
}

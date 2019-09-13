package com.senla.catalog.daoapi;

import com.senla.catalog.daoapi.basic.IGenericDao;
import com.senla.catalog.entity.Category;

public interface ICategoryDao extends IGenericDao<Category, Integer> {

    Category getWithAdvertsByName(String name);
}

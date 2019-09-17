package com.senla.catalog.daoapi;

import com.senla.catalog.daoapi.basic.IGenericDao;
import com.senla.catalog.entity.Advert;
import com.senla.catalog.entity.Category;

import java.util.List;

public interface IAdvertDao extends IGenericDao<Advert, Integer> {

    List<Advert> getAdvertListByCategory(Category category);
}

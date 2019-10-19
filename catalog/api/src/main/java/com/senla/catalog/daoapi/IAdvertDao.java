package com.senla.catalog.daoapi;

import com.senla.catalog.daoapi.basic.IGenericDao;
import com.senla.catalog.entity.Advert;
import com.senla.catalog.entity.enums.AdvertType;

import java.util.List;

public interface IAdvertDao extends IGenericDao<Advert, Long> {

    List<Advert> getByCategoryId(int categoryId);

    List<Advert> getByType(AdvertType type);

    List<Advert> getByCategoryIdAndType(int categoryId, AdvertType type);

    List<Advert> getByTitle(String title);

    List<Advert> getByUserId(long userId);

    List<Advert> getByTitleAndType(String title, AdvertType type);

    Advert getWithCommentsById(long id);

    void delete(long id);
}

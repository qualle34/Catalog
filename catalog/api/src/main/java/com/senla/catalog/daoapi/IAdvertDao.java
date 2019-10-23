package com.senla.catalog.daoapi;

import com.senla.catalog.daoapi.basic.IGenericDao;
import com.senla.catalog.entity.Advert;
import com.senla.catalog.entity.Type;
import com.senla.catalog.entity.enums.AdvertType;

import java.util.List;

public interface IAdvertDao extends IGenericDao<Advert, Long> {

    Advert getById(long id, long userId);

    List<Advert> getByCategory(int categoryId);

    List<Advert> getByType(AdvertType type);

    List<Advert> getByTitle(String title);

    List<Advert> getByCategoryAndType(int categoryId, AdvertType type);

    List<Advert> getByTitleAndType(String title, AdvertType type);

    List<Advert> getByUser(long userId);

    Type getTypeByName(AdvertType type);

    Advert getWithCommentsById(long id);

    Advert getWithCommentsById(long id, long userId);

    void delete(long id);

    void delete(long id, long userId);
}

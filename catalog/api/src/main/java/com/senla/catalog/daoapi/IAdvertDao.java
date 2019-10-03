package com.senla.catalog.daoapi;

import com.senla.catalog.daoapi.basic.IGenericDao;
import com.senla.catalog.dto.AdvertDto;
import com.senla.catalog.entity.Advert;
import com.senla.catalog.entity.Category;
import com.senla.catalog.entity.User;
import com.senla.catalog.entity.enums.AdvertType;

import java.util.List;

public interface IAdvertDao extends IGenericDao<Advert, Integer> {

    List<Advert> getByCategory(Category category);

    List<Advert> getByType(AdvertType type);

    List<Advert> getByCategoryAndType(Category category, AdvertType type);

    List<Advert> getByTitle(String title);

    List<Advert> getByUser(User user);

    List<Advert> getByTitleAndType(String title, AdvertType type);

    List<Advert> getAllWithUser();

    List<Advert> getByCategoryWithUser(Category category);

    List<Advert> getByTypeWithUser(AdvertType type);

    List<Advert> getByCategoryAndTypeWithUser(Category category, AdvertType type);

    Advert getByIdWithComments(int id);
}
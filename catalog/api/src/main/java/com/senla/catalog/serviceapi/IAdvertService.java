package com.senla.catalog.serviceapi;

import com.senla.catalog.entity.Advert;
import com.senla.catalog.entity.Category;
import com.senla.catalog.entity.User;
import com.senla.catalog.entity.constants.AdvertType;
import com.senla.catalog.serviceapi.basic.IGenericService;

import java.util.List;

public interface IAdvertService extends IGenericService<Advert, Integer> {

    List<Advert> getByCategory(Category category);

    List<Advert> getByType(AdvertType type);

    List<Advert> getByCategoryAndType(Category category, AdvertType type);

    List<Advert> getByTitle(String title);

    List<Advert> getByUser(User user);

    List<Advert> getByTitleAndType(String title, AdvertType type);

    List<Advert> getAllSorted();

    List<Advert> getByCategorySorted(Category category);

    List<Advert> getByTypeSorted(AdvertType type);

    List<Advert> getByCategoryAndTypeSorted(Category category, AdvertType type);
}

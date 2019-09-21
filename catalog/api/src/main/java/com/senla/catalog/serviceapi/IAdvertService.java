package com.senla.catalog.serviceapi;

import com.senla.catalog.entity.Advert;
import com.senla.catalog.entity.Category;
import com.senla.catalog.entity.constants.AdvertType;
import com.senla.catalog.serviceapi.basic.IGenericService;

import java.util.List;

public interface IAdvertService extends IGenericService<Advert, Integer> {

    List<Advert> getByCategory(Category category);

    List<Advert> getByType(AdvertType type);

    List<Advert> getByCategoryAndType(Category category, AdvertType type);

    List<Advert> getByTitle(String title);

    List<Advert> getByTitleAndType(String title, AdvertType type);

    List<Advert> getAllSortedByVipAndRating();

    List<Advert> getByCategorySortedByVipAndRating(Category category);

    List<Advert> getByTypeSortedByVipAndRating(AdvertType type);

    List<Advert> getByCategoryAndTypeSortedByVipAndRating(Category category, AdvertType type);
}

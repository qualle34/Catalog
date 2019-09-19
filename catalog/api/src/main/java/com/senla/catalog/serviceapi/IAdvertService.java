package com.senla.catalog.serviceapi;

import com.senla.catalog.entity.Advert;
import com.senla.catalog.entity.Category;
import com.senla.catalog.serviceapi.basic.IGenericService;

import java.util.List;

public interface IAdvertService extends IGenericService<Advert, Integer> {

    List<Advert> getByCategory(Category category);

    List<Advert> getByTitle(String title);

    List<Advert> getSortedByRating();

    List<Advert> getByCategorySortedByRating(Category category);
}

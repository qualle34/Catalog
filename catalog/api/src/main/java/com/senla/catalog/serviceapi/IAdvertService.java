package com.senla.catalog.serviceapi;

import com.senla.catalog.dto.AdvertDto;
import com.senla.catalog.dto.SimpleAdvertDto;
import com.senla.catalog.entity.Advert;
import com.senla.catalog.entity.Category;
import com.senla.catalog.entity.User;
import com.senla.catalog.entity.enums.AdvertType;
import com.senla.catalog.serviceapi.basic.IGenericService;

import java.util.List;

public interface IAdvertService extends IGenericService<Advert, Integer> {

    List<Advert> getByCategory(int categoryId);

    List<Advert> getByType(String type);

    List<Advert> getByCategoryAndType(int categoryId, String type);

    List<SimpleAdvertDto> getByTitle(String title);

    List<Advert> getByUserId(int userId);

    List<Advert> getByTitleAndType(String title, String type);

    List<SimpleAdvertDto> getAllSorted();

    List<SimpleAdvertDto> getByCategorySorted(int categoryId);

    List<SimpleAdvertDto> getByTypeSorted(String type);

    List<SimpleAdvertDto> getByCategoryAndTypeSorted(int categoryId, String type);

    List<SimpleAdvertDto> getDtoByUserId(int userId);

    AdvertDto getDtoByIdWithComments(int id);

    AdvertDto getDtoById(int id);

    List<SimpleAdvertDto> advertListToDto(List<Advert> advertList);

    AdvertDto advertToDto(Advert advert);

    Advert dtoToAdvert(AdvertDto dto);

    void update(AdvertDto dto);

    void add(AdvertDto dto);

    void addVip(int id);

    void delete(int id);
}

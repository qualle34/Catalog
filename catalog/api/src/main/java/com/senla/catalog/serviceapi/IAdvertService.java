package com.senla.catalog.serviceapi;

import com.senla.catalog.dto.advert.AdvertDto;
import com.senla.catalog.dto.advert.SimpleAdvertDto;
import com.senla.catalog.entity.Advert;
import com.senla.catalog.serviceapi.basic.IGenericService;

import java.util.List;

public interface IAdvertService extends IGenericService<Advert, Long> {

    List<Advert> getByCategoryId(int categoryId);

    List<Advert> getByType(String type);

    List<Advert> getByCategoryIdAndType(int categoryId, String type);

    List<Advert> getByTitle(String title);

    List<Advert> getByUserId(long userId);

    List<Advert> getByTitleAndType(String title, String type);

    List<SimpleAdvertDto> getDtoByTitle(String title);

    List<SimpleAdvertDto> getAllDtoSorted();

    List<SimpleAdvertDto> getDtoByCategorySorted(int categoryId);

    List<SimpleAdvertDto> getDtoByTypeSorted(String type);

    List<SimpleAdvertDto> getDtoByCategoryAndTypeSorted(int categoryId, String type);

    List<SimpleAdvertDto> getDtoByUserId(long userId);

    AdvertDto getDtoById(long id);

    AdvertDto getDtoWithCommentsById(long id);

    AdvertDto advertToDto(Advert advert);

    Advert dtoToAdvert(AdvertDto dto);

    List<SimpleAdvertDto> advertListToDto(List<Advert> advertList);

    void add(AdvertDto dto);

    void addVip(long id);

    void update(AdvertDto dto);

    void delete(long id);
}
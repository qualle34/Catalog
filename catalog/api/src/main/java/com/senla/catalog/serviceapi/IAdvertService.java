package com.senla.catalog.serviceapi;

import com.senla.catalog.dto.advert.AdvertDto;
import com.senla.catalog.dto.advert.SimpleAdvertDto;
import com.senla.catalog.entity.Advert;
import com.senla.catalog.serviceapi.basic.IGenericService;

import java.util.List;

public interface IAdvertService extends IGenericService<Advert, Long> {

    List<SimpleAdvertDto> getAllSorted();

    List<SimpleAdvertDto> getByCategory(int categoryId);

    List<SimpleAdvertDto> getByType(String type);

    List<SimpleAdvertDto> getByTitle(String title);

    List<SimpleAdvertDto> getByCategoryAndType(int categoryId, String type);

    List<SimpleAdvertDto> getByTitleAndType(String title, String type);

    List<SimpleAdvertDto> getByUser(long userId);

    AdvertDto getDtoById(long id);

    AdvertDto getWithCommentsById(long id);

    AdvertDto advertToDto(Advert advert);

    Advert dtoToAdvert(AdvertDto dto);

    List<SimpleAdvertDto> advertListToDto(List<Advert> advertList);

    void add(AdvertDto dto);

    void addVip(long id);

    void update(AdvertDto dto);

    void delete(long id);
}
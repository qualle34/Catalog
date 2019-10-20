package com.senla.catalog.serviceapi;

import com.senla.catalog.dto.advert.AdvertDto;
import com.senla.catalog.dto.advert.SimpleAdvertDto;
import com.senla.catalog.entity.Advert;
import com.senla.catalog.serviceapi.basic.IGenericService;

import java.util.List;

public interface IAdvertService extends IGenericService<Advert, Long> {

    List<SimpleAdvertDto> getAllDto();

    List<SimpleAdvertDto> getByCategory(int categoryId);

    List<SimpleAdvertDto> getByType(String type);

    List<SimpleAdvertDto> getByTitle(String title);

    List<SimpleAdvertDto> getByCategoryAndType(int categoryId, String type);

    List<SimpleAdvertDto> getByTitleAndType(String title, String type);

    List<SimpleAdvertDto> getByUser(long userId);

    List<SimpleAdvertDto> getByUser(String token);

    AdvertDto getDtoById(long id);

    AdvertDto getWithCommentsById(long id);

    AdvertDto getWithCommentsById(long id, String token);

    AdvertDto advertToDto(Advert advert);

    Advert dtoToAdvert(AdvertDto dto);

    List<SimpleAdvertDto> advertListToDto(List<Advert> advertList);

    void add(AdvertDto dto);

    void add(AdvertDto dto, String token);

    void addVip(long id);

    void addVip(long id, String token);

    void update(AdvertDto dto);

    void update(AdvertDto dto, String token);

    void delete(long id);

    void delete(long id, String token);
}
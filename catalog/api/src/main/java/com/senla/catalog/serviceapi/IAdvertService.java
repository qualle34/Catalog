package com.senla.catalog.serviceapi;


import com.senla.catalog.entity.Advert;

import java.util.List;

public interface IAdvertService {

    List<Advert> getAll();

    void add(Advert advert);

    Advert getById(Integer id);

    void update(Advert advert);

    void delete(Advert advert);
}

package com.senla.catalog.daoapi;

import com.senla.catalog.entity.Advert;

import java.util.List;

public interface IAdvertDao extends IGenericDao<Advert, Integer> {

    @Override
    List<Advert> getAll();

    @Override
    void add(Advert advert);

    @Override
    Advert get(Integer integer);

    @Override
    void update(Advert advert);

    @Override
    void delete(Advert advert);
}

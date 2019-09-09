package com.senla.catalog.service;

import com.senla.catalog.dao.AdvertDao;
import com.senla.catalog.daoapi.IAdvertDao;
import com.senla.catalog.entity.Advert;
import com.senla.catalog.serviceapi.IAdvertService;

import java.util.List;

public class AdvertService implements IAdvertService {

    private IAdvertDao advertDao;

    public AdvertService() {
        advertDao = new AdvertDao();
    }

    @Override
    public List<Advert> getAll() {
        return advertDao.getAll();
    }

    @Override
    public void add(Advert advert) {
        advertDao.add(advert);
    }

    @Override
    public Advert getById(Integer id) {
        return advertDao.getById(id);
    }

    @Override
    public void update(Advert advert) {
        advertDao.update(advert);
    }

    @Override
    public void delete(Advert advert) {
        advertDao.delete(advert);
    }
}

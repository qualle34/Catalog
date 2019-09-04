package com.senla.catalog.service;

import com.senla.catalog.dao.CatDao;
import com.senla.catalog.daoapi.ICatDao;
import com.senla.catalog.serviceapi.ICatService;

public class CatService implements ICatService {

    private ICatDao catDao;

    public CatService(){
        catDao = new CatDao();
    }

    @Override
    public void printCat(int id) {
        System.out.println(catDao.getCat(id));
    }
}

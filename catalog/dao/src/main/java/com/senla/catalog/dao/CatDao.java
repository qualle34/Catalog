package com.senla.catalog.dao;

import com.senla.catalog.daoapi.ICatDao;
import com.senla.catalog.entity.Cat;

public class CatDao implements ICatDao {

    @Override
    public Cat getCat(int in) {
        return new Cat(1, "Tom");
    }
}

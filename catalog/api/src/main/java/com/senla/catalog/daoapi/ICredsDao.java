package com.senla.catalog.daoapi;

import com.senla.catalog.entity.Creds;

import java.util.List;

public interface ICredsDao extends IGenericDao<Creds, Integer> {

    @Override
    List<Creds> getAll();

    @Override
    void add(Creds creds);

    @Override
    Creds get(Integer id);

    @Override
    void update(Creds creds);

    @Override
    void delete(Creds creds);
}

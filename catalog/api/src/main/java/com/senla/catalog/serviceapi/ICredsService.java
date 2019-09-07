package com.senla.catalog.serviceapi;

import com.senla.catalog.entity.Creds;

import java.util.List;

public interface ICredsService {

    List<Creds> getAll();

    void add(Creds creds);

    Creds get(Integer id);

    void update(Creds creds);

    void delete(Creds creds);
}

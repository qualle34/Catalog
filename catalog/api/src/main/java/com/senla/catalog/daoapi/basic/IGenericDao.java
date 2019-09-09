package com.senla.catalog.daoapi.basic;

import java.util.List;

public interface IGenericDao<T, PK> {

    List<T> getAll();

    void add(T t);

    T getById(PK pk);

    void update(T t);

    void delete(T t);
}

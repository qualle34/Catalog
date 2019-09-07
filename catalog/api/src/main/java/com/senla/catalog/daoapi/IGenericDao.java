package com.senla.catalog.daoapi;

import java.util.List;

public interface IGenericDao<T, PK> {

    List<T> getAll();

    void add(T t);

    T get(PK pk);

    void update(T t);

    void delete(T t);
}

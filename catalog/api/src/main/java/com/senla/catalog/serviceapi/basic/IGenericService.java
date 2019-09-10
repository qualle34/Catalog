package com.senla.catalog.serviceapi.basic;

import java.util.List;

public interface IGenericService<T, PK> {

    List<T> getAll();

    void add(T t);

    T getById(PK pk);

    void update(T t);

    void delete(T t);
}

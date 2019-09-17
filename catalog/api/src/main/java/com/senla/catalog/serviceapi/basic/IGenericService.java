package com.senla.catalog.serviceapi.basic;

import java.util.List;

public interface IGenericService<T, PK> {

    List<T> getAll();

    void add(T t);

    void addList(List<T> list);

    T getById(PK pk);

    void update(T t);

    void delete(T t);

    List<T> getEntitiesFromCsv();

    void exportToCsv(List<T> list);
}

package com.senla.db.dao;

import java.util.List;

public interface IDaoManager {

    List<Object> getAll();

    boolean add(Object entity);

    Object get(String pk);

    boolean update(Object entity);

    boolean delete(String pk);
}

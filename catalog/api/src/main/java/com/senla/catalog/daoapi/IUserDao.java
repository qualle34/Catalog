package com.senla.catalog.daoapi;

import com.senla.catalog.entity.User;

import java.util.List;

public interface IUserDao extends IGenericDao<User, Integer> {

    @Override
    List<User> getAll();

    @Override
    void add(User user);

    @Override
    User get(Integer id);

    @Override
    void update(User user);

    @Override
    void delete(User user);
}

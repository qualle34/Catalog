package com.senla.catalog.serviceapi;

import com.senla.catalog.entity.User;

import java.util.List;

public interface IUserService {

    List<User> getAll();

    void add(User user);

    User getById(Integer id);

    void update(User user);

    void delete(User user);
}

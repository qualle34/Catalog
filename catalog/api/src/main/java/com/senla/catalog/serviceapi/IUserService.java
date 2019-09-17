package com.senla.catalog.serviceapi;

import com.senla.catalog.entity.User;
import com.senla.catalog.serviceapi.basic.IGenericService;

import java.util.List;

public interface IUserService extends IGenericService<User, Integer> {

    List<User> getByName(String name);

    User getFullUserById(int id);

    User getUserWithCredsById(int id);

    void importFromCsv();
}

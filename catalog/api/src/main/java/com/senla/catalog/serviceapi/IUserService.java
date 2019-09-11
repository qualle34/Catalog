package com.senla.catalog.serviceapi;

import com.senla.catalog.entity.User;
import com.senla.catalog.serviceapi.basic.IGenericService;

public interface IUserService extends IGenericService<User, Integer> {

    User getByName(String name);
}

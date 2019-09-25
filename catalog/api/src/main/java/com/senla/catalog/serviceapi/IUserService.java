package com.senla.catalog.serviceapi;

import com.senla.catalog.entity.User;
import com.senla.catalog.serviceapi.basic.IGenericService;

import java.util.List;

public interface IUserService extends IGenericService<User, Integer> {

    List<User> getByName(String name);

    User getFullUserById(int id);

    String ObjectToJson(User user);

    String ObjectListToJson(List<User> userList);

    User JsonToObject(String user);

    List<User> JsonToObjectList(String user);
}

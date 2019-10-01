package com.senla.catalog.daoapi;

import com.senla.catalog.daoapi.basic.IGenericDao;
import com.senla.catalog.entity.User;

import java.util.List;

public interface IUserDao extends IGenericDao<User, Integer> {

    List<User> getByName(String name);

    User getWithChatList(int id);

    User getFullUserById(int id);
}

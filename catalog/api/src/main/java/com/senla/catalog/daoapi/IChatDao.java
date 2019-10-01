package com.senla.catalog.daoapi;

import com.senla.catalog.daoapi.basic.IGenericDao;
import com.senla.catalog.entity.Chat;
import com.senla.catalog.entity.User;

import java.util.List;

public interface IChatDao extends IGenericDao<Chat, Integer> {

    List<Chat> getByUser(User user);
}

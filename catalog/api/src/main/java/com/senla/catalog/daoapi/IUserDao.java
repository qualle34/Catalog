package com.senla.catalog.daoapi;

import com.senla.catalog.daoapi.basic.IGenericDao;
import com.senla.catalog.entity.User;

import java.util.List;

public interface IUserDao extends IGenericDao<User, Long> {

    List<User> getByName(String name);

    long getIdByLogin(String login);

    User getWithChatListById(long id);

    User getWithCredsByLogin(String login);

    User getWithCredsById(long id);

    User getWithRatingById(long id);

    User getWithCredsAndRatingById(long id);

    User getFullById(long id);

    void delete(long id);
}

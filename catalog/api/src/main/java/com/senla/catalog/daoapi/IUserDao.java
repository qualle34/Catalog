package com.senla.catalog.daoapi;

import com.senla.catalog.daoapi.basic.IGenericDao;
import com.senla.catalog.entity.Role;
import com.senla.catalog.entity.User;
import com.senla.catalog.entity.enums.UserRole;

public interface IUserDao extends IGenericDao<User, Long> {

    long getIdByLogin(String login);

    User getWithChatListById(long id);

    User getWithCredsByLogin(String login);

    User getWithCredsById(long id);

    User getWithRatingById(long id);

    User getWithCredsAndRatingById(long id);

    User getFullById(long id);

    Role getRoleByName(UserRole role);

    void delete(long id);
}

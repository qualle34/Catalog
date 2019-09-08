package com.senla.catalog.dao;

import com.senla.catalog.daoapi.IUserDao;
import com.senla.catalog.entity.User;

public class UserDao extends AbstractDao<User, Integer> implements IUserDao {

    @Override
    protected Class<User> getChildClass() {
        return User.class;
    }
}
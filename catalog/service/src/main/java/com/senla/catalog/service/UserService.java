package com.senla.catalog.service;

import com.senla.catalog.dao.UserDao;
import com.senla.catalog.daoapi.IUserDao;
import com.senla.catalog.entity.User;
import com.senla.catalog.serviceapi.IUserService;

import java.util.List;

public class UserService implements IUserService {

    private IUserDao userDao;

    public UserService() {
        userDao = new UserDao();
    }

    @Override
    public List<User> getAll() {
        return userDao.getAll();
    }

    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Override
    public User get(Integer id) {
        return userDao.get(id);
    }

    @Override
    public void update(User user) {
        userDao.update(user);
    }

    @Override
    public void delete(User user) {
        userDao.delete(user);
    }
}

package com.senla.catalog.service;

import com.senla.catalog.dao.UserDao;
import com.senla.catalog.dao.util.HibernateUtil;
import com.senla.catalog.daoapi.IUserDao;
import com.senla.catalog.entity.User;
import com.senla.catalog.serviceapi.IUserService;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class UserService implements IUserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);
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
    public User getById(Integer id) {
        return userDao.getById(id);
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

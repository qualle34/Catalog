package com.senla.catalog.service;

import com.senla.catalog.daoapi.IUserDao;
import com.senla.catalog.entity.User;
import com.senla.catalog.service.basic.AbstractService;
import com.senla.catalog.serviceapi.IUserService;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService extends AbstractService<User, Integer> implements IUserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private Session session;

    @Autowired
    private IUserDao userDao;

    @Override
    protected Class getChildClass() {
        return UserService.class;
    }

    @Override
    protected String getDaoClassName() {
        return "userDao";
    }

    @Override
    protected Class<User> getEntityClass() {
        return User.class;
    }

    @Override
    public List<User> getByName(String name) throws RuntimeException {
        return userDao.getByName(name);
    }

    @Override
    public User getFullUserById(int id) {
        return userDao.getFullUserById(id);
    }
}

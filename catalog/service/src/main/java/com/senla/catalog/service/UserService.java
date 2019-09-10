package com.senla.catalog.service;

import com.senla.catalog.daoapi.IUserDao;
import com.senla.catalog.entity.User;
import com.senla.catalog.service.basic.AbstractService;
import com.senla.catalog.serviceapi.IUserService;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserService extends AbstractService<User, Integer> implements IUserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);
    private IUserDao userDao;
    private Session session;

    public UserService(IUserDao userDao, Session session) {
        super(userDao, session);
        this.userDao = userDao;
        this.session = session;
    }
}

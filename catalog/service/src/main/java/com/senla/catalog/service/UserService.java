package com.senla.catalog.service;

import com.senla.catalog.dao.UserDao;
import com.senla.catalog.daoapi.IUserDao;
import com.senla.catalog.entity.User;
import com.senla.catalog.service.basic.AbstractService;
import com.senla.catalog.serviceapi.IUserService;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class UserService extends AbstractService<User, Integer> implements IUserService {

    private static UserService instance;
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);
    private IUserDao userDao;
    private Session session;

    private UserService(IUserDao userDao, Session session) {
        super(userDao, session);
        this.userDao = userDao;
        this.session = session;
    }

    @Override
    protected Class getChildClass() {
        return UserService.class;
    }

    @Override
    protected Class getEntityClass() {
        return User.class;
    }

    @Override
    public List<User> getByName(String name) throws RuntimeException {

        try {
            return userDao.getByName(name);

        } catch (RuntimeException e) {
            logger.error("Get by name error: " + e.getMessage());
            throw e;
        }
    }

    public void importFromCsv() {

        List<User> list = super.getEntitiesFromCsv();

        for (User user : list) {
            user.setId(0);
            user.getCreds().setId(0);
            user.getRating().setId(0);
        }
        super.addList(list);
    }

    public static UserService getInstance(Session session) {
        IUserDao userDao = UserDao.getInstance(session);

        if (instance == null) {
            instance = new UserService(userDao, session);
        }
        return instance;
    }
}

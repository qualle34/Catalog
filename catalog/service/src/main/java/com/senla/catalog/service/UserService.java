package com.senla.catalog.service;

import com.senla.catalog.daoapi.IUserDao;
import com.senla.catalog.daoapi.basic.IGenericDao;
import com.senla.catalog.entity.User;
import com.senla.catalog.service.basic.AbstractService;
import com.senla.catalog.serviceapi.IUserService;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
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
    protected Class<User> getEntityClass() {
        return User.class;
    }

    @Override
    protected Session getSession() {
        return session;
    }

    @Override
    protected IGenericDao getDao() {
        return userDao;
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

    @Bean
    public UserService getInstance() {
        return new UserService();
    }
}

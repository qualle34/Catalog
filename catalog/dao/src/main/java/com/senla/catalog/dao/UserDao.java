package com.senla.catalog.dao;

import com.senla.catalog.dao.basic.AbstractDao;
import com.senla.catalog.daoapi.IUserDao;
import com.senla.catalog.entity.User;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDao extends AbstractDao<User, Integer> implements IUserDao {

    private static final Logger logger = LoggerFactory.getLogger(UserDao.class);

    @Autowired
    private Session session;

    @Override
    protected Class getChildClass() {
        return UserDao.class;
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
    public List<User> getByName(String name) {

        try {
            Query query = session.createQuery("from User where firstname = :name ");
            query.setParameter("name", name);

            return query.list();

        } catch (RuntimeException e) {
            logger.error("Get user by name error: " + e.getMessage());
            throw e;
        }
    }

    @Bean
    public UserDao getInstance() {
        return new UserDao();
    }
}
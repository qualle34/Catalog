package com.senla.catalog.dao;

import com.senla.catalog.dao.basic.AbstractDao;
import com.senla.catalog.daoapi.IUserDao;
import com.senla.catalog.entity.User;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserDao extends AbstractDao<User, Integer> implements IUserDao {

    private static UserDao instance;
    private static final Logger logger = LoggerFactory.getLogger(UserDao.class);
    private Session session;

    private UserDao(Session session) {
        super(session);
        this.session = session;
    }

    @Override
    protected Class<User> getChildClass() {
        return User.class;
    }

    @Override
    public User getByName(String name) throws RuntimeException {

        try {
            Query query = session.createQuery("from User where firstname = :name ");
            query.setParameter("name", name);

            return (User) query.list().get(0);

        } catch (RuntimeException e) {
            logger.error("Get user by name error: " + e.getMessage());
            throw e;
        }
    }

    public static UserDao getInstance(Session session) {

        if (instance == null) {
            instance = new UserDao(session);
        }
        return instance;
    }
}
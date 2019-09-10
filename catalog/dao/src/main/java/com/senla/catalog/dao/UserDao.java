package com.senla.catalog.dao;

import com.senla.catalog.dao.basic.AbstractDao;
import com.senla.catalog.dao.util.HibernateUtil;
import com.senla.catalog.daoapi.IUserDao;
import com.senla.catalog.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class UserDao extends AbstractDao<User, Integer> implements IUserDao {

    public UserDao(Session session){
        super(session);
    }

    @Override
    protected Class<User> getChildClass() {
        return User.class;
    }


}
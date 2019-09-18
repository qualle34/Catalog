package com.senla.catalog.dao;

import com.senla.catalog.dao.basic.AbstractDao;
import com.senla.catalog.daoapi.IUserDao;
import com.senla.catalog.entity.User;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;
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

    @Override
    public User getFullUserById(int id) {
        return null;
    }

    @Override
    public User getUserWithCredsById(int id) {

        User user;
        CriteriaBuilder cb;
        CriteriaQuery query;
        Root root;

        try {
            cb = session.getCriteriaBuilder();
            query = cb.createQuery(User.class);
            root = query.from(User.class);

            root.fetch("creds", JoinType.LEFT);
            query.select(root).where(cb.equal(root.get("id"), id));

            user = (User) this.session.createQuery(query).getSingleResult();

        } catch (RuntimeException e) {
            logger.error("Get user with creds by id error: " + e.getMessage());
            throw e;
        }
        return user;
    }
}
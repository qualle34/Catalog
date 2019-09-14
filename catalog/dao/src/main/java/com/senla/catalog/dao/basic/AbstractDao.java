package com.senla.catalog.dao.basic;

import com.senla.catalog.daoapi.basic.IGenericDao;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.io.Serializable;
import java.util.List;

public abstract class AbstractDao<T, PK extends Serializable> implements IGenericDao<T, PK> {

    private final Logger logger = LoggerFactory.getLogger(getChildClass());

    protected abstract Class getChildClass();

    protected abstract Class<T> getEntityClass();

    protected abstract Session getSession();

    @Override
    public List<T> getAll() {
        List<T> list;
        Class cls = getEntityClass();
        Session session = getSession();

        try {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<T> criteria = builder.createQuery(cls);
            criteria.from(cls);
            list = session.createQuery(criteria).getResultList();

        } catch (RuntimeException e) {
            logger.error("Get all entities error: " + e.getMessage());
            throw e;
        }
        return list;
    }

    @Override
    public T getById(PK pk) {
        T t;

        try {
            t = getSession().get(getEntityClass(), pk);

        } catch (RuntimeException e) {
            logger.error("Get entity error: " + e.getMessage());
            throw e;
        }
        return t;
    }

    @Override
    public void add(T t) {

        try {
            getSession().save(t);

        } catch (RuntimeException e) {
            logger.error("Add entity error: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public void update(T t) {

        try {
            getSession().update(t);

        } catch (RuntimeException e) {
            logger.error("Update entity error: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public void delete(T t) {

        try {
            getSession().delete(t);

        } catch (RuntimeException e) {
            logger.error("Delete entity error: " + e.getMessage());
            throw e;
        }
    }
}

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
    private Session session;

    public AbstractDao(Session session) {
        this.session = session;
    }

    protected abstract Class<T> getChildClass();

    @Override
    public List<T> getAll() throws RuntimeException {
        List<T> list;
        Class cls = getChildClass();

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
    public T getById(PK pk) throws RuntimeException {
        T t;

        try {
            t = session.get(getChildClass(), pk);

        } catch (RuntimeException e) {
            logger.error("Get entity error: " + e.getMessage());
            throw e;
        }
        return t;
    }

    @Override
    public void add(T t) throws RuntimeException {

        try {
            session.save(t);

        } catch (RuntimeException e) {
            logger.error("Add entity error: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public void update(T t) throws RuntimeException {

        try {
            session.update(t);

        } catch (RuntimeException e) {
            logger.error("Update entity error: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public void delete(T t) throws RuntimeException {

        try {
            session.delete(t);

        } catch (RuntimeException e) {
            logger.error("Delete entity error: " + e.getMessage());
            throw e;
        }
    }
}

package com.senla.catalog.dao.basic;

import com.senla.catalog.daoapi.basic.IGenericDao;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.io.Serializable;
import java.util.List;

public abstract class AbstractDao<T, PK extends Serializable> implements IGenericDao<T, PK> {

    @Autowired
    private Session session;

    protected abstract Class<T> getEntityClass();

    @Override
    public List<T> getAll() {
        List<T> list;
        Class cls = getEntityClass();

        try {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<T> criteria = builder.createQuery(cls);
            criteria.from(cls);
            list = session.createQuery(criteria).getResultList();

        } catch (HibernateException e) {
            throw e;
        }
        return list;
    }

    @Override
    public T getById(PK pk) {
        T t;

        try {
            t = session.get(getEntityClass(), pk);
        } catch (HibernateException e) {
            throw e;
        }
        return t;
    }

    @Override
    public void add(T t) {

        try {
            session.save(t);
        } catch (HibernateException e) {
            throw e;
        }
    }

    @Override
    public void update(T t) {

        try {
            session.update(t);
        } catch (HibernateException e) {
            throw e;
        }
    }

    @Override
    public void delete(T t) {

        try {
            session.delete(t);
        } catch (HibernateException e) {
            throw e;
        }
    }
}

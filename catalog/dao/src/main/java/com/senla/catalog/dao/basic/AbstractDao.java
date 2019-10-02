package com.senla.catalog.dao.basic;

import com.senla.catalog.daoapi.basic.IGenericDao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.io.Serializable;
import java.util.List;

public abstract class AbstractDao<T, PK extends Serializable> implements IGenericDao<T, PK> {

    @PersistenceContext
    private EntityManager entityManager;

    protected abstract Class<T> getEntityClass();

    @Override
    public List<T> getAll() {
        List<T> list;
        Class cls = getEntityClass();

        try {
            CriteriaBuilder builder = entityManager.getCriteriaBuilder();
            CriteriaQuery<T> criteria = builder.createQuery(cls);
            criteria.from(cls);
            list = entityManager.createQuery(criteria).getResultList();

        } catch (RuntimeException e) {
            throw e;
        }
        return list;
    }

    @Override
    public T getById(PK pk) {
        T t;

        try {
            t = entityManager.find(getEntityClass(), pk);

        } catch (RuntimeException e) {
            throw e;
        }
        return t;
    }

    @Override
    public void add(T t) {

        try {
            entityManager.persist(t);

        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public void update(T t) {

        try {
            entityManager.merge(t);

        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public void delete(T t) {

        try {
            entityManager.remove(entityManager.contains(t) ? t : entityManager.merge(t));

        } catch (RuntimeException e) {
            throw e;
        }
    }
}

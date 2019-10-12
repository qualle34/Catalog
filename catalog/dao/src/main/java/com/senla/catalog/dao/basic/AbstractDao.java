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
        Class cls = getEntityClass();
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(cls);

        query.from(cls);

        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public T getById(PK pk) {
        return entityManager.find(getEntityClass(), pk);
    }

    @Override
    public void add(T t) {
        entityManager.persist(t);
    }

    @Override
    public void update(T t) {
        entityManager.merge(t);
    }

    @Override
    public void delete(T t) {
        entityManager.remove(entityManager.contains(t) ? t : entityManager.merge(t));
    }
}

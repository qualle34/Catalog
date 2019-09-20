package com.senla.catalog.service.basic;

import com.senla.catalog.daoapi.basic.IGenericDao;
import com.senla.catalog.serviceapi.basic.IGenericService;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public abstract class AbstractService<T, PK extends Serializable> implements IGenericService<T, PK> {

    private final Logger logger = LoggerFactory.getLogger(getChildClass());

    @Autowired
    private Session session;

    private IGenericDao dao;

    @Autowired
    private void setDao(Map<String, IGenericDao> daoMap) {
        this.dao = daoMap.get(getDaoClassName());
    }

    protected abstract Class getChildClass();

    protected abstract String getDaoClassName();

    protected abstract Class<T> getEntityClass();

    @Override
    public List<T> getAll() {
        return dao.getAll();
    }

    @Override
    public T getById(PK pk) {
        return (T) dao.getById(pk);
    }

    @Override
    public void add(T t) {
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            dao.add(t);
            transaction.commit();

        } catch (RuntimeException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw e;
        }
    }

    @Override
    public void update(T t) {
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            dao.update(t);
            transaction.commit();

        } catch (RuntimeException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw e;
        }
    }

    @Override
    public void delete(T t) {
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            dao.delete(t);
            transaction.commit();

        } catch (RuntimeException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw e;
        }
    }
}

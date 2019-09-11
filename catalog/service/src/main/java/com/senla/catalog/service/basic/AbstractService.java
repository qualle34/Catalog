package com.senla.catalog.service.basic;

import com.senla.catalog.daoapi.basic.IGenericDao;
import com.senla.catalog.serviceapi.basic.IGenericService;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.util.List;

public abstract class AbstractService<T, PK extends Serializable> implements IGenericService<T, PK> {

    private final Logger logger = LoggerFactory.getLogger(getChildClass());
    private IGenericDao genericDao;
    private Session session;

    public AbstractService(IGenericDao genericDao, Session session) {
        this.genericDao = genericDao;
        this.session = session;
    }

    protected abstract Class getChildClass();

    @Override
    public List<T> getAll() throws RuntimeException {
        List<T> list;

        try {
            list = genericDao.getAll();
        } catch (RuntimeException e) {
            logger.error("Get all error" + e.getMessage());
            throw e;
        }
        return list;
    }

    @Override
    public void add(T t) throws RuntimeException {
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            genericDao.add(t);
            transaction.commit();

        } catch (RuntimeException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            logger.error("Add error: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public T getById(PK pk) throws RuntimeException {
        T t;

        try {
            t = (T) genericDao.getById(pk);
        } catch (RuntimeException e) {
            logger.error("Get by id error" + e.getMessage());
            throw e;
        }
        return t;
    }

    @Override
    public void update(T t) throws RuntimeException {
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            genericDao.update(t);
            transaction.commit();

        } catch (RuntimeException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            logger.error("Update error: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public void delete(T t) throws RuntimeException {
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();

            genericDao.delete(t);
            transaction.commit();

        } catch (RuntimeException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            logger.error("Delete error: " + e.getMessage());
            throw e;
        }
    }
}

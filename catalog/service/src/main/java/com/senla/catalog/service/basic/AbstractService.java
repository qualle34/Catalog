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
    public List<T> getAll() {
        List<T> list = null;
        try {
            list = genericDao.getAll();
        } catch (RuntimeException e) {
            logger.error("Get all error" + e.getMessage());
        }
        return list;
    }

    @Override
    public void add(T t) {
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();

            genericDao.add(t);
            transaction.commit();

        } catch (RuntimeException re) {
            if (transaction != null) {
                transaction.rollback();
            }
            logger.error("Add error: " + re.getMessage());
        }
    }

    @Override
    public T getById(PK pk) {
        T t = null;
        try {
            t = (T) genericDao.getById(pk);
        } catch (RuntimeException e) {
            logger.error("Get by id error" + e.getMessage());
        }
        return t;
    }

    @Override
    public void update(T t) {
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();

            genericDao.update(t);
            transaction.commit();

        } catch (RuntimeException re) {
            if (transaction != null) {
                transaction.rollback();
            }
            logger.error("Update error: " + re.getMessage());
        }
    }

    @Override
    public void delete(T t) {
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();

            genericDao.delete(t);
            transaction.commit();

        } catch (RuntimeException re) {
            if (transaction != null) {
                transaction.rollback();
            }
            logger.error("Delete error: " + re.getMessage());
        }
    }
}

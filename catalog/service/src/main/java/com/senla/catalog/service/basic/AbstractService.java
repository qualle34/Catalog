package com.senla.catalog.service.basic;

import com.senla.catalog.daoapi.basic.IGenericDao;
import com.senla.catalog.serviceapi.basic.IGenericService;
import com.senla.csvhelper.CsvService;
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
    protected abstract Class getEntityClass();

    @Override
    public List<T> getAll() {
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
    public void add(T t) {
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
    public void addList(List<T> list) {

        try {
            for (T t : list) {
                add(t);
            }

        } catch (RuntimeException e) {
            logger.error("Add list error: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public T getById(PK pk) {
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
    public void update(T t) {
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
    public void delete(T t) {
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

    @Override
    public List<T> getEntitiesFromCsv() {

        try {
            return (List<T>) new CsvService().read(getEntityClass());

        } catch (RuntimeException e) {
            logger.error("Import from csv error: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public void exportToCsv(List<T> list) {

        try {
            CsvService csvService = new CsvService();
            csvService.write((List<Object>) list);

        } catch (RuntimeException e) {
            logger.error("Export to csv error: " + e.getMessage());
            throw e;
        }
    }
}

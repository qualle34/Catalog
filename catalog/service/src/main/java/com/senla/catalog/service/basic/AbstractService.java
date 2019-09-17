package com.senla.catalog.service.basic;

import com.senla.catalog.daoapi.basic.IGenericDao;
import com.senla.catalog.serviceapi.basic.IGenericService;
import com.senla.csvhelper.CsvService;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

public abstract class AbstractService<T, PK extends Serializable> implements IGenericService<T, PK> {

    private final Logger logger = LoggerFactory.getLogger(getChildClass());

    @Autowired
    private Session session;

    private IGenericDao dao;

    @Autowired
    private void setDao(List<IGenericDao> daoList) {
        for (IGenericDao dao : daoList) {
            if (dao.getClass().getSimpleName().equals(getEntityClass().getSimpleName() + "Dao")) {
                this.dao = dao;
            }
        }
    }

    protected abstract Class getChildClass();

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
    public void addList(List<T> list) {

        for (T t : list) {
            add(t);
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

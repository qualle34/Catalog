package com.senla.catalog.service.basic;

import com.senla.catalog.daoapi.basic.IGenericDao;
import com.senla.catalog.serviceapi.basic.IGenericService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public abstract class AbstractService<T, PK extends Serializable> implements IGenericService<T, PK> {

    private final Logger logger = LoggerFactory.getLogger(getChildClass());

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

        try {
            return dao.getAll();

        } catch (RuntimeException e) {
            logger.error("Get all entities error: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public T getById(PK pk) {

        try {
            return (T) dao.getById(pk);

        } catch (RuntimeException e) {
            logger.error("Get entity by id error: " + e.getMessage());
            throw e;
        }
    }

    @Override
    @Transactional
    public void add(T t) {

        try {
            dao.add(t);

        } catch (RuntimeException e) {
            logger.error("Add entity error: " + e.getMessage());
            throw e;
        }
    }

    @Override
    @Transactional
    public void update(T t) {

        try {
            dao.update(t);

        } catch (RuntimeException e) {
            logger.error("Update entity error: " + e.getMessage());
            throw e;
        }
    }

    @Override
    @Transactional
    public void delete(T t) {

        try {
            dao.delete(t);

        } catch (RuntimeException e) {
            logger.error("Delete entity error: " + e.getMessage());
            throw e;
        }
    }
}

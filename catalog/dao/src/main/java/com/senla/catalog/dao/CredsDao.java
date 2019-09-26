package com.senla.catalog.dao;

import com.senla.catalog.dao.basic.AbstractDao;
import com.senla.catalog.daoapi.ICredsDao;
import com.senla.catalog.entity.Creds;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class CredsDao extends AbstractDao<Creds, Integer> implements ICredsDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    protected Class<Creds> getEntityClass() {
        return Creds.class;
    }
}

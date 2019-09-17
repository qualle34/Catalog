package com.senla.catalog.dao;

import com.senla.catalog.dao.basic.AbstractDao;
import com.senla.catalog.daoapi.ICredsDao;
import com.senla.catalog.entity.Creds;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

@Repository
public class CredsDao extends AbstractDao<Creds, Integer> implements ICredsDao {

    private static final Logger logger = LoggerFactory.getLogger(CredsDao.class);

    @Autowired
    private Session session;

    @Override
    protected Class getChildClass() {
        return CredsDao.class;
    }

    @Override
    protected Class<Creds> getEntityClass() {
        return Creds.class;
    }
}

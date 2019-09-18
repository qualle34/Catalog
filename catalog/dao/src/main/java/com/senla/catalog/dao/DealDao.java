package com.senla.catalog.dao;

import com.senla.catalog.dao.basic.AbstractDao;
import com.senla.catalog.daoapi.IDealDao;
import com.senla.catalog.entity.Deal;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DealDao extends AbstractDao<Deal, Integer> implements IDealDao {

    private static final Logger logger = LoggerFactory.getLogger(DealDao.class);

    @Autowired
    private Session session;

    @Override
    protected Class getChildClass() {
        return DealDao.class;
    }

    @Override
    protected Class<Deal> getEntityClass() {
        return Deal.class;
    }
}

package com.senla.catalog.dao;

import com.senla.catalog.dao.basic.AbstractDao;
import com.senla.catalog.dao.util.HibernateUtil;
import com.senla.catalog.daoapi.ISalesHistoryDao;
import com.senla.catalog.entity.SalesHistory;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

@Repository
public class SalesHistoryDao extends AbstractDao<SalesHistory, Integer> implements ISalesHistoryDao {

    private static final Logger logger = LoggerFactory.getLogger(SalesHistoryDao.class);

    @Autowired
    private Session session;

    @Override
    protected Class getChildClass() {
        return SalesHistoryDao.class;
    }

    @Override
    protected Class<SalesHistory> getEntityClass() {
        return SalesHistory.class;
    }

    @Override
    protected Session getSession() {
        return session;
    }

    @Bean
    public SalesHistoryDao getInstance() {
        return new SalesHistoryDao();
    }
}

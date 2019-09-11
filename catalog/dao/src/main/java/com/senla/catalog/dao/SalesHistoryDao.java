package com.senla.catalog.dao;

import com.senla.catalog.dao.basic.AbstractDao;
import com.senla.catalog.daoapi.ISalesHistoryDao;
import com.senla.catalog.entity.SalesHistory;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SalesHistoryDao extends AbstractDao<SalesHistory, Integer> implements ISalesHistoryDao {

    private static SalesHistoryDao instance;
    private static final Logger logger = LoggerFactory.getLogger(SalesHistoryDao.class);
    private Session session;

    private SalesHistoryDao(Session session) {
        super(session);
        this.session = session;
    }

    @Override
    protected Class<SalesHistory> getChildClass() {
        return SalesHistory.class;
    }

    public static SalesHistoryDao getInstance(Session session) {

        if (instance == null) {
            instance = new SalesHistoryDao(session);
        }
        return instance;
    }
}

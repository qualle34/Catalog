package com.senla.catalog.dao;

import com.senla.catalog.dao.basic.AbstractDao;
import com.senla.catalog.daoapi.ISalesHistoryDao;
import com.senla.catalog.entity.SalesHistory;
import org.hibernate.Session;

public class SalesHistoryDao extends AbstractDao<SalesHistory, Integer> implements ISalesHistoryDao {

    public SalesHistoryDao(Session session) {
        super(session);
    }

    @Override
    protected Class<SalesHistory> getChildClass() {
        return SalesHistory.class;
    }
}

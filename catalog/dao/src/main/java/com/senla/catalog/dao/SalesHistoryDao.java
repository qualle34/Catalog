package com.senla.catalog.dao;

import com.senla.catalog.daoapi.ISalesHistoryDao;
import com.senla.catalog.entity.SalesHistory;

public class SalesHistoryDao extends AbstractDao<SalesHistory, Integer> implements ISalesHistoryDao {

    @Override
    protected String getSelectAllQuery() {
        return "SELECT s FROM SalesHistory s";
    }

    @Override
    protected Class<SalesHistory> getChildClass() {
        return SalesHistory.class;
    }
}

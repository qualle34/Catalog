package com.senla.catalog.service;

import com.senla.catalog.dao.SalesHistoryDao;
import com.senla.catalog.daoapi.ISalesHistoryDao;
import com.senla.catalog.entity.SalesHistory;
import com.senla.catalog.serviceapi.ISalesHistoryService;

import java.util.List;

public class SalesHistoryService implements ISalesHistoryService {

    private ISalesHistoryDao salesHistoryDao;

    public SalesHistoryService() {
        salesHistoryDao = new SalesHistoryDao();
    }

    @Override
    public List<SalesHistory> getAll() {
        return salesHistoryDao.getAll();
    }

    @Override
    public void add(SalesHistory sh) {
        salesHistoryDao.add(sh);
    }

    @Override
    public SalesHistory getById(Integer id) {
        return salesHistoryDao.getById(id);
    }

    @Override
    public void update(SalesHistory sh) {
        salesHistoryDao.update(sh);
    }

    @Override
    public void delete(SalesHistory sh) {
        salesHistoryDao.delete(sh);
    }
}

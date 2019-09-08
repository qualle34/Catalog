package com.senla.catalog.service;

import com.senla.catalog.dao.CredsDao;
import com.senla.catalog.daoapi.ICredsDao;
import com.senla.catalog.entity.Creds;
import com.senla.catalog.serviceapi.ICredsService;

import java.util.List;

public class CredsService implements ICredsService {

    private ICredsDao credsDao;

    public CredsService() {
        credsDao = new CredsDao();
    }

    @Override
    public List<Creds> getAll() {
        return credsDao.getAll();
    }

    @Override
    public void add(Creds creds) {
        credsDao.add(creds);
    }

    @Override
    public Creds get(Integer id) {
        return credsDao.get(id);
    }

    @Override
    public void update(Creds creds) {
        credsDao.update(creds);
    }

    @Override
    public void delete(Creds creds) {
        credsDao.delete(creds);
    }
}

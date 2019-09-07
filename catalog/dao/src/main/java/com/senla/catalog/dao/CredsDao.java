package com.senla.catalog.dao;

import com.senla.catalog.daoapi.ICredsDao;
import com.senla.catalog.entity.Creds;

public class CredsDao extends AbstractDao<Creds, Integer> implements ICredsDao {

    @Override
    protected String getSelectAllQuery() {
        return "SELECT c FROM Creds c";
    }

    @Override
    protected Class<Creds> getGenericClass() {
        return Creds.class;
    }
}

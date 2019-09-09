package com.senla.catalog.dao;

import com.senla.catalog.dao.basic.AbstractDao;
import com.senla.catalog.daoapi.ICredsDao;
import com.senla.catalog.entity.Creds;

public class CredsDao extends AbstractDao<Creds, Integer> implements ICredsDao {

    @Override
    protected Class<Creds> getChildClass() {
        return Creds.class;
    }
}

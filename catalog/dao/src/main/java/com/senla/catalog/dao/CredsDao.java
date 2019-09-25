package com.senla.catalog.dao;

import com.senla.catalog.dao.basic.AbstractDao;
import com.senla.catalog.daoapi.ICredsDao;
import com.senla.catalog.entity.Creds;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CredsDao extends AbstractDao<Creds, Integer> implements ICredsDao {

    @Autowired
    private Session session;

    @Override
    protected Class<Creds> getEntityClass() {
        return Creds.class;
    }
}

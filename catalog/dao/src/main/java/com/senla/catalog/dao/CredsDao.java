package com.senla.catalog.dao;

import com.senla.catalog.dao.basic.AbstractDao;
import com.senla.catalog.daoapi.ICredsDao;
import com.senla.catalog.entity.Creds;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CredsDao extends AbstractDao<Creds, Integer> implements ICredsDao {

    private static CredsDao instance;
    private static final Logger logger = LoggerFactory.getLogger(CredsDao.class);
    private Session session;

    private CredsDao(Session session) {
        super(session);
        this.session = session;
    }

    @Override
    protected Class<Creds> getChildClass() {
        return Creds.class;
    }

    public static CredsDao getInstance(Session session) {

        if (instance == null) {
            instance = new CredsDao(session);
        }
        return instance;
    }
}

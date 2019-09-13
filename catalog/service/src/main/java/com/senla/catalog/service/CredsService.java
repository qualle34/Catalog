package com.senla.catalog.service;

import com.senla.catalog.dao.CredsDao;
import com.senla.catalog.daoapi.ICredsDao;
import com.senla.catalog.entity.Creds;
import com.senla.catalog.service.basic.AbstractService;
import com.senla.catalog.serviceapi.ICredsService;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CredsService extends AbstractService<Creds, Integer> implements ICredsService {

    private static CredsService instance;
    private static final Logger logger = LoggerFactory.getLogger(CredsService.class);
    private ICredsDao credsDao;
    private Session session;

    private CredsService(ICredsDao credsDao, Session session) {
        super(credsDao, session);
        this.credsDao = credsDao;
        this.session = session;
    }

    @Override
    protected Class getChildClass() {
        return CredsService.class;
    }

    @Override
    protected Class getEntityClass() {
        return Creds.class;
    }

    public static CredsService getInstance(Session session) {
        ICredsDao credsDao = CredsDao.getInstance(session);

        if (instance == null) {
            instance = new CredsService(credsDao, session);
        }
        return instance;
    }
}

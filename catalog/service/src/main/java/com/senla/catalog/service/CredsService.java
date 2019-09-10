package com.senla.catalog.service;

import com.senla.catalog.daoapi.ICredsDao;
import com.senla.catalog.entity.Creds;
import com.senla.catalog.service.basic.AbstractService;
import com.senla.catalog.serviceapi.ICredsService;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CredsService extends AbstractService<Creds, Integer> implements ICredsService {

    private static final Logger logger = LoggerFactory.getLogger(CredsService.class);
    private ICredsDao credsDao;
    private Session session;

    public CredsService(ICredsDao credsDao, Session session) {
        super(credsDao, session);
        this.credsDao = credsDao;
        this.session = session;
    }
}

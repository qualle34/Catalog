package com.senla.catalog.service;

import com.senla.catalog.daoapi.ICredsDao;
import com.senla.catalog.daoapi.basic.IGenericDao;
import com.senla.catalog.entity.Creds;
import com.senla.catalog.service.basic.AbstractService;
import com.senla.catalog.serviceapi.ICredsService;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class CredsService extends AbstractService<Creds, Integer> implements ICredsService {

    private static final Logger logger = LoggerFactory.getLogger(CredsService.class);

    @Autowired
    private Session session;

    @Autowired
    private ICredsDao credsDao;

    @Override
    protected Class getChildClass() {
        return CredsService.class;
    }

    @Override
    protected Class<Creds> getEntityClass() {
        return Creds.class;
    }

    @Override
    protected Session getSession() {
        return session;
    }

    @Override
    protected IGenericDao getDao() {
        return credsDao;
    }

    @Bean
    public CredsService getInstance() {
        return new CredsService();
    }
}

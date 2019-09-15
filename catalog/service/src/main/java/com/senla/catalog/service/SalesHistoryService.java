package com.senla.catalog.service;

import com.senla.catalog.daoapi.ISalesHistoryDao;
import com.senla.catalog.daoapi.basic.IGenericDao;
import com.senla.catalog.entity.SalesHistory;
import com.senla.catalog.service.basic.AbstractService;
import com.senla.catalog.serviceapi.ISalesHistoryService;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class SalesHistoryService extends AbstractService<SalesHistory, Integer> implements ISalesHistoryService {

    private static final Logger logger = LoggerFactory.getLogger(SalesHistoryService.class);

    @Autowired
    private Session session;

    @Autowired
    private ISalesHistoryDao salesHistoryDao;

    @Override
    protected Class getChildClass() {
        return SalesHistoryService.class;
    }

    @Override
    protected Class<SalesHistory> getEntityClass() {
        return SalesHistory.class;
    }

    @Override
    protected Session getSession() {
        return session;
    }

    @Override
    protected IGenericDao getDao() {
        return salesHistoryDao;
    }

    @Bean
    public SalesHistoryService getInstance() {
        return new SalesHistoryService();
    }
}

package com.senla.catalog.service;

import com.senla.catalog.daoapi.ISalesHistoryDao;
import com.senla.catalog.entity.SalesHistory;
import com.senla.catalog.service.basic.AbstractService;
import com.senla.catalog.serviceapi.ISalesHistoryService;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SalesHistoryService extends AbstractService<SalesHistory, Integer> implements ISalesHistoryService {

    private static final Logger logger = LoggerFactory.getLogger(SalesHistoryService.class);
    private ISalesHistoryDao salesHistoryDao;
    private Session session;

    public SalesHistoryService(ISalesHistoryDao salesHistoryDao, Session session) {
        super(salesHistoryDao, session);
        this.salesHistoryDao = salesHistoryDao;
        this.session = session;
    }

    @Override
    protected Class getChildClass() {
        return SalesHistoryService.class;
    }
}

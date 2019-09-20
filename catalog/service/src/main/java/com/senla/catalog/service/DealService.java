package com.senla.catalog.service;

import com.senla.catalog.daoapi.IDealDao;
import com.senla.catalog.entity.Deal;
import com.senla.catalog.service.basic.AbstractService;
import com.senla.catalog.serviceapi.IDealService;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DealService extends AbstractService<Deal, Integer> implements IDealService {

    private static final Logger logger = LoggerFactory.getLogger(DealService.class);

    @Autowired
    private Session session;

    @Autowired
    private IDealDao dealDao;

    @Override
    protected Class getChildClass() {
        return DealService.class;
    }

    @Override
    protected String getDaoClassName() {
        return "dealDao";
    }

    @Override
    protected Class<Deal> getEntityClass() {
        return Deal.class;
    }
}

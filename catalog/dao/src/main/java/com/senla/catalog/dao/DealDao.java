package com.senla.catalog.dao;

import com.senla.catalog.dao.basic.AbstractDao;
import com.senla.catalog.daoapi.IDealDao;
import com.senla.catalog.entity.Deal;
import com.senla.catalog.entity.User;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DealDao extends AbstractDao<Deal, Integer> implements IDealDao {

    private static final Logger logger = LoggerFactory.getLogger(DealDao.class);

    @Autowired
    private Session session;

    @Override
    protected Class getChildClass() {
        return DealDao.class;
    }

    @Override
    protected Class<Deal> getEntityClass() {
        return Deal.class;
    }

    @Override
    public List<Deal> getDealListBySeller(User seller) {

        try {
            Query query = session.createQuery("from Deal where seller = :seller ");
            query.setParameter("seller", seller);

            return query.list();

        } catch (RuntimeException e) {
            logger.error("Get deal list by seller error: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public List<Deal> getDealListByBuyer(User buyer) {

        try {
            Query query = session.createQuery("from Deal where buyer = :buyer ");
            query.setParameter("buyer", buyer);

            return query.list();

        } catch (RuntimeException e) {
            logger.error("Get deal list by buyer error: " + e.getMessage());
            throw e;
        }
    }
}

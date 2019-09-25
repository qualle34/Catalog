package com.senla.catalog.dao;

import com.senla.catalog.dao.basic.AbstractDao;
import com.senla.catalog.daoapi.IDealDao;
import com.senla.catalog.entity.Deal;
import com.senla.catalog.entity.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DealDao extends AbstractDao<Deal, Integer> implements IDealDao {

    @Autowired
    private Session session;

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

        } catch (HibernateException e) {
            throw e;
        }
    }

    @Override
    public List<Deal> getDealListByBuyer(User buyer) {

        try {
            Query query = session.createQuery("from Deal where buyer = :buyer ");
            query.setParameter("buyer", buyer);

            return query.list();

        } catch (HibernateException e) {
            throw e;
        }
    }
}

package com.senla.catalog.dao;

import com.senla.catalog.dao.basic.AbstractDao;
import com.senla.catalog.daoapi.IDealDao;
import com.senla.catalog.entity.Deal;
import com.senla.catalog.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class DealDao extends AbstractDao<Deal, Integer> implements IDealDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    protected Class<Deal> getEntityClass() {
        return Deal.class;
    }

    @Override
    public List<Deal> getDealListBySeller(User seller) {

        try {
            Query query = entityManager.createQuery("from Deal where seller = :seller ");
            query.setParameter("seller", seller);

            return query.getResultList();

        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public List<Deal> getDealListByBuyer(User buyer) {

        try {
            Query query = entityManager.createQuery("from Deal where buyer = :buyer ");
            query.setParameter("buyer", buyer);

            return query.getResultList();

        } catch (RuntimeException e) {
            throw e;
        }
    }
}

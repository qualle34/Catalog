package com.senla.catalog.dao;

import com.senla.catalog.dao.basic.AbstractDao;
import com.senla.catalog.daoapi.IDealDao;
import com.senla.catalog.entity.Deal;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class DealDao extends AbstractDao<Deal, Long> implements IDealDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    protected Class<Deal> getEntityClass() {
        return Deal.class;
    }

    @Override
    public List<Deal> getBySeller(long sellerId) {
        Query query = entityManager.createQuery("SELECT d FROM Deal d WHERE d.seller.id = :sellerId ", Deal.class);
        query.setParameter("sellerId", sellerId);

        return query.getResultList();
    }

    @Override
    public List<Deal> getByBuyer(long buyerId) {
        Query query = entityManager.createQuery("SELECT d FROM Deal d WHERE d.buyer.id = :buyerId ", Deal.class);
        query.setParameter("buyerId", buyerId);

        return query.getResultList();
    }
}

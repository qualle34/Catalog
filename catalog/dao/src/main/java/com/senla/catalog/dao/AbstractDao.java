package com.senla.catalog.dao;

import com.senla.catalog.dao.util.HibernateUtil;
import com.senla.catalog.daoapi.IGenericDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.io.Serializable;
import java.util.List;

public abstract class AbstractDao<T, PK extends Serializable> implements IGenericDao<T, PK> {

    private final Logger logger = LoggerFactory.getLogger(getChildClass());
    private SessionFactory sessionFactory;

    public AbstractDao() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    protected abstract Class<T> getChildClass();

    @Override
    public List<T> getAll() {
        List<T> list = null;
        Class cls = getChildClass();

        try (Session session = sessionFactory.openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<T> criteria = builder.createQuery(cls);
            criteria.from(cls);
            list = session.createQuery(criteria).getResultList();

        } catch (Exception e) {
            logger.error("Get all entities error: " + e.getMessage());
        }
        return list;
    }


    @Override
    public T get(PK pk) {
        T t = null;

        try (Session session = sessionFactory.openSession()) {
            t = session.get(getChildClass(), pk);

        } catch (Exception e) {
            logger.error("Get entity error: " + e.getMessage());
        }
        return t;
    }

    @Override
    public void add(T t) {
        Transaction transaction = null;

        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.persist(t);
            transaction.commit();

        } catch (Exception e) {
            logger.error("Add entity error: " + e.getMessage());

            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    @Override
    public void update(T t) {
        Transaction transaction = null;

        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.update(t);
            transaction.commit();

        } catch (Exception e) {
            logger.error("Update entity error: " + e.getMessage());

            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    @Override
    public void delete(T t) {
        Transaction transaction = null;

        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.delete(t);
            transaction.commit();

        } catch (Exception e) {
            logger.error("Delete entity error: " + e.getMessage());

            if (transaction != null) {
                transaction.rollback();
            }
        }
    }
}

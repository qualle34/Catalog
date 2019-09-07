package com.senla.catalog.dao;

import com.senla.catalog.dao.util.HibernateUtil;
import com.senla.catalog.daoapi.IGenericDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.io.Serializable;
import java.util.List;

public abstract class AbstractDao<T, PK extends Serializable> implements IGenericDao<T, PK> {

    private SessionFactory sessionFactory;
    private Session session;

    public AbstractDao() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    protected Session getSession() {
        return sessionFactory.openSession();
    }

    protected abstract String getSelectAllQuery();

    protected abstract Class<T> getGenericClass();

    @Override
    public List<T> getAll() {
        List<T> list = null;

        try {
            session = getSession();
            list = session.createQuery(getSelectAllQuery(), getGenericClass()).getResultList();

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            if (session != null) {
                session.close();
            }
        }
        return list;
    }

    @Override
    public T get(PK pk) {
        T t = null;

        try {
            session = getSession();
            t = session.get(getGenericClass(), pk);

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            if (session != null) {
                session.close();
            }
        }
        return t;
    }

    @Override
    public void add(T t) {
        Transaction transaction = null;

        try {
            session = getSession();
            transaction = session.beginTransaction();
            session.save(t);
            transaction.commit();

        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public void update(T t) {
        Transaction transaction = null;

        try {
            session = getSession();
            transaction = session.beginTransaction();
            session.update(t);
            transaction.commit();

        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public void delete(T t) {
        Transaction transaction = null;

        try {
            session = getSession();
            transaction = session.beginTransaction();
            session.delete(t);
            transaction.commit();

        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}

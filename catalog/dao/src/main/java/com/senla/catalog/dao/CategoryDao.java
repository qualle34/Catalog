package com.senla.catalog.dao;

import com.senla.catalog.dao.basic.AbstractDao;
import com.senla.catalog.daoapi.ICategoryDao;
import com.senla.catalog.entity.Category;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryDao extends AbstractDao<Category, Integer> implements ICategoryDao {

    @Autowired
    private Session session;

    @Override
    protected Class<Category> getEntityClass() {
        return Category.class;
    }

    @Override
    public Category getByTitle(String title) {

        try {
            Query query = session.createQuery("from Category where title = :title ");
            query.setParameter("title", title);

            return (Category) query.getSingleResult();

        } catch (HibernateException e) {
            throw e;
        }
    }
}

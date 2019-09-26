package com.senla.catalog.dao;

import com.senla.catalog.dao.basic.AbstractDao;
import com.senla.catalog.daoapi.ICategoryDao;
import com.senla.catalog.entity.Category;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Repository
public class CategoryDao extends AbstractDao<Category, Integer> implements ICategoryDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    protected Class<Category> getEntityClass() {
        return Category.class;
    }

    @Override
    public Category getByTitle(String title) {

        try {
            Query query = entityManager.createQuery("from Category where title = :title ");
            query.setParameter("title", title);

            return (Category) query.getSingleResult();

        } catch (RuntimeException e) {
            throw e;
        }
    }
}

package com.senla.catalog.dao;

import com.senla.catalog.dao.basic.AbstractDao;
import com.senla.catalog.daoapi.ICategoryDao;
import com.senla.catalog.entity.Category;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryDao extends AbstractDao<Category, Integer> implements ICategoryDao {

    private static final Logger logger = LoggerFactory.getLogger(CategoryDao.class);

    @Autowired
    private Session session;

    @Override
    protected Class getChildClass() {
        return CategoryDao.class;
    }

    @Override
    protected Class<Category> getEntityClass() {
        return Category.class;
    }

    @Override
    protected Session getSession() {
        return session;
    }

    @Override
    public Category getWithAdvertsByName(String name) {

        try {
            Query query = session.createQuery("from Category as category join fetch category.advertList as advertList where category.title = :name ");
            query.setParameter("name", name);

            return (Category) query.getSingleResult();

        } catch (RuntimeException e) {
            logger.error("Get category with adverts by name error: " + e.getMessage());
            throw e;
        }
    }

    @Bean
    public CategoryDao getInstance() {
        return new CategoryDao();
    }
}

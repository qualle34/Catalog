package com.senla.catalog.dao;

import com.senla.catalog.dao.basic.AbstractDao;
import com.senla.catalog.daoapi.IAdvertDao;
import com.senla.catalog.entity.Advert;
import com.senla.catalog.entity.Category;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AdvertDao extends AbstractDao<Advert, Integer> implements IAdvertDao {

    private static final Logger logger = LoggerFactory.getLogger(AdvertDao.class);

    @Autowired
    private Session session;

    @Override
    protected Class getChildClass() {
        return AdvertDao.class;
    }

    @Override
    protected Class<Advert> getEntityClass() {
        return Advert.class;
    }

    @Override
    public List<Advert> getByCategory(Category category) {

        try {
            Query query = session.createQuery("from Advert where category_id = :id ");
            query.setParameter("id", category.getId());

            return query.list();

        } catch (RuntimeException e) {
            logger.error("Get advert list by category error: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public List<Advert> getByTitle(String title) {
        try {
            Query query = session.createQuery("from Advert where title like :title ");
            query.setParameter("title", "%" + title + "%");

            return query.list();

        } catch (RuntimeException e) {
            logger.error("Get advert list by title error: " + e.getMessage());
            throw e;
        }
    }
}

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

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;
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

    @Override
    public List<Advert> getWithUser() {
        List<Advert> list;

        try {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Advert> query = builder.createQuery(Advert.class);

            Root root = query.from(Advert.class);

            root.fetch("user", JoinType.INNER);
            list = session.createQuery(query).getResultList();

        } catch (RuntimeException e) {
            logger.error("Get adverts with users error: " + e.getMessage());
            throw e;
        }
        return list;
    }

    @Override
    public List<Advert> getByCategoryWithUser(Category category) {
        List<Advert> list;

        try {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Advert> query = builder.createQuery(Advert.class);
            Root root = query.from(Advert.class);

            root.fetch("user", JoinType.INNER);
            query.select(root).where(builder.equal(root.get("category"), category));

            list = session.createQuery(query).getResultList();

        } catch (RuntimeException e) {
            logger.error("Get adverts by category with users error: " + e.getMessage());
            throw e;
        }
        return list;
    }
}

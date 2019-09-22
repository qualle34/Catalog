package com.senla.catalog.dao;

import com.senla.catalog.dao.basic.AbstractDao;
import com.senla.catalog.daoapi.IAdvertDao;
import com.senla.catalog.entity.Advert;
import com.senla.catalog.entity.Category;
import com.senla.catalog.entity.SellerRating;
import com.senla.catalog.entity.User;
import com.senla.catalog.entity.constants.AdvertType;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.*;
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
            Query query = session.createQuery("from Advert where category = :category ");
            query.setParameter("category", category);

            return query.list();

        } catch (RuntimeException e) {
            logger.error("Get advert list by category error: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public List<Advert> getByType(AdvertType type) {

        try {
            Query query = session.createQuery("from Advert where type = :type ");
            query.setParameter("type", type);

            return query.list();

        } catch (RuntimeException e) {
            logger.error("Get advert list by type error: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public List<Advert> getByCategoryAndType(Category category, AdvertType type) {

        try {
            Query query = session.createQuery("from Advert where category = :category and type = :type");
            query.setParameter("category", category);
            query.setParameter("type", type);

            return query.list();

        } catch (RuntimeException e) {
            logger.error("Get advert list by category and type error: " + e.getMessage());
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
    public List<Advert> getByTitleAndType(String title, AdvertType type) {
        try {
            Query query = session.createQuery("from Advert where title like :title and type = :type");
            query.setParameter("title", "%" + title + "%");
            query.setParameter("type", type);

            return query.list();

        } catch (RuntimeException e) {
            logger.error("Get advert list by title and type error: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public List<Advert> getAllWithUser() {
        List<Advert> list;

        try {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Advert> query = builder.createQuery(Advert.class);
            Root<Advert> root = query.from(Advert.class);

            root.fetch("vipInfo", JoinType.LEFT);
            Fetch<Advert, User> users = root.fetch("user", JoinType.INNER);
            Fetch<User, SellerRating> ratings = users.fetch("rating", JoinType.INNER);

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
            Root<Advert> root = query.from(Advert.class);

            root.fetch("vipInfo", JoinType.LEFT);
            Fetch<Advert, User> users = root.fetch("user", JoinType.INNER);
            Fetch<User, SellerRating> ratings = users.fetch("rating", JoinType.INNER);

            query.select(root).where(builder.equal(root.get("category"), category));

            list = session.createQuery(query).getResultList();

        } catch (RuntimeException e) {
            logger.error("Get adverts by category with users error: " + e.getMessage());
            throw e;
        }
        return list;
    }

    @Override
    public List<Advert> getByTypeWithUser(AdvertType type) {
        List<Advert> list;

        try {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Advert> query = builder.createQuery(Advert.class);
            Root<Advert> root = query.from(Advert.class);

            root.fetch("vipInfo", JoinType.LEFT);
            Fetch<Advert, User> users = root.fetch("user", JoinType.INNER);
            Fetch<User, SellerRating> ratings = users.fetch("rating", JoinType.INNER);

            query.select(root).where(builder.equal(root.get("type"), type));

            list = session.createQuery(query).getResultList();

        } catch (RuntimeException e) {
            logger.error("Get adverts by type with users error: " + e.getMessage());
            throw e;
        }
        return list;
    }

    @Override
    public List<Advert> getByCategoryAndTypeWithUser(Category category, AdvertType type) {
        List<Advert> list;

        try {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Advert> query = builder.createQuery(Advert.class);
            Root<Advert> root = query.from(Advert.class);

            root.fetch("vipInfo", JoinType.LEFT);
            Fetch<Advert, User> users = root.fetch("user", JoinType.INNER);
            Fetch<User, SellerRating> ratings = users.fetch("rating", JoinType.INNER);

            Predicate predicate = builder.and(builder.equal(root.get("category"), category), builder.equal(root.get("type"), type));
            query.select(root).where(predicate);
            list = session.createQuery(query).getResultList();

        } catch (RuntimeException e) {
            logger.error("Get adverts by category and type with users error: " + e.getMessage());
            throw e;
        }
        return list;
    }
}

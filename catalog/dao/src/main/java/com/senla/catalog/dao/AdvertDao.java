package com.senla.catalog.dao;

import com.senla.catalog.dao.basic.AbstractDao;
import com.senla.catalog.daoapi.IAdvertDao;
import com.senla.catalog.entity.Advert;
import com.senla.catalog.entity.Category;
import com.senla.catalog.entity.SellerRating;
import com.senla.catalog.entity.User;
import com.senla.catalog.entity.enums.AdvertType;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.*;
import java.util.List;

@Repository
public class AdvertDao extends AbstractDao<Advert, Integer> implements IAdvertDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    protected Class<Advert> getEntityClass() {
        return Advert.class;
    }

    @Override
    public List<Advert> getByCategory(Category category) {

        try {
            Query query = entityManager.createQuery("from Advert where category = :category ");
            query.setParameter("category", category);

            return query.getResultList();

        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public List<Advert> getByType(AdvertType type) {

        try {
            Query query = entityManager.createQuery("from Advert where type = :type ");
            query.setParameter("type", type);

            return query.getResultList();

        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public List<Advert> getByCategoryAndType(Category category, AdvertType type) {

        try {
            Query query = entityManager.createQuery("from Advert where category = :category and type = :type");
            query.setParameter("category", category);
            query.setParameter("type", type);

            return query.getResultList();

        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public List<Advert> getByTitle(String title) {

        try {
            Query query = entityManager.createQuery("from Advert where title like :title ");
            query.setParameter("title", "%" + title + "%");

            return query.getResultList();

        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public List<Advert> getByUser(User user) {

        try {
            Query query = entityManager.createQuery("from Advert where user = :user ");
            query.setParameter("user", user);

            return query.getResultList();

        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public List<Advert> getByTitleAndType(String title, AdvertType type) {
        try {
            Query query = entityManager.createQuery("from Advert where title like :title and type = :type");
            query.setParameter("title", "%" + title + "%");
            query.setParameter("type", type);

            return query.getResultList();

        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public List<Advert> getAllWithUser() {

        try {
            CriteriaBuilder builder = entityManager.getCriteriaBuilder();
            CriteriaQuery<Advert> query = builder.createQuery(Advert.class);
            Root<Advert> root = query.from(Advert.class);

            root.fetch("vipInfo", JoinType.LEFT);
            Fetch<Advert, User> users = root.fetch("user", JoinType.INNER);
            Fetch<User, SellerRating> ratings = users.fetch("rating", JoinType.INNER);

            return entityManager.createQuery(query).getResultList();

        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public List<Advert> getByCategoryWithUser(Category category) {

        try {
            CriteriaBuilder builder = entityManager.getCriteriaBuilder();
            CriteriaQuery<Advert> query = builder.createQuery(Advert.class);
            Root<Advert> root = query.from(Advert.class);

            root.fetch("vipInfo", JoinType.LEFT);
            Fetch<Advert, User> users = root.fetch("user", JoinType.INNER);
            Fetch<User, SellerRating> ratings = users.fetch("rating", JoinType.INNER);

            query.select(root).where(builder.equal(root.get("category"), category));

            return entityManager.createQuery(query).getResultList();

        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public List<Advert> getByTypeWithUser(AdvertType type) {

        try {
            CriteriaBuilder builder = entityManager.getCriteriaBuilder();
            CriteriaQuery<Advert> query = builder.createQuery(Advert.class);
            Root<Advert> root = query.from(Advert.class);

            root.fetch("vipInfo", JoinType.LEFT);
            Fetch<Advert, User> users = root.fetch("user", JoinType.INNER);
            Fetch<User, SellerRating> ratings = users.fetch("rating", JoinType.INNER);

            query.select(root).where(builder.equal(root.get("type"), type));

            return entityManager.createQuery(query).getResultList();

        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public List<Advert> getByCategoryAndTypeWithUser(Category category, AdvertType type) {

        try {
            CriteriaBuilder builder = entityManager.getCriteriaBuilder();
            CriteriaQuery<Advert> query = builder.createQuery(Advert.class);
            Root<Advert> root = query.from(Advert.class);

            root.fetch("vipInfo", JoinType.LEFT);
            Fetch<Advert, User> users = root.fetch("user", JoinType.INNER);
            Fetch<User, SellerRating> ratings = users.fetch("rating", JoinType.INNER);

            Predicate predicate = builder.and(builder.equal(root.get("category"), category), builder.equal(root.get("type"), type));
            query.select(root).where(predicate);

            return entityManager.createQuery(query).getResultList();

        } catch (RuntimeException e) {
            throw e;
        }
    }


}

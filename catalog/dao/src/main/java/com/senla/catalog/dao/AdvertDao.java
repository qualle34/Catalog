package com.senla.catalog.dao;

import com.senla.catalog.dao.basic.AbstractDao;
import com.senla.catalog.daoapi.IAdvertDao;
import com.senla.catalog.entity.Advert;
import com.senla.catalog.entity.Category;
import com.senla.catalog.entity.UserRating;
import com.senla.catalog.entity.User;
import com.senla.catalog.entity.enums.AdvertType;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.*;
import java.util.List;

@Repository
public class AdvertDao extends AbstractDao<Advert, Long> implements IAdvertDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    protected Class<Advert> getEntityClass() {
        return Advert.class;
    }

    @Override
    public List<Advert> getByCategoryId(int categoryId) {
        Query query = entityManager.createQuery("SELECT a FROM Advert a WHERE a.category.id = :categoryId ", Advert.class);
        query.setParameter("categoryId", categoryId);

        return query.getResultList();
    }

    @Override
    public List<Advert> getByType(AdvertType type) {
        Query query = entityManager.createQuery("SELECT a FROM Advert a WHERE a.type = :type ", Advert.class);
        query.setParameter("type", type);

        return query.getResultList();
    }

    @Override
    public List<Advert> getByCategoryIdAndType(int categoryId, AdvertType type) {
        Query query = entityManager.createQuery("SELECT a FROM Advert a WHERE a.category.id = :categoryId and a.type = :type", Advert.class);
        query.setParameter("categoryId", categoryId);
        query.setParameter("type", type);

        return query.getResultList();
    }

    @Override
    public List<Advert> getByTitle(String title) {
        Query query = entityManager.createQuery("SELECT a FROM Advert a WHERE a.title like :title ", Advert.class);
        query.setParameter("title", "%" + title + "%");

        return query.getResultList();
    }

    @Override
    public List<Advert> getByUserId(long userId) {
        Query query = entityManager.createQuery("SELECT a FROM Advert a WHERE a.user.id = :user ", Advert.class);
        query.setParameter("user", userId);

        return query.getResultList();
    }

    @Override
    public List<Advert> getByTitleAndType(String title, AdvertType type) {
        Query query = entityManager.createQuery("SELECT a FROM Advert a WHERE a.title like :title and a.type = :type", Advert.class);
        query.setParameter("title", "%" + title + "%");
        query.setParameter("type", type);

        return query.getResultList();
    }

    @Override
    public List<Advert> getAllWithUser() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Advert> query = builder.createQuery(Advert.class);
        Root<Advert> root = query.from(Advert.class);

        root.fetch("vipInfo", JoinType.LEFT);
        Fetch<Advert, User> user = root.fetch("user", JoinType.INNER);
        Fetch<User, UserRating> rating = user.fetch("rating", JoinType.INNER);

        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public List<Advert> getWithUserByCategoryId(int categoryId) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Advert> query = builder.createQuery(Advert.class);
        Root<Advert> root = query.from(Advert.class);

        root.fetch("vipInfo", JoinType.LEFT);
        Join<Advert, Category> category = root.join("category", JoinType.LEFT);
        Fetch<Advert, User> user = root.fetch("user", JoinType.INNER);
        Fetch<User, UserRating> rating = user.fetch("rating", JoinType.INNER);

        Predicate predicate = builder.equal(category.get("id"), categoryId);
        query.select(root).where(predicate);

        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public List<Advert> getWithUserByType(AdvertType type) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Advert> query = builder.createQuery(Advert.class);
        Root<Advert> root = query.from(Advert.class);

        root.fetch("vipInfo", JoinType.LEFT);
        Fetch<Advert, User> user = root.fetch("user", JoinType.INNER);
        Fetch<User, UserRating> rating = user.fetch("rating", JoinType.INNER);

        query.select(root).where(builder.equal(root.get("type"), type));

        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public List<Advert> getWithUserByCategoryIdAndType(int categoryId, AdvertType type) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Advert> query = builder.createQuery(Advert.class);
        Root<Advert> root = query.from(Advert.class);

        root.fetch("vipInfo", JoinType.LEFT);
        Join<Advert, Category> category = root.join("category", JoinType.LEFT);
        Fetch<Advert, User> user = root.fetch("user", JoinType.INNER);
        Fetch<User, UserRating> rating = user.fetch("rating", JoinType.INNER);

        Predicate predicate = builder.and(builder.equal(category.get("id"), categoryId), builder.equal(root.get("type"), type));
        query.select(root).where(predicate);

        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public Advert getWithCommentsById(long id) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Advert> query = builder.createQuery(Advert.class);
        Root<Advert> root = query.from(Advert.class);

        root.fetch("commentSet", JoinType.LEFT);

        query.select(root).where(builder.equal(root.get("id"), id));

        return entityManager.createQuery(query).getSingleResult();
    }

    @Override
    public void delete(long id) {
        Query query = entityManager.createQuery("DELETE FROM Advert a WHERE a.id = :id ");
        query.setParameter("id", id);
        query.executeUpdate();
    }
}
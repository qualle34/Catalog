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
    public List<Advert> getByCategory(int categoryId) {
        Query query = entityManager.createQuery("select a from Advert a where a.category.id = :category ");
        query.setParameter("category", categoryId);

        return query.getResultList();
    }

    @Override
    public List<Advert> getByType(AdvertType type) {
        Query query = entityManager.createQuery("select a from Advert a where a.type = :type ");
        query.setParameter("type", type);

        return query.getResultList();
    }

    @Override
    public List<Advert> getByCategoryAndType(int categoryId, AdvertType type) {
        Query query = entityManager.createQuery("select a from Advert a where a.category.id = :category and a.type = :type");
        query.setParameter("category", categoryId);
        query.setParameter("type", type);

        return query.getResultList();
    }

    @Override
    public List<Advert> getByTitle(String title) {
        Query query = entityManager.createQuery("select a from Advert a where a.title like :title ");
        query.setParameter("title", "%" + title + "%");

        return query.getResultList();
    }

    @Override
    public List<Advert> getByUserId(int userId) {
        Query query = entityManager.createQuery("select a from Advert a where a.user.id = :user ");
        query.setParameter("user", userId);

        return query.getResultList();
    }

    @Override
    public List<Advert> getByTitleAndType(String title, AdvertType type) {
        Query query = entityManager.createQuery("select a from Advert a where a.title like :title and a.type = :type");
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
        Fetch<Advert, User> users = root.fetch("user", JoinType.INNER);
        Fetch<User, SellerRating> ratings = users.fetch("rating", JoinType.INNER);

        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public List<Advert> getByCategoryWithUser(int categoryId) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Advert> query = builder.createQuery(Advert.class);
        Root<Advert> root = query.from(Advert.class);

        root.fetch("vipInfo", JoinType.LEFT);
        Join<Advert, Category> category = root.join("category", JoinType.LEFT);
        Fetch<Advert, User> users = root.fetch("user", JoinType.INNER);
        Fetch<User, SellerRating> ratings = users.fetch("rating", JoinType.INNER);

        Predicate predicate = builder.equal(category.get("id"), categoryId);
        query.select(root).where(predicate);

        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public List<Advert> getByTypeWithUser(AdvertType type) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Advert> query = builder.createQuery(Advert.class);
        Root<Advert> root = query.from(Advert.class);

        root.fetch("vipInfo", JoinType.LEFT);
        Fetch<Advert, User> users = root.fetch("user", JoinType.INNER);
        Fetch<User, SellerRating> ratings = users.fetch("rating", JoinType.INNER);

        query.select(root).where(builder.equal(root.get("type"), type));

        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public List<Advert> getByCategoryAndTypeWithUser(int categoryId, AdvertType type) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Advert> query = builder.createQuery(Advert.class);
        Root<Advert> root = query.from(Advert.class);

        root.fetch("vipInfo", JoinType.LEFT);
        Join<Advert, Category> category = root.join("category", JoinType.LEFT);
        Fetch<Advert, User> users = root.fetch("user", JoinType.INNER);
        Fetch<User, SellerRating> ratings = users.fetch("rating", JoinType.INNER);

        Predicate predicate = builder.and(builder.equal(category.get("id"), categoryId), builder.equal(root.get("type"), type));
        query.select(root).where(predicate);

        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public Advert getByIdWithComments(int id) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Advert> query = builder.createQuery(Advert.class);
        Root<Advert> root = query.from(Advert.class);

        root.fetch("commentSet", JoinType.LEFT);

        query.select(root).where(builder.equal(root.get("id"), id));

        return entityManager.createQuery(query).getSingleResult();
    }

    @Override
    public void delete(int id) {
        Query query = entityManager.createQuery("DELETE FROM Advert a WHERE a.id = :id");
        query.setParameter("id", id);
    }
}

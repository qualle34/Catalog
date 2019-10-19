package com.senla.catalog.dao;

import com.senla.catalog.dao.basic.AbstractDao;
import com.senla.catalog.daoapi.IAdvertDao;
import com.senla.catalog.entity.Advert;
import com.senla.catalog.entity.enums.AdvertType;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;
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
    public List<Advert> getAll() {
        Query query = entityManager.createQuery("SELECT a FROM Advert a LEFT JOIN a.vipInfo v INNER JOIN a.user u INNER JOIN u.rating r " +
                "ORDER BY v.buyDate DESC, r.rating DESC", Advert.class);

        return query.getResultList();
    }

    @Override
    public List<Advert> getByCategoryId(int categoryId) {
        Query query = entityManager.createQuery("SELECT a FROM Advert a LEFT JOIN a.vipInfo v INNER JOIN a.user u INNER JOIN u.rating r " +
                "WHERE a.category.id = :categoryId  " +
                "ORDER BY v.buyDate DESC, r.rating DESC", Advert.class);
        query.setParameter("categoryId", categoryId);

        return query.getResultList();
    }

    @Override
    public List<Advert> getByType(AdvertType type) {
        Query query = entityManager.createQuery("SELECT a FROM Advert a LEFT JOIN a.vipInfo v INNER JOIN a.user u INNER JOIN u.rating r " +
                "WHERE a.type = :type " +
                "ORDER BY v.buyDate DESC, r.rating DESC", Advert.class);
        query.setParameter("type", type);

        return query.getResultList();
    }

    @Override
    public List<Advert> getByCategoryIdAndType(int categoryId, AdvertType type) {
        Query query = entityManager.createQuery("SELECT a FROM Advert a LEFT JOIN a.vipInfo v INNER JOIN a.user u INNER JOIN u.rating r " +
                "WHERE a.category.id = :categoryId and a.type = :type " +
                "ORDER BY v.buyDate DESC, r.rating DESC", Advert.class);
        query.setParameter("categoryId", categoryId);
        query.setParameter("type", type);

        return query.getResultList();
    }

    @Override
    public List<Advert> getByTitle(String title) {
        Query query = entityManager.createQuery("SELECT a FROM Advert a LEFT JOIN a.vipInfo v INNER JOIN a.user u INNER JOIN u.rating r " +
                "WHERE a.title like :title " +
                "ORDER BY v.buyDate DESC, r.rating DESC", Advert.class);
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
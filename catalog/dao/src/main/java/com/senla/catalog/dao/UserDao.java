package com.senla.catalog.dao;

import com.senla.catalog.dao.basic.AbstractDao;
import com.senla.catalog.daoapi.IUserDao;
import com.senla.catalog.entity.Advert;
import com.senla.catalog.entity.SellerRating;
import com.senla.catalog.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.*;
import java.util.List;

@Repository
public class UserDao extends AbstractDao<User, Integer> implements IUserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    protected Class<User> getEntityClass() {
        return User.class;
    }

    @Override
    public List<User> getByName(String name) {

        try {
            Query query = entityManager.createQuery("from User where firstname = :name ");
            query.setParameter("name", name);

            return query.getResultList();

        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public User getWithChatList(int id) {

        try {
            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
            CriteriaQuery<User> query = cb.createQuery(User.class);
            Root<User> root = query.from(User.class);

            root.fetch("chatSet", JoinType.LEFT);
            query.select(root).where(cb.equal(root.get("id"), id));

            return entityManager.createQuery(query).getSingleResult();

        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public User getFullUserById(int id) {

        try {
            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
            CriteriaQuery<User> query = cb.createQuery(User.class);
            Root<User> root = query.from(User.class);

            root.fetch("creds", JoinType.LEFT);
            root.fetch("rating", JoinType.LEFT);
            root.fetch("dealSet", JoinType.LEFT);
            root.fetch("advertSet", JoinType.LEFT);
            root.fetch("commentSet", JoinType.LEFT);
            root.fetch("chatSet", JoinType.LEFT);
            root.fetch("messageSet", JoinType.LEFT);

            query.select(root).where(cb.equal(root.get("id"), id));

            return entityManager.createQuery(query).getSingleResult();

        } catch (RuntimeException e) {
            throw e;
        }
    }
}
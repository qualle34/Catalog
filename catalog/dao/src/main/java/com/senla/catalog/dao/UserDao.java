package com.senla.catalog.dao;

import com.senla.catalog.dao.basic.AbstractDao;
import com.senla.catalog.daoapi.IUserDao;
import com.senla.catalog.entity.Advert;
import com.senla.catalog.entity.Creds;
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
        Query query = entityManager.createQuery("select u from User u where u.firstname Like :name ");
        query.setParameter("name", "%" + name + "%");

        return query.getResultList();
    }

    @Override
    public User getWithChatList(int id) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> query = cb.createQuery(User.class);
        Root<User> root = query.from(User.class);

        root.fetch("chatSet", JoinType.LEFT);
        query.select(root).where(cb.equal(root.get("id"), id));

        return entityManager.createQuery(query).getSingleResult();
    }

    @Override
    public User getWithCredsByEmail(String email) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> query = cb.createQuery(User.class);
        Root<User> root = query.from(User.class);

        Join<User, Creds> creds = root.join("creds", JoinType.INNER);
        Predicate predicate = cb.equal(creds.get("email"), email);
        query.select(root).where(predicate);

        return entityManager.createQuery(query).getSingleResult();
    }

    @Override
    public User getWithCredsById(int id) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> query = cb.createQuery(User.class);
        Root<User> root = query.from(User.class);

        root.fetch("creds", JoinType.INNER);
        query.select(root).where(cb.equal(root.get("id"), id));

        return entityManager.createQuery(query).getSingleResult();
    }

    @Override
    public User getFullUserById(int id) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> query = cb.createQuery(User.class);
        Root<User> root = query.from(User.class);

        root.fetch("creds", JoinType.INNER);
        root.fetch("rating", JoinType.INNER);
        root.fetch("dealSet", JoinType.LEFT);
        root.fetch("advertSet", JoinType.LEFT);
        root.fetch("commentSet", JoinType.LEFT);
        root.fetch("chatSet", JoinType.LEFT);
        root.fetch("messageSet", JoinType.LEFT);

        query.select(root).where(cb.equal(root.get("id"), id));

        return entityManager.createQuery(query).getSingleResult();
    }

    @Override
    public void delete(int id) {
        Query query = entityManager.createQuery("DELETE FROM User u WHERE u.id = :id");
        query.setParameter("id", id);
    }
}
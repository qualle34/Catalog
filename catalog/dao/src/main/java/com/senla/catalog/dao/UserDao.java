package com.senla.catalog.dao;

import com.senla.catalog.dao.basic.AbstractDao;
import com.senla.catalog.daoapi.IUserDao;
import com.senla.catalog.entity.Creds;
import com.senla.catalog.entity.Role;
import com.senla.catalog.entity.User;
import com.senla.catalog.entity.enums.UserRole;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.*;

@Repository
public class UserDao extends AbstractDao<User, Long> implements IUserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    protected Class<User> getEntityClass() {
        return User.class;
    }

    @Override
    public long getIdByLogin(String login) {
        Query query = entityManager.createQuery("SELECT c.id FROM Creds c WHERE c.login = :login ");
        query.setParameter("login", login);

        return (long) query.getSingleResult();
    }

    @Override
    public User getWithChatListById(long id) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery(User.class);
        Root<User> root = query.from(User.class);

        root.fetch("chatSet", JoinType.LEFT);
        query.select(root).where(builder.equal(root.get("id"), id));

        return entityManager.createQuery(query).getSingleResult();
    }

    @Override
    public User getWithCredsByLogin(String login) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery(User.class);
        Root<User> root = query.from(User.class);

        root.fetch("creds", JoinType.INNER);
        root.fetch("roleSet", JoinType.LEFT);
        Join<User, Creds> creds = root.join("creds", JoinType.INNER);

        Predicate predicate = builder.equal(creds.get("login"), login);
        query.select(root).where(predicate);

        return entityManager.createQuery(query).getSingleResult();
    }

    @Override
    public User getWithCredsById(long id) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery(User.class);
        Root<User> root = query.from(User.class);

        root.fetch("creds", JoinType.INNER);
        root.fetch("roleSet", JoinType.LEFT);
        query.select(root).where(builder.equal(root.get("id"), id));

        return entityManager.createQuery(query).getSingleResult();
    }

    @Override
    public User getWithRatingById(long id) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery(User.class);
        Root<User> root = query.from(User.class);

        root.fetch("rating", JoinType.INNER);
        query.select(root).where(builder.equal(root.get("id"), id));

        return entityManager.createQuery(query).getSingleResult();
    }

    @Override
    public User getWithCredsAndRatingById(long id) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery(User.class);
        Root<User> root = query.from(User.class);

        root.fetch("creds", JoinType.INNER);
        root.fetch("rating", JoinType.INNER);
        root.fetch("roleSet", JoinType.LEFT);
        query.select(root).where(builder.equal(root.get("id"), id));

        return entityManager.createQuery(query).getSingleResult();
    }

    @Override
    public User getFullById(long id) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery(User.class);
        Root<User> root = query.from(User.class);

        root.fetch("creds", JoinType.INNER);
        root.fetch("rating", JoinType.INNER);
        root.fetch("roleSet", JoinType.LEFT);
        root.fetch("dealSet", JoinType.LEFT);
        root.fetch("advertSet", JoinType.LEFT);
        root.fetch("commentSet", JoinType.LEFT);
        root.fetch("chatSet", JoinType.LEFT);
        root.fetch("messageSet", JoinType.LEFT);

        query.select(root).where(builder.equal(root.get("id"), id));

        return entityManager.createQuery(query).getSingleResult();
    }

    @Override
    public Role getRoleByName(UserRole role) {
        Query query = entityManager.createQuery("SELECT r FROM Role r WHERE r.role = :name ");
        query.setParameter("name", role);

        return (Role) query.getSingleResult();
    }

    @Override
    public void delete(long id) {
        Query query = entityManager.createQuery("DELETE FROM User u WHERE u.id = :id ");
        query.setParameter("id", id);
        query.executeUpdate();
    }
}

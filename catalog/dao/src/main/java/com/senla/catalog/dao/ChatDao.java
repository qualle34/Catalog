package com.senla.catalog.dao;

import com.senla.catalog.dao.basic.AbstractDao;
import com.senla.catalog.daoapi.IChatDao;
import com.senla.catalog.entity.Chat;
import com.senla.catalog.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class ChatDao extends AbstractDao<Chat, Integer> implements IChatDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    protected Class<Chat> getEntityClass() {
        return Chat.class;
    }

    @Override
    public List<Chat> getByUser(User user) {

        try {
            Query query = entityManager.createQuery("from Chat where userSet in :user");
            query.setParameter("user", user);

            return query.getResultList();

        } catch (RuntimeException e) {
            throw e;
        }
    }
}

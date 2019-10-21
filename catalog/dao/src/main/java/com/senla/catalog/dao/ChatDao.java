package com.senla.catalog.dao;

import com.senla.catalog.dao.basic.AbstractDao;
import com.senla.catalog.daoapi.IChatDao;
import com.senla.catalog.entity.Chat;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Repository
public class ChatDao extends AbstractDao<Chat, Long> implements IChatDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    protected Class<Chat> getEntityClass() {
        return Chat.class;
    }

    @Override
    public Chat getById(long userId, long chatId) {
        Query query = entityManager.createQuery("SELECT c FROM Chat c WHERE c.id = :chatId AND (SELECT u From User u where u.id = :userId) MEMBER OF c.userSet ", Chat.class);
        query.setParameter("userId", userId);
        query.setParameter("chatId", chatId);

        return (Chat) query.getSingleResult();
    }

    @Override
    public Chat getWithMessagesById(long userId, long chatId) {
        Query query = entityManager.createQuery("SELECT c FROM Chat c LEFT JOIN FETCH c.messageList m WHERE c.id = :chatId AND (SELECT u From User u where u.id = :userId) MEMBER OF c.userSet ", Chat.class);
        query.setParameter("userId", userId);
        query.setParameter("chatId", chatId);

        return (Chat) query.getSingleResult();
    }
}
package com.senla.catalog.dao;

import com.senla.catalog.dao.basic.AbstractDao;
import com.senla.catalog.daoapi.IMessageDao;
import com.senla.catalog.entity.Message;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class MessageDao extends AbstractDao<Message, Long> implements IMessageDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    protected Class<Message> getEntityClass() {
        return Message.class;
    }

    @Override
    public List<Message> getByChat(long chatId) {
        Query query = entityManager.createQuery("SELECT m FROM Message m WHERE m.chat.id = :chatId ", Message.class);
        query.setParameter("chatId", chatId);

        return query.getResultList();
    }

    @Override
    public List<Message> getByChat(long chatId, long userId) {
        Query query = entityManager.createQuery("SELECT m FROM Message m WHERE m.chat.id = :chatId and m.user.id = :userId ", Message.class);
        query.setParameter("chatId", chatId);
        query.setParameter("userId", userId);

        return query.getResultList();
    }

    @Override
    public void delete(long id) {
        Query query = entityManager.createQuery("DELETE FROM Message m WHERE m.id = :id ");
        query.setParameter("id", id);
        query.executeUpdate();
    }
}

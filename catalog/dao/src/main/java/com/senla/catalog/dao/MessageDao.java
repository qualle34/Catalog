package com.senla.catalog.dao;

import com.senla.catalog.dao.basic.AbstractDao;
import com.senla.catalog.daoapi.IMessageDao;
import com.senla.catalog.entity.Chat;
import com.senla.catalog.entity.Message;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class MessageDao extends AbstractDao<Message, Integer> implements IMessageDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    protected Class<Message> getEntityClass() {
        return Message.class;
    }

    @Override
    public List<Message> getByChat(Chat chat) {

        try {
            Query query = entityManager.createQuery("from Message where chat = :chat ");
            query.setParameter("chat", chat);

            return query.getResultList();

        } catch (RuntimeException e) {
            throw e;
        }
    }
}

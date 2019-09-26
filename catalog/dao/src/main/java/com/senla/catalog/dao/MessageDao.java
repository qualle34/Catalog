package com.senla.catalog.dao;

import com.senla.catalog.dao.basic.AbstractDao;
import com.senla.catalog.daoapi.IMessageDao;
import com.senla.catalog.entity.Message;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class MessageDao extends AbstractDao<Message, Integer> implements IMessageDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    protected Class<Message> getEntityClass() {
        return Message.class;
    }
}

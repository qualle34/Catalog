package com.senla.catalog.dao;

import com.senla.catalog.dao.basic.AbstractDao;
import com.senla.catalog.daoapi.IChatDao;
import com.senla.catalog.entity.Chat;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class ChatDao extends AbstractDao<Chat, Integer> implements IChatDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    protected Class<Chat> getEntityClass() {
        return Chat.class;
    }
}

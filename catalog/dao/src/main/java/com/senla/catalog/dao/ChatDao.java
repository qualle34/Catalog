package com.senla.catalog.dao;

import com.senla.catalog.dao.basic.AbstractDao;
import com.senla.catalog.daoapi.IChatDao;
import com.senla.catalog.entity.Chat;
import org.hibernate.Session;


public class ChatDao extends AbstractDao<Chat, Integer> implements IChatDao {

    public ChatDao(Session session) {
        super(session);
    }

    @Override
    protected Class<Chat> getChildClass() {
        return Chat.class;
    }
}

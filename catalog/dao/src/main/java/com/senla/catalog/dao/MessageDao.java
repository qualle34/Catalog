package com.senla.catalog.dao;

import com.senla.catalog.dao.basic.AbstractDao;
import com.senla.catalog.daoapi.IMessageDao;
import com.senla.catalog.entity.Message;
import org.hibernate.Session;

public class MessageDao extends AbstractDao<Message, Integer> implements IMessageDao {

    public MessageDao(Session session) {
        super(session);
    }

    @Override
    protected Class<Message> getChildClass() {
        return Message.class;
    }
}

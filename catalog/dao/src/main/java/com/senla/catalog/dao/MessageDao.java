package com.senla.catalog.dao;

import com.senla.catalog.dao.basic.AbstractDao;
import com.senla.catalog.daoapi.IMessageDao;
import com.senla.catalog.entity.Message;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MessageDao extends AbstractDao<Message, Integer> implements IMessageDao {

    private static MessageDao instance;
    private static final Logger logger = LoggerFactory.getLogger(MessageDao.class);
    private Session session;

    private MessageDao(Session session) {
        super(session);
        this.session = session;
    }

    @Override
    protected Class<Message> getChildClass() {
        return Message.class;
    }

    public static MessageDao getInstance(Session session) {

        if (instance == null) {
            instance = new MessageDao(session);
        }
        return instance;
    }
}

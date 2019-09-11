package com.senla.catalog.dao;

import com.senla.catalog.dao.basic.AbstractDao;
import com.senla.catalog.daoapi.IChatDao;
import com.senla.catalog.entity.Chat;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ChatDao extends AbstractDao<Chat, Integer> implements IChatDao {

    private static ChatDao instance;
    private static final Logger logger = LoggerFactory.getLogger(ChatDao.class);
    private Session session;

    private ChatDao(Session session) {
        super(session);
        this.session = session;
    }

    @Override
    protected Class<Chat> getChildClass() {
        return Chat.class;
    }

    public static ChatDao getInstance(Session session) {

        if (instance == null) {
            instance = new ChatDao(session);
        }
        return instance;
    }
}

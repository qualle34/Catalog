package com.senla.catalog.service;

import com.senla.catalog.daoapi.IChatDao;
import com.senla.catalog.entity.Chat;
import com.senla.catalog.service.basic.AbstractService;
import com.senla.catalog.serviceapi.IChatService;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChatService extends AbstractService<Chat, Integer> implements IChatService {

    private static final Logger logger = LoggerFactory.getLogger(ChatService.class);

    @Autowired
    private Session session;

    @Autowired
    private IChatDao chatDao;

    @Override
    protected Class getChildClass() {
        return ChatService.class;
    }

    @Override
    protected String getDaoClassName() {
        return "chatDao";
    }

    @Override
    protected Class<Chat> getEntityClass() {
        return Chat.class;
    }

    @Override
    public Chat getWithMessagesById(int id) {

        try {
            return chatDao.getWithMessagesById(id);

        } catch (RuntimeException e) {
            logger.error("Get with messages by id error: " + e.getMessage());
            throw e;
        }
    }
}

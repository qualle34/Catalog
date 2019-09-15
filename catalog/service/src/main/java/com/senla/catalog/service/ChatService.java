package com.senla.catalog.service;

import com.senla.catalog.daoapi.IChatDao;
import com.senla.catalog.daoapi.basic.IGenericDao;
import com.senla.catalog.entity.Chat;
import com.senla.catalog.service.basic.AbstractService;
import com.senla.catalog.serviceapi.IChatService;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
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
    protected Class<Chat> getEntityClass() {
        return Chat.class;
    }

    @Override
    protected Session getSession() {
        return session;
    }

    @Override
    protected IGenericDao getDao() {
        return chatDao;
    }

    @Override
    public Chat getWithMessagesById(int id) throws RuntimeException {

        try {
            return chatDao.getWithMessagesById(id);
        } catch (RuntimeException e) {
            logger.error("Get chat with messages error: " + e.getMessage());
            throw e;
        }
    }

    @Bean
    public ChatService getInstance() {
        return new ChatService();
    }
}

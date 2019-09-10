package com.senla.catalog.service;

import com.senla.catalog.daoapi.IChatDao;
import com.senla.catalog.entity.Chat;
import com.senla.catalog.service.basic.AbstractService;
import com.senla.catalog.serviceapi.IChatService;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ChatService extends AbstractService<Chat, Integer> implements IChatService {

    private static final Logger logger = LoggerFactory.getLogger(ChatService.class);
    private IChatDao chatDao;
    private Session session;

    public ChatService(IChatDao chatDao, Session session) {
        super(chatDao, session);
        this.chatDao = chatDao;
        this.session = session;
    }

    @Override
    protected Class getChildClass() {
        return ChatService.class;
    }
}

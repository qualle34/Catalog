package com.senla.catalog.service;

import com.senla.catalog.daoapi.IChatDao;
import com.senla.catalog.entity.Chat;
import com.senla.catalog.entity.User;
import com.senla.catalog.service.basic.AbstractService;
import com.senla.catalog.serviceapi.IChatService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatService extends AbstractService<Chat, Integer> implements IChatService {

    private static final Logger logger = LoggerFactory.getLogger(ChatService.class);

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
}

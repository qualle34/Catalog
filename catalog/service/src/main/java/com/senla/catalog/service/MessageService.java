package com.senla.catalog.service;

import com.senla.catalog.daoapi.IMessageDao;
import com.senla.catalog.entity.Chat;
import com.senla.catalog.entity.Message;
import com.senla.catalog.service.basic.AbstractService;
import com.senla.catalog.serviceapi.IMessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService extends AbstractService<Message, Integer> implements IMessageService {

    private static final Logger logger = LoggerFactory.getLogger(MessageService.class);

    @Autowired
    private IMessageDao messageDao;

    @Override
    protected String getDaoClassName() {
        return "messageDao";
    }

    @Override
    protected Class<Message> getEntityClass() {
        return Message.class;
    }

    @Override
    public List<Message> getByChat(Chat chat) {
        
        try {
            return messageDao.getByChat(chat);

        } catch (RuntimeException e) {
            logger.error("Get message list by chat error: " + e.getMessage());
            throw e;
        }
    }
}

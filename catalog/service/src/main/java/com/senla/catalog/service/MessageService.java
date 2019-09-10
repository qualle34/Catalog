package com.senla.catalog.service;

import com.senla.catalog.daoapi.IMessageDao;
import com.senla.catalog.entity.Message;
import com.senla.catalog.service.basic.AbstractService;
import com.senla.catalog.serviceapi.IMessageService;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MessageService extends AbstractService<Message, Integer> implements IMessageService {

    private static final Logger logger = LoggerFactory.getLogger(MessageService.class);
    private IMessageDao messageDao;
    private Session session;

    public MessageService(IMessageDao messageDao, Session session) {
        super(messageDao, session);
        this.messageDao = messageDao;
        this.session = session;
    }

    @Override
    protected Class getChildClass() {
        return MessageService.class;
    }
}

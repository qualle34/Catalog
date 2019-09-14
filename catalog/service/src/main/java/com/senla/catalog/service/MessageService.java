package com.senla.catalog.service;

import com.senla.catalog.dao.util.HibernateUtil;
import com.senla.catalog.daoapi.IMessageDao;
import com.senla.catalog.daoapi.basic.IGenericDao;
import com.senla.catalog.entity.Message;
import com.senla.catalog.service.basic.AbstractService;
import com.senla.catalog.serviceapi.IMessageService;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class MessageService extends AbstractService<Message, Integer> implements IMessageService {

    private static final Logger logger = LoggerFactory.getLogger(MessageService.class);

    @Autowired
    private Session session;

    @Autowired
    private IMessageDao messageDao;

    @Override
    protected Class getChildClass() {
        return MessageService.class;
    }

    @Override
    protected Class<Message> getEntityClass() {
        return Message.class;
    }

    @Override
    protected Session getSession() {
        return session;
    }

    @Override
    protected IGenericDao getDao() {
        return messageDao;
    }

    @Bean
    public MessageService getInstance() {
        return new MessageService();
    }
}

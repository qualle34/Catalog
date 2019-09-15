package com.senla.catalog.dao;

import com.senla.catalog.dao.basic.AbstractDao;
import com.senla.catalog.daoapi.IMessageDao;
import com.senla.catalog.entity.Message;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

@Repository
public class MessageDao extends AbstractDao<Message, Integer> implements IMessageDao {

    private static final Logger logger = LoggerFactory.getLogger(MessageDao.class);

    @Autowired
    private Session session;

    @Override
    protected Class getChildClass() {
        return MessageDao.class;
    }

    @Override
    protected Class<Message> getEntityClass() {
        return Message.class;
    }
}

package com.senla.catalog.dao;

import com.senla.catalog.dao.basic.AbstractDao;
import com.senla.catalog.daoapi.IMessageDao;
import com.senla.catalog.entity.Message;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MessageDao extends AbstractDao<Message, Integer> implements IMessageDao {

    @Autowired
    private Session session;

    @Override
    protected Class<Message> getEntityClass() {
        return Message.class;
    }
}

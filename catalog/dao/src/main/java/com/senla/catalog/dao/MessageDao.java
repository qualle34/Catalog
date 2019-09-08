package com.senla.catalog.dao;

import com.senla.catalog.daoapi.IMessageDao;
import com.senla.catalog.entity.Message;

public class MessageDao extends AbstractDao<Message, Integer> implements IMessageDao {

    @Override
    protected Class<Message> getChildClass() {
        return Message.class;
    }
}

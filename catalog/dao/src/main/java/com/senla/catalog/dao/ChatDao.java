package com.senla.catalog.dao;

import com.senla.catalog.daoapi.IChatDao;
import com.senla.catalog.entity.Chat;


public class ChatDao extends AbstractDao<Chat, Integer> implements IChatDao {

    @Override
    protected Class<Chat> getChildClass() {
        return Chat.class;
    }
}

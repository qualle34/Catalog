package com.senla.catalog.service;

import com.senla.catalog.dao.ChatDao;
import com.senla.catalog.daoapi.IChatDao;
import com.senla.catalog.entity.Chat;
import com.senla.catalog.serviceapi.IChatService;

import java.util.List;

public class ChatService implements IChatService {

    private IChatDao chatDao;

    public ChatService() {
        chatDao = new ChatDao();
    }

    @Override
    public List<Chat> getAll() {
        return chatDao.getAll();
    }

    @Override
    public void add(Chat chat) {
        chatDao.add(chat);
    }

    @Override
    public Chat get(Integer id) {
        return chatDao.get(id);
    }

    @Override
    public void update(Chat chat) {
        chatDao.update(chat);
    }

    @Override
    public void delete(Chat chat) {
        chatDao.delete(chat);
    }
}

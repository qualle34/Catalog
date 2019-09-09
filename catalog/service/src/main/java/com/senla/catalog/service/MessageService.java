package com.senla.catalog.service;

import com.senla.catalog.dao.MessageDao;
import com.senla.catalog.daoapi.IMessageDao;
import com.senla.catalog.entity.Message;
import com.senla.catalog.serviceapi.IMessageService;

import java.util.List;

public class MessageService implements IMessageService {

    private IMessageDao messageDao;

    public MessageService() {
        messageDao = new MessageDao();
    }

    @Override
    public List<Message> getAll() {
        return messageDao.getAll();
    }

    @Override
    public void add(Message message) {
        messageDao.add(message);
    }

    @Override
    public Message getById(Integer id) {
        return messageDao.getById(id);
    }

    @Override
    public void update(Message message) {
        messageDao.update(message);
    }

    @Override
    public void delete(Message message) {
        messageDao.delete(message);
    }
}

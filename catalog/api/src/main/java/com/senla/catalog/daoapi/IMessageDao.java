package com.senla.catalog.daoapi;

import com.senla.catalog.daoapi.basic.IGenericDao;
import com.senla.catalog.entity.Message;

import java.util.List;

public interface IMessageDao extends IGenericDao<Message, Long> {

    List<Message> getByChat(long chatId);

    List<Message> getByChat(long chatId, long userId);

    void delete(long id);
}

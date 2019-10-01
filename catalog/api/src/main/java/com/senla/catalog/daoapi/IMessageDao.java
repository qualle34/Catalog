package com.senla.catalog.daoapi;

import com.senla.catalog.daoapi.basic.IGenericDao;
import com.senla.catalog.entity.Chat;
import com.senla.catalog.entity.Message;

import java.util.List;

public interface IMessageDao extends IGenericDao<Message, Integer> {

    List<Message> getByChat(Chat chat);
}

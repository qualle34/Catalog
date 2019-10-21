package com.senla.catalog.daoapi;

import com.senla.catalog.daoapi.basic.IGenericDao;
import com.senla.catalog.entity.Chat;

public interface IChatDao extends IGenericDao<Chat, Long> {

    Chat getById(long userId, long chatId);

    Chat getWithMessagesById(long userId, long chatId);
}
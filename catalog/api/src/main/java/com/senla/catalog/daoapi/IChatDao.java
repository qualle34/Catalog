package com.senla.catalog.daoapi;

import com.senla.catalog.daoapi.basic.IGenericDao;
import com.senla.catalog.entity.Chat;

public interface IChatDao extends IGenericDao<Chat, Long> {

    Chat getByUser(long userId, long chatId);
}

package com.senla.catalog.daoapi;

import com.senla.catalog.daoapi.basic.IGenericDao;
import com.senla.catalog.entity.Message;

import java.util.List;

public interface IMessageDao extends IGenericDao<Message, Long> {

    List<Message> getByChatId(long chatId);

    void delete(long id);
}

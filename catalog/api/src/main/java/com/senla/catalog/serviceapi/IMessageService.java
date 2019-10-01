package com.senla.catalog.serviceapi;

import com.senla.catalog.entity.Chat;
import com.senla.catalog.entity.Message;
import com.senla.catalog.serviceapi.basic.IGenericService;

import java.util.List;

public interface IMessageService extends IGenericService<Message, Integer> {

    List<Message> getByChat(Chat chat);
}

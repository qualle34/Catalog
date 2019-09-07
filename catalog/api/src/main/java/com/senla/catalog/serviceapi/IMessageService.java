package com.senla.catalog.serviceapi;


import com.senla.catalog.entity.Message;

import java.util.List;

public interface IMessageService {

    List<Message> getAll();

    void add(Message message);

    Message get(Integer id);

    void update(Message message);

    void delete(Message message);
}

package com.senla.catalog.daoapi;

import com.senla.catalog.entity.Message;

import java.util.List;

public interface IMessageDao extends IGenericDao<Message, Integer> {

    @Override
    List<Message> getAll();

    @Override
    void add(Message message);

    @Override
    Message get(Integer integer);

    @Override
    void update(Message message);

    @Override
    void delete(Message message);
}

package com.senla.catalog.daoapi;

import com.senla.catalog.entity.Chat;

import java.util.List;

public interface IChatDao extends IGenericDao<Chat, Integer> {

    @Override
    List<Chat> getAll();

    @Override
    void add(Chat chat);

    @Override
    Chat get(Integer integer);

    @Override
    void update(Chat chat);

    @Override
    void delete(Chat chat);
}

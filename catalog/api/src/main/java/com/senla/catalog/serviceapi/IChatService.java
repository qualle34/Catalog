package com.senla.catalog.serviceapi;


import com.senla.catalog.entity.Chat;

import java.util.List;

public interface IChatService {

    List<Chat> getAll();

    void add(Chat chat);

    Chat getById(Integer id);

    void update(Chat chat);

    void delete(Chat chat);
}

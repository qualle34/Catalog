package com.senla.catalog.serviceapi;

import com.senla.catalog.entity.Chat;
import com.senla.catalog.entity.User;
import com.senla.catalog.serviceapi.basic.IGenericService;

import java.util.List;

public interface IChatService extends IGenericService<Chat, Integer> {

    List<Chat> getByUser(User user);
}

package com.senla.catalog.serviceapi;

import com.senla.catalog.dto.ChatDto;
import com.senla.catalog.entity.Chat;
import com.senla.catalog.entity.User;
import com.senla.catalog.serviceapi.basic.IGenericService;

import java.util.List;
import java.util.Set;

public interface IChatService extends IGenericService<Chat, Integer> {

    List<ChatDto> chatListToDto(List<Chat> chatList);

    List<ChatDto> chatSetToDto(Set<Chat> chatSet);

    ChatDto getDtoById(int id);
}

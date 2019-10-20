package com.senla.catalog.serviceapi;

import com.senla.catalog.dto.chat.ChatDto;
import com.senla.catalog.entity.Chat;
import com.senla.catalog.serviceapi.basic.IGenericService;

import java.util.Collection;
import java.util.List;

public interface IChatService extends IGenericService<Chat, Long> {

    ChatDto getDtoById(long id);

    Chat getByUser(long userId, long chatId);

    List<ChatDto> chatsToDto(Collection<Chat> chatList);

    ChatDto chatToDto(Chat chat);
}
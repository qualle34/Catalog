package com.senla.catalog.serviceapi;

import com.senla.catalog.dto.chat.ChatDto;
import com.senla.catalog.dto.chat.SimpleChatDto;
import com.senla.catalog.entity.Chat;
import com.senla.catalog.serviceapi.basic.IGenericService;

import java.util.Collection;
import java.util.List;

public interface IChatService extends IGenericService<Chat, Long> {

    ChatDto getWithMessagesById(long id, String token);

    Chat getByUser(long userId, long chatId);

    List<SimpleChatDto> chatsToDto(Collection<Chat> chatList);

    SimpleChatDto chatToDto(Chat chat);
}
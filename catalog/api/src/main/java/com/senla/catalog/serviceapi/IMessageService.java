package com.senla.catalog.serviceapi;

import com.senla.catalog.dto.chat.MessageDto;
import com.senla.catalog.entity.Message;
import com.senla.catalog.serviceapi.basic.IGenericService;

import java.util.List;

public interface IMessageService extends IGenericService<Message, Long> {

    List<MessageDto> getByChat(long chatId);

    List<MessageDto> getByChat(long chatId, String token);

    MessageDto messageToDto(Message message);

    Message dtoToMessage(MessageDto dto);

    List<MessageDto> messageListToDto(List<Message> messageList);

    void add(MessageDto dto);

    void add(MessageDto dto, String token);

    void delete(long id);
}
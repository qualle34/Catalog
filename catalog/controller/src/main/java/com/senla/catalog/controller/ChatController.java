package com.senla.catalog.controller;

import com.senla.catalog.dto.ChatDto;
import com.senla.catalog.dto.MessageDto;
import com.senla.catalog.entity.Chat;
import com.senla.catalog.entity.Message;
import com.senla.catalog.serviceapi.IChatService;
import com.senla.catalog.serviceapi.IMessageService;
import com.senla.catalog.serviceapi.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(value = "/chats")
public class ChatController {

    @Autowired
    IUserService userService;

    @Autowired
    IChatService chatService;

    @Autowired
    IMessageService messageService;

    @GetMapping(params = "id")
    public List<ChatDto> getChatsData(@RequestParam int id) {
        return chatListToDto(userService.getWithChatList(id).getChatSet());
    }

    @GetMapping(value = "/chat", params = "id")
    public List<MessageDto> getMessagesData(@RequestParam int id) {
        return messageListToDto(messageService.getByChat(chatService.getById(id)));
    }

    private List<MessageDto> messageListToDto(List<Message> messagesList) {
        List<MessageDto> dtoList = new LinkedList<>();

        for (Message message : messagesList) {
            dtoList.add(new MessageDto(message.getText(), message.getUser().getId(), message.getSendDate()));
        }
        return dtoList;
    }

    private List<ChatDto> chatListToDto(Set<Chat> chatList) {
        List<ChatDto> dtoList = new LinkedList<>();

        for (Chat chat : chatList) {
            dtoList.add(new ChatDto(chat.getTitle()));
        }
        return dtoList;
    }
}

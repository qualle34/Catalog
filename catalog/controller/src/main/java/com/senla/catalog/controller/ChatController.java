package com.senla.catalog.controller;

import com.senla.catalog.dto.ChatDto;
import com.senla.catalog.dto.MessageDto;
import com.senla.catalog.serviceapi.IChatService;
import com.senla.catalog.serviceapi.IMessageService;
import com.senla.catalog.serviceapi.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    public List<ChatDto> getChats(@RequestParam int id) { // param - user id
        return chatService.chatSetToDto(userService.getWithChatList(id).getChatSet());
    }

    @GetMapping(value = "/chat", params = "id")
    public List<MessageDto> getMessagesData(@RequestParam int id) { // param - chat id
        return messageService.getDtoByChat(id);
    }
}

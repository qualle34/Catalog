package com.senla.catalog.controller;

import com.senla.catalog.dto.chat.ChatDto;
import com.senla.catalog.dto.chat.MessageDto;
import com.senla.catalog.serviceapi.IMessageService;
import com.senla.catalog.serviceapi.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "my")
public class UserChatController {

    @Autowired
    private IUserService userService;

    @Autowired
    private IMessageService messageService;

    @GetMapping("/chats")
    public List<ChatDto> getChats(@RequestHeader("token") String token) {
        return userService.getChatsByUser(token);
    }

    @GetMapping(value = "/chat", params = "id")
    public List<MessageDto> getMessages(@RequestHeader("token") String token, @RequestParam int id) { // param - chat id
        return messageService.getByChat(id, token);
    }

    @PostMapping(value = "/chat/add")
    public void addMessage(@RequestHeader("token") String token, @RequestBody MessageDto dto) {
        messageService.add(dto, token);
    }
}
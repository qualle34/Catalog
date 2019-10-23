package com.senla.catalog.controller;

import com.senla.catalog.dto.chat.ChatDto;
import com.senla.catalog.dto.chat.MessageDto;
import com.senla.catalog.dto.chat.SimpleChatDto;
import com.senla.catalog.serviceapi.IChatService;
import com.senla.catalog.serviceapi.IMessageService;
import com.senla.catalog.serviceapi.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "my")
public class UserChatController {

    @Autowired
    private IUserService userService;

    @Autowired
    private IMessageService messageService;

    @Autowired
    private IChatService chatService;

    @GetMapping("/chats")
    public List<SimpleChatDto> getChats(@RequestHeader("token") String token) {
        return userService.getChatsByUser(token);
    }

    @GetMapping(value = "/chat", params = "id")
    public ChatDto getChat(@RequestHeader("token") String token, @RequestParam int id) { // param - chat id
        return chatService.getWithMessagesById(id, token);
    }

    @PostMapping(value = "/chat/add")
    public void addMessage(@RequestHeader("token") String token, @RequestBody MessageDto dto) {
        messageService.add(dto, token);
    }
}
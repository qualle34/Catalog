package com.senla.catalog.controller;

import com.senla.catalog.dto.chat.ChatDto;
import com.senla.catalog.dto.chat.MessageDto;
import com.senla.catalog.service.security.token.TokenUtil;
import com.senla.catalog.serviceapi.IMessageService;
import com.senla.catalog.serviceapi.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/chats")
public class UserChatController {

    @Autowired
    private IUserService userService;

    @Autowired
    private IMessageService messageService;

    @GetMapping
    public List<ChatDto> getChats(@RequestHeader("token") String token) {
        return userService.getChatsDtoByUserId(userService.getIdByToken(token));
    }

    @GetMapping(value = "/chat", params = "id")
    public List<MessageDto> getMessages(@RequestHeader("token") String token, @RequestParam int id) { // param - chat id
        return messageService.getDtoByChatId(id);
    }

    @PostMapping(value = "/chat/add")
    public void addMessage(@RequestHeader("token") String token, @RequestBody MessageDto dto) {
        messageService.add(dto);
    }

    @DeleteMapping(value = "/chat/delete/{id}")
    public void deleteMessage(@RequestHeader("token") String token, @PathVariable(value = "id") int userId) { // param - message id
        messageService.delete(userId);
    }
}
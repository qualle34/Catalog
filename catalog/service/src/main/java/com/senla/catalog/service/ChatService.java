package com.senla.catalog.service;

import com.senla.catalog.daoapi.IChatDao;
import com.senla.catalog.dto.chat.ChatDto;
import com.senla.catalog.dto.chat.SimpleChatDto;
import com.senla.catalog.entity.Chat;
import com.senla.catalog.service.basic.AbstractService;
import com.senla.catalog.serviceapi.IChatService;
import com.senla.catalog.serviceapi.IMessageService;
import com.senla.catalog.serviceapi.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

@Service
public class ChatService extends AbstractService<Chat, Long> implements IChatService {

    private static final Logger logger = LoggerFactory.getLogger(ChatService.class);

    @Autowired
    private IChatDao chatDao;

    @Autowired
    private IUserService userService;

    @Autowired
    private IMessageService messageService;

    @Override
    protected String getDaoClassName() {
        return "chatDao";
    }

    @Override
    protected Class<Chat> getEntityClass() {
        return Chat.class;
    }

    @Override
    public ChatDto getWithMessagesById(long id, String token) {

        try {
            Chat chat = chatDao.getWithMessagesById(userService.getIdByToken(token), id);
            ChatDto dto = new ChatDto(chat.getTitle());
            dto.setId(chat.getId());
            dto.setMessages(messageService.messageListToDto(chat.getMessageList()));
            return dto;

        } catch (RuntimeException e) {
            logger.error("Get chat dto by id error: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public Chat getByUser(long userId, long chatId) {

        try {
            return chatDao.getById(userId, chatId);

        } catch (RuntimeException e) {
            logger.error("Get chat dto by id error: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public List<SimpleChatDto> chatsToDto(Collection<Chat> chatList) {
        List<SimpleChatDto> dtoList = new LinkedList<>();

        for (Chat chat : chatList) {
            dtoList.add(chatToDto(chat));
        }
        return dtoList;
    }

    @Override
    public SimpleChatDto chatToDto(Chat chat) {
        SimpleChatDto dto = new SimpleChatDto(chat.getTitle());
        dto.setId(chat.getId());
        return dto;
    }
}

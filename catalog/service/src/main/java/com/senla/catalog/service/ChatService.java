package com.senla.catalog.service;

import com.senla.catalog.daoapi.IChatDao;
import com.senla.catalog.dto.chat.ChatDto;
import com.senla.catalog.entity.Chat;
import com.senla.catalog.service.basic.AbstractService;
import com.senla.catalog.serviceapi.IChatService;
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

    @Override
    protected String getDaoClassName() {
        return "chatDao";
    }

    @Override
    protected Class<Chat> getEntityClass() {
        return Chat.class;
    }

    @Override
    public ChatDto getDtoById(long id) {

        try {
            return chatToDto(chatDao.getById(id));

        } catch (RuntimeException e) {
            logger.error("Get chat dto by id error: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public List<ChatDto> chatsToDto(Collection<Chat> chatList) {
        List<ChatDto> dtoList = new LinkedList<>();

        for (Chat chat : chatList) {
            dtoList.add(chatToDto(chat));
        }
        return dtoList;
    }

    @Override
    public ChatDto chatToDto(Chat chat) {
        ChatDto dto = new ChatDto(chat.getTitle());
        dto.setId(chat.getId());
        return dto;
    }
}

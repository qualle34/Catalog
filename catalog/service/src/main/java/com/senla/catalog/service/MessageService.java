package com.senla.catalog.service;

import com.senla.catalog.daoapi.IMessageDao;
import com.senla.catalog.dto.chat.MessageDto;
import com.senla.catalog.entity.Chat;
import com.senla.catalog.entity.Message;
import com.senla.catalog.entity.User;
import com.senla.catalog.service.basic.AbstractService;
import com.senla.catalog.serviceapi.IChatService;
import com.senla.catalog.serviceapi.IMessageService;
import com.senla.catalog.serviceapi.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Service
public class MessageService extends AbstractService<Message, Long> implements IMessageService {

    private static final Logger logger = LoggerFactory.getLogger(MessageService.class);

    @Autowired
    private IMessageDao messageDao;

    @Autowired
    private IChatService chatService;

    @Autowired
    private IUserService userService;

    @Override
    protected String getDaoClassName() {
        return "messageDao";
    }

    @Override
    protected Class<Message> getEntityClass() {
        return Message.class;
    }

    @Override
    public List<MessageDto> getByChat(long chatId) {

        try {
            return messageListToDto(messageDao.getByChat(chatId));

        } catch (RuntimeException e) {
            logger.error("Get message list by chat error: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public List<MessageDto> getByChat(long chatId, String token) {

        try {
            return messageListToDto(messageDao.getByChat(chatId, userService.getIdByToken(token)));

        } catch (RuntimeException e) {
            logger.error("Get message list by chat and user error: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public MessageDto messageToDto(Message message) {
        MessageDto dto = new MessageDto(message.getText(), message.getChat().getId(), message.getUser().getId());
        dto.setId(message.getId());
        dto.setSendDate(message.getSendDate());
        return dto;
    }

    @Override
    public Message dtoToMessage(MessageDto dto) {
        return new Message(dto.getText(), new Date(), chatService.getById(dto.getChatId()), userService.getById(dto.getUserId()));
    }

    @Override
    public List<MessageDto> messageListToDto(List<Message> messageList) {
        List<MessageDto> messageDtoList = new LinkedList<>();

        for (Message message : messageList) {
            messageDtoList.add(messageToDto(message));
        }
        return messageDtoList;
    }

    @Override
    @Transactional
    public void add(MessageDto dto) {

        try {
            messageDao.add(dtoToMessage(dto));

        } catch (RuntimeException e) {
            logger.error("Add message from dto error: " + e.getMessage());
            throw e;
        }
    }

    @Override
    @Transactional
    public void add(MessageDto dto, String token) {

        try {
            long userId = userService.getIdByToken(token);
            User user = userService.getById(userId);
            Chat chat = chatService.getByUser(userId, dto.getChatId());
            Message message = new Message(dto.getText(), new Date(), chat, user);
            messageDao.add(message);

        } catch (RuntimeException e) {
            logger.error("Add message from dto error: " + e.getMessage());
            throw e;
        }
    }

    @Override
    @Transactional
    public void delete(long id) {

        try {
            messageDao.delete(id);

        } catch (RuntimeException e) {
            logger.error("Delete message by id error: " + e.getMessage());
            throw e;
        }
    }
}
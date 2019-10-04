package com.senla.catalog.service;

import com.senla.catalog.daoapi.IUserDao;
import com.senla.catalog.dto.ChatDto;
import com.senla.catalog.dto.UserDto;
import com.senla.catalog.entity.Creds;
import com.senla.catalog.entity.SellerRating;
import com.senla.catalog.entity.User;
import com.senla.catalog.service.basic.AbstractService;
import com.senla.catalog.serviceapi.IChatService;
import com.senla.catalog.serviceapi.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService extends AbstractService<User, Integer> implements IUserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private IUserDao userDao;

    @Autowired
    IChatService chatService;

    @Override
    protected String getDaoClassName() {
        return "userDao";
    }

    @Override
    protected Class<User> getEntityClass() {
        return User.class;
    }

    @Override
    public List<User> getByName(String name) {

        try {
            return userDao.getByName(name);

        } catch (RuntimeException e) {
            logger.error("Get user by name error: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public UserDto getDtoById(int id) {

        try {
            User user = userDao.getWithCredsById(id);
            return userToDto(user, user.getCreds());

        } catch (RuntimeException e) {
            logger.error("Get user dto by id error: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public User getWithChatList(int id) {

        try {
            return userDao.getWithChatList(id);

        } catch (RuntimeException e) {
            logger.error("Get with chat list error: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public User getWithCredsByEmail(String email) {

        try {
            return userDao.getWithCredsByEmail(email);

        } catch (RuntimeException e) {
            logger.error("Get with creds by email error: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public User getFullUserById(int id) {

        try {
            return userDao.getFullUserById(id);

        } catch (RuntimeException e) {
            logger.error("Get full user by id error: " + e.getMessage());
            throw e;
        }
    }

    @Override
    @Transactional
    public void update(UserDto dto) {

        try {
            User user = userDao.getWithCredsById(dto.getId());
            user.setFirstname(dto.getFirstname());
            user.setLastname(dto.getLastname());
            user.setBirthdate(dto.getBirthdate());
            user.setPhone(dto.getPhone());
            user.setLocation(dto.getLocation());
            userDao.update(user);

        } catch (RuntimeException e) {
            logger.error("Update user from dto error: " + e.getMessage());
            throw e;
        }
    }

    @Override
    @Transactional
    public void add(UserDto dto) {

        try {
            userDao.add(dtoToUser(dto));

        } catch (RuntimeException e) {
            logger.error("Add user from dto error: " + e.getMessage());
            throw e;
        }
    }

    @Override
    @Transactional
    public void delete(int id) {

        try {
            userDao.delete(id);

        } catch (RuntimeException e) {
            logger.error("Delete user by id error: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public List<ChatDto> getChatsDtoByUserId(int userId) {
        return chatService.chatSetToDto(getWithChatList(userId).getChatSet());
    }

    @Override
    public UserDto userToDto(User user, Creds creds) {
        UserDto dto = new UserDto(user.getFirstname(), user.getLastname(), user.getBirthdate(), user.getPhone(),
                user.getLocation(), creds.getLogin(), creds.getPassword(), creds.getEmail(), creds.getRole());
        dto.setId(user.getId());
        return dto;
    }

    @Override
    public User dtoToUser(UserDto dto) {
        User user = new User(dto.getFirstname(), dto.getLastname(), dto.getBirthdate(), dto.getPhone(), dto.getLocation());
        user.setCreds(new Creds(dto.getLogin(), dto.getPassword(), dto.getRole(), dto.getEmail()));
        user.setRating(new SellerRating(0, 0));
        return user;
    }
}

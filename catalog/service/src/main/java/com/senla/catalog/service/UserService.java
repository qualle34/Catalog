package com.senla.catalog.service;

import com.senla.catalog.daoapi.IUserDao;
import com.senla.catalog.dto.chat.ChatDto;
import com.senla.catalog.dto.user.UserDto;
import com.senla.catalog.dto.user.UserRatingDto;
import com.senla.catalog.entity.Creds;
import com.senla.catalog.entity.UserRating;
import com.senla.catalog.entity.User;
import com.senla.catalog.entity.enums.UserRole;
import com.senla.catalog.service.basic.AbstractService;
import com.senla.catalog.serviceapi.IChatService;
import com.senla.catalog.serviceapi.IUserRatingService;
import com.senla.catalog.serviceapi.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;

@Service
public class UserService extends AbstractService<User, Long> implements IUserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private IUserDao userDao;

    @Autowired
    private IChatService chatService;

    @Autowired
    private IUserRatingService userRatingService;

    @Autowired
    private PasswordEncoder encoder;

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
            logger.error("Get users by name error: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public User getWithChatList(long id) {

        try {
            return userDao.getWithChatListById(id);

        } catch (RuntimeException e) {
            logger.error("Get user with chats error: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public User getWithCredsByLogin(String login) {

        try {
            return userDao.getWithCredsByLogin(login);

        } catch (RuntimeException e) {
            logger.error("Get user with creds by login error: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public User getFullById(long id) {

        try {
            return userDao.getFullById(id);

        } catch (RuntimeException e) {
            logger.error("Get full user by id error: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public UserDto getDtoById(long id) {

        try {
            User user = userDao.getWithCredsAndRatingById(id);
            return userToDto(user, user.getCreds(), user.getRating());

        } catch (RuntimeException e) {
            logger.error("Get user dto by id error: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public List<ChatDto> getChatsDtoByUserId(long userId) {
        return chatService.chatsToDto(getWithChatList(userId).getChatSet());
    }

    @Override
    public UserDto userToDto(User user, Creds creds, UserRating rating) {
        UserDto dto = new UserDto(user.getFirstname(), user.getLastname(), user.getBirthdate(), user.getPhone(),
                user.getLocation(), creds.getLogin(), creds.getEmail());
        dto.setId(user.getId());
        dto.setRating(rating.getRating());
        dto.setRoles(user.getRoleSet());
        return dto;
    }

    @Override
    public User dtoToUser(UserDto dto) {
        User user = new User(dto.getFirstname(), dto.getLastname(), dto.getBirthdate(), dto.getPhone(), dto.getLocation());
        user.setCreds(new Creds(dto.getLogin(), dto.getPassword(), dto.getEmail()));
        user.setRoleSet(new HashSet<>(Collections.singletonList(UserRole.USER)));
        user.setRating(new UserRating(0, 0));
        return user;
    }

    @Override
    @Transactional
    public void add(UserDto dto) {

        try {
            User user = dtoToUser(dto);
            user.getCreds().setPassword(encoder.encode(dto.getPassword()));
            userDao.add(user);

        } catch (RuntimeException e) {
            logger.error("Add user from dto error: " + e.getMessage());
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
    public void updateRating(UserRatingDto dto) {

        try {
            UserRating newUserRating = updateRating(userDao.getWithRatingById(dto.getId()).getRating(), dto.getAddRating());
            userRatingService.update(newUserRating);

        } catch (RuntimeException e) {
            logger.error("Update user from dto error: " + e.getMessage());
            throw e;
        }
    }

    @Override
    @Transactional
    public void delete(long id) {

        try {
            userDao.delete(id);

        } catch (RuntimeException e) {
            logger.error("Delete user by id error: " + e.getMessage());
            throw e;
        }
    }

    private UserRating updateRating(UserRating userRating, int addRating) {
        float oldRating = userRating.getRating();
        int oldRatingCount = userRating.getRatingCount();
        int newRatingCount = oldRatingCount + 1;
        float newRating;

        if (oldRatingCount != 0){
            newRating = (addRating + (oldRating * oldRatingCount)) / newRatingCount;

        } else {
            newRating = addRating;
        }

        userRating.setRatingCount(newRatingCount);
        userRating.setRating(newRating);

        return userRating;
    }
}
package com.senla.catalog.service;

import com.senla.catalog.daoapi.IUserDao;
import com.senla.catalog.dto.chat.ChatDto;
import com.senla.catalog.dto.user.SimpleUserDto;
import com.senla.catalog.dto.user.UserDto;
import com.senla.catalog.dto.user.UserRatingDto;
import com.senla.catalog.dto.user.UserRegistrationDto;
import com.senla.catalog.entity.Creds;
import com.senla.catalog.entity.User;
import com.senla.catalog.entity.UserRating;
import com.senla.catalog.entity.enums.UserRole;
import com.senla.catalog.service.basic.AbstractService;
import com.senla.catalog.service.security.token.TokenException;
import com.senla.catalog.service.security.token.TokenUtil;
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
    public long getIdByToken(String token) {

        try {
            String login = TokenUtil.getLogin(token);
            return userDao.getIdByLogin(login);

        } catch (RuntimeException e) {
            logger.error("Get user id by token error: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public User getWithChatListById(long id) {

        try {
            return userDao.getWithChatListById(id);

        } catch (RuntimeException e) {
            logger.error("Get user with chats error: " + e.getMessage());
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
    public UserDto getDtoByToken(String token) {
        return getDtoById(getIdByToken(token));
    }

    @Override
    public SimpleUserDto getSimpleDtoById(long id) {

        try {
            User user = userDao.getWithRatingById(id);
            return new SimpleUserDto(id, user.getFirstname(), user.getLastname(), user.getPhone(), user.getLocation(), user.getRating().getRating());

        } catch (RuntimeException e) {
            logger.error("Get simple user dto by id error: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public List<ChatDto> getChatsByUser(long userId) {
        return chatService.chatsToDto(getWithChatListById(userId).getChatSet());
    }

    @Override
    public List<ChatDto> getChatsByUser(String token) {
        return getChatsByUser(getIdByToken(token));
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
        user.setCreds(new Creds(dto.getLogin(), encoder.encode(dto.getPassword()), dto.getEmail()));
        user.setRoleSet(new HashSet<>(Collections.singletonList(UserRole.USER)));
        user.setRating(new UserRating(0, 0));
        return user;
    }

    @Override
    public User dtoToOldUser(UserDto dto) {
        User user = userDao.getWithCredsById(dto.getId());
        user.setFirstname(isNotEmpty(dto.getFirstname()) ? dto.getFirstname() : user.getFirstname());
        user.setLastname(isNotEmpty(dto.getLastname()) ? dto.getLastname() : user.getLastname());
        user.setBirthdate(isNotEmpty(dto.getBirthdate().toString()) ? dto.getBirthdate() : user.getBirthdate());
        user.setPhone(isNotEmpty(dto.getPhone()) ? dto.getPhone() : user.getPhone());
        user.setLocation(isNotEmpty(dto.getLocation()) ? dto.getLocation() : user.getLocation());
        user.getCreds().setEmail(isNotEmpty(dto.getEmail()) ? dto.getEmail() : user.getCreds().getEmail());
        user.getCreds().setPassword(isNotEmpty(dto.getPassword()) ? encoder.encode(dto.getPassword()) : user.getCreds().getPassword());

        return user;
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
    public void add(UserRegistrationDto dto) {

        try {
            User user = new User();
            user.setFirstname(dto.getFirstname());
            user.setCreds(new Creds(dto.getLogin(), encoder.encode(dto.getPassword()), dto.getEmail()));
            user.getRoleSet().add(UserRole.USER);
            user.setRating(new UserRating(0, 0));

            userDao.add(user);

        } catch (RuntimeException e) {
            logger.error("Add user from registration dto error: " + e.getMessage());
            throw e;
        }
    }

    @Override
    @Transactional
    public void update(UserDto dto) {

        try {
            userDao.update(dtoToOldUser(dto));

        } catch (RuntimeException e) {
            logger.error("Update user from dto error: " + e.getMessage());
            throw e;
        }
    }

    @Override
    @Transactional
    public void update(UserDto dto, String token) {

        try {
            if (dto.getId() == getIdByToken(token)) {
                userDao.update(dtoToOldUser(dto));
            }

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
    public void updateRating(UserRatingDto dto, String token) {

        if (TokenUtil.isValid(token)) {
            updateRating(dto);

        } else {
            throw new TokenException("Token exception");
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

    @Override
    @Transactional
    public void delete(String token) {

        try {
            userDao.delete(getIdByToken(token));

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

        if (oldRatingCount != 0) {
            newRating = (addRating + (oldRating * oldRatingCount)) / newRatingCount;

        } else {
            newRating = addRating;
        }

        userRating.setRatingCount(newRatingCount);
        userRating.setRating(newRating);

        return userRating;
    }

    private boolean isNotEmpty(String value) {
        return value != null && !value.equals("");
    }
}
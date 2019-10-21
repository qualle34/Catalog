package com.senla.catalog.serviceapi;

import com.senla.catalog.dto.chat.SimpleChatDto;
import com.senla.catalog.dto.user.SimpleUserDto;
import com.senla.catalog.dto.user.UserDto;
import com.senla.catalog.dto.user.UserRatingDto;
import com.senla.catalog.dto.user.UserRegistrationDto;
import com.senla.catalog.entity.Creds;
import com.senla.catalog.entity.User;
import com.senla.catalog.entity.UserRating;
import com.senla.catalog.serviceapi.basic.IGenericService;

import java.util.List;

public interface IUserService extends IGenericService<User, Long> {

    long getIdByToken(String token);

    User getWithChatListById(long id);

    User getFullById(long id);

    UserDto getDtoById(long id);

    UserDto getDtoByToken(String token);

    SimpleUserDto getSimpleDtoById(long id);

    List<SimpleChatDto> getChatsByUser(long userId);

    List<SimpleChatDto> getChatsByUser(String token);

    UserDto userToDto(User user, Creds creds, UserRating rating);

    User dtoToUser(UserDto dto);

    User dtoToOldUser(UserDto dto);

    void add(UserDto dto);

    void add(UserRegistrationDto dto);

    void update(UserDto dto);

    void update(UserDto dto, String token);

    void updateRating(UserRatingDto dto);

    void updateRating(UserRatingDto dto, String token);

    void delete(long id);

    void delete(String token);
}

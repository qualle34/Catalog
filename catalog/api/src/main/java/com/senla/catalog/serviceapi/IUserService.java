package com.senla.catalog.serviceapi;

import com.senla.catalog.dto.chat.ChatDto;
import com.senla.catalog.dto.user.SimpleUserDto;
import com.senla.catalog.dto.user.UserDto;
import com.senla.catalog.dto.user.UserRatingDto;
import com.senla.catalog.dto.user.UserRegistrationDto;
import com.senla.catalog.entity.Creds;
import com.senla.catalog.entity.UserRating;
import com.senla.catalog.entity.User;
import com.senla.catalog.serviceapi.basic.IGenericService;

import java.util.List;

public interface IUserService extends IGenericService<User, Long> {

    long getIdByToken(String token);

    User getWithChatList(long id);

    User getFullById(long id);

    UserDto getDtoById(long id);

    SimpleUserDto getSimpleDtoById(int id);

    List<ChatDto> getChatsDtoByUserId(long userId);

    UserDto userToDto(User user, Creds creds, UserRating rating);

    User dtoToUser(UserDto dto);

    User dtoToOldUser(UserDto dto);

    void add(UserDto dto);

    void add(UserRegistrationDto dto);

    void update(UserDto dto);

    void update(UserDto dto, String token);

    void updateRating(UserRatingDto dto);

    void delete(long id);

    void delete(long id, String token);
}

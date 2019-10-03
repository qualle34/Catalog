package com.senla.catalog.serviceapi;

import com.senla.catalog.dto.UserDto;
import com.senla.catalog.entity.Creds;
import com.senla.catalog.entity.User;
import com.senla.catalog.serviceapi.basic.IGenericService;

import java.util.List;

public interface IUserService extends IGenericService<User, Integer> {

    List<User> getByName(String name);

    UserDto getDtoById(int id);

    User getWithChatList(int id);

    User getWithCredsByEmail(String email);

    User getFullUserById(int id);

    void update(UserDto dto);

    void add(UserDto dto);

    UserDto userToDto(User user, Creds creds);

    User dtoToUser(UserDto dto);
}
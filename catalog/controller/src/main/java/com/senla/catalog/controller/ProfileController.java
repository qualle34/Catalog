package com.senla.catalog.controller;

import com.senla.catalog.dto.UserDto;
import com.senla.catalog.entity.Creds;
import com.senla.catalog.entity.User;
import com.senla.catalog.serviceapi.ICredsService;
import com.senla.catalog.serviceapi.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/profile")
public class ProfileController {

    @Autowired
    IUserService userService;

    @Autowired
    ICredsService credsService;

    @GetMapping(params = "id")
    public UserDto getProfile(@RequestParam int id) {
        return objectToDto(userService.getById(id), credsService.getById(id));
    }

    @PostMapping(value = "/edit")
    public void updateProfile(@RequestBody UserDto userDto) {
        User user = userService.getById(userDto.getId());
        user.setFirstname(userDto.getFirstname());
        user.setLastname(userDto.getLastname());
        user.setBirthdate(userDto.getBirthdate());
        user.setPhone(userDto.getPhone());
        user.setLocation(userDto.getLocation());
        userService.update(user);
    }

    @DeleteMapping(value = "/delete")
    public void deleteProfile(@RequestBody UserDto userDto) {
        userService.delete(userService.getById(userDto.getId()));
    }

    private UserDto objectToDto(User user, Creds creds) {
        UserDto dto = new UserDto(user.getFirstname(), user.getLastname(), user.getBirthdate(), user.getPhone(),
                user.getLocation(), creds.getLogin(), creds.getPassword(), creds.getEmail(), creds.getRole());
        dto.setId(user.getId());
        return dto;
    }
}

package com.senla.catalog.controller;

import com.senla.catalog.dto.UserDto;
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
        return userService.userToDto(userService.getById(id), credsService.getById(id));
    }

    @PostMapping(value = "/edit")
    public void updateProfile(@RequestBody UserDto dto) {
        userService.update(userService.updateUserFromDto(dto));
    }

    @DeleteMapping(value = "/delete/{id}")
    public void deleteProfile(@PathVariable(value = "id") int userId) {
        userService.delete(userService.getById(userId));
    }
}
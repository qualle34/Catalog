package com.senla.catalog.controller;

import com.senla.catalog.dto.UserDto;
import com.senla.catalog.entity.Creds;
import com.senla.catalog.entity.User;
import com.senla.catalog.serviceapi.ICredsService;
import com.senla.catalog.serviceapi.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/profile")
public class ProfileController {

    @Autowired
    IUserService userService;

    @Autowired
    ICredsService credsService;

    @RequestMapping(params = "id", method = RequestMethod.GET)
    public UserDto getProfileData(@RequestParam int id) {
        return objectToDto(userService.getById(id), credsService.getById(id));
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public void updateProfile(UserDto userDto) {

    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public void deleteProfile(UserDto userDto) {

    }

    private UserDto objectToDto(User user, Creds creds) {
        return new UserDto(user.getFirstname(), user.getLastname(), user.getBirthdate(), user.getPhone(),
                user.getLocation(), creds.getLogin(), creds.getPassword(), creds.getEmail(), creds.getRole());
    }
}

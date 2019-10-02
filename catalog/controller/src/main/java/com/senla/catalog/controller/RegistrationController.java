package com.senla.catalog.controller;

import com.senla.catalog.dto.UserDto;
import com.senla.catalog.serviceapi.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/registration")
public class RegistrationController {

    @Autowired
    IUserService userService;

    @GetMapping()
    public String getRegistrationPage() {
        return "registration";
    }

    @PostMapping(value = "/register")
    public void addUser(@RequestBody UserDto dto) {
        userService.add(userService.dtoToUser(dto));
    }
}

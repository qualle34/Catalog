package com.senla.catalog.controller;

import com.senla.catalog.dto.user.UserDto;
import com.senla.catalog.serviceapi.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/registration")
@CrossOrigin(origins = "http://localhost:4200")
public class RegistrationController {

    @Autowired
    private IUserService userService;

    @GetMapping()
    public String getRegistrationPage() {
        return "registration";
    }

    @PostMapping(value = "/register")
    public void addUser(@RequestBody UserDto dto) {
        userService.add(dto);
    }
}

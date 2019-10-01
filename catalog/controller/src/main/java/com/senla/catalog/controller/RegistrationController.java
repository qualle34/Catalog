package com.senla.catalog.controller;

import com.senla.catalog.dto.UserDto;
import com.senla.catalog.entity.Creds;
import com.senla.catalog.entity.SellerRating;
import com.senla.catalog.entity.User;
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
        Creds creds = new Creds(dto.getLogin(), dto.getPassword(), dto.getRole(), dto.getEmail());
        User user = new User(dto.getFirstname(), dto.getLastname(), dto.getBirthdate(), dto.getPhone(), dto.getLocation());
        user.setCreds(creds);
        user.setRating(new SellerRating(0, 0));
        userService.add(user);
    }
}

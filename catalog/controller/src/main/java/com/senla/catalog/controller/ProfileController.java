package com.senla.catalog.controller;

import com.senla.catalog.dto.user.UserDto;
import com.senla.catalog.dto.user.UserRatingDto;
import com.senla.catalog.serviceapi.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/profile")
public class ProfileController {

    @Autowired
    private IUserService userService;

    @GetMapping(params = "id")
    public UserDto getProfile(@RequestParam int id) {
        return userService.getDtoById(id);
    }

    @PutMapping
    public void updateRating(@RequestBody UserRatingDto dto) {
        userService.updateRating(dto);
    }
}
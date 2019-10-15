package com.senla.catalog.controller;

import com.senla.catalog.dto.user.SimpleUserDto;
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
    public SimpleUserDto getProfile(@RequestParam int id) {
        return userService.getSimpleDtoById(id);
    }

    @PutMapping
    public void updateRating(@RequestBody UserRatingDto dto) {
        userService.updateRating(dto);
    }
}
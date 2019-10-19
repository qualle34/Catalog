package com.senla.catalog.controller;

import com.senla.catalog.dto.user.DealDto;
import com.senla.catalog.dto.user.UserDto;
import com.senla.catalog.serviceapi.IDealService;
import com.senla.catalog.serviceapi.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/my/profile")
public class UserProfileController {

    @Autowired
    private IUserService userService;

    @Autowired
    private IDealService dealService;

    @GetMapping
    public UserDto getProfile(@RequestHeader("token") String token) {
        return userService.getDtoById(userService.getIdByToken(token));
    }

    @PutMapping(value = "/edit")
    public void updateProfile(@RequestHeader("token") String token, @RequestBody UserDto dto) {
        userService.update(dto, token);
    }

    @DeleteMapping(value = "/delete")
    public void deleteProfile(@RequestHeader("token") String token) {
        userService.delete(userService.getIdByToken(token));
    }

    @GetMapping(value = "/deals/buy")
    public List<DealDto> getBuyerDeals(@RequestHeader("token") String token) {
        return dealService.getByBuyer(userService.getIdByToken(token));
    }

    @GetMapping(value = "/deals/sell")
    public List<DealDto> getSellerDeals(@RequestHeader("token") String token) {
        return dealService.getBySeller(userService.getIdByToken(token));
    }
}


package com.senla.catalog.controller;

import com.senla.catalog.dto.user.DealDto;
import com.senla.catalog.dto.user.UserDto;
import com.senla.catalog.service.security.token.TokenUtil;
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
        long id = userService.getWithCredsByLogin(TokenUtil.getLogin(token)).getId();
        return userService.getDtoById(id);
    }

    @PutMapping(value = "/edit")
    public void updateProfile(@RequestHeader("token") String token, @RequestBody UserDto dto) {
        userService.update(dto);
    }

    @DeleteMapping(value = "/delete")
    public void deleteProfile(@RequestHeader("token") String token) {
        long id = userService.getWithCredsByLogin(TokenUtil.getLogin(token)).getId();
        userService.delete(id);
    }

    @GetMapping(value = "/deals/buy")
    public List<DealDto> getBuyerDeals(@RequestHeader("token") String token) {
        long id = userService.getWithCredsByLogin(TokenUtil.getLogin(token)).getId();
        return dealService.getDtoByBuyerId(id);
    }

    @GetMapping(value = "/deals/sell")
    public List<DealDto> getSellerDeals(@RequestHeader("token") String token) {
        long id = userService.getWithCredsByLogin(TokenUtil.getLogin(token)).getId();
        return dealService.getDtoBySellerId(id);
    }

    @DeleteMapping(value = "/deals/delete")
    public void deleteDeal(@RequestHeader("token") String token) {
        long id = userService.getWithCredsByLogin(TokenUtil.getLogin(token)).getId();
        dealService.delete(id);
    }
}


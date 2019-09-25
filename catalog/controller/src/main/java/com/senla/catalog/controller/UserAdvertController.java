package com.senla.catalog.controller;

import com.senla.catalog.serviceapi.IAdvertService;
import com.senla.catalog.serviceapi.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserAdvertController {

    @Autowired
    IAdvertService advertService;

    @Autowired
    IUserService userService;

    @RequestMapping(value = "/my_adverts", params = "user_id")
    public String getUserAdverts(@RequestParam String id) {
        return advertService.getByUser(userService.getById(Integer.parseInt(id))).toString();
    }

    @RequestMapping(value = "/my_advert", params = "id")
    public String getUserAdvert(@RequestParam String id) {
        return advertService.getById(Integer.parseInt(id)).toString();
    }
}

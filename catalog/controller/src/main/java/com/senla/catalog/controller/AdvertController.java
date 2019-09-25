package com.senla.catalog.controller;

import com.senla.catalog.serviceapi.IAdvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdvertController {

    @Autowired
    IAdvertService advertService;

    @RequestMapping(value = "/advert", params = "id")
    public String getPage(@RequestParam String id) {
        return advertService.getById(Integer.parseInt(id)).toString();
    }
}

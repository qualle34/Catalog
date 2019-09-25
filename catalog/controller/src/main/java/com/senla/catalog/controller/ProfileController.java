package com.senla.catalog.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProfileController {

    @RequestMapping(value = "/profile")
    public String getPage() {
        return "profile";
    }
}

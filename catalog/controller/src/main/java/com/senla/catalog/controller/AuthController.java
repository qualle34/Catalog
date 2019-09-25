package com.senla.catalog.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @RequestMapping(value = "/login")
    public String getLoginPage() {
        return "login";
    }

    @RequestMapping(value = "/registration")
    public String getRegistrationPage() {
        return "registration";
    }
}

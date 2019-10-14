package com.senla.catalog.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @GetMapping(value = "/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping(value = "/login-success")
    public String loginSuccess() {
        return "Login Success ";
    }

    @GetMapping(value = "/login-error")
    public String loginError() {
        return "Login Error";
    }

    @GetMapping(value = "/logout-success")
    public String logoutSuccess() {
        return "Logout Success";
    }
}

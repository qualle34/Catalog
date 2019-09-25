package com.senla.catalog.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController {

    @RequestMapping(value = "/chat")
    public String getRegistrationPage() {
        return "chat";
    }
}

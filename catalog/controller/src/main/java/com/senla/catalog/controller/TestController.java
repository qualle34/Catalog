package com.senla.catalog.controller;

import com.senla.catalog.serviceapi.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/test")
public class TestController {

    private IUserService userService;
    private ICredsService credsService;
    private IDealService dealService;
    private IUserRatingService sellerRatingService;
    private ICategoryService categoryService;
    private IAdvertService advertService;
    private ICommentService commentService;
    private IChatService chatService;
    private IMessageService messageService;
    private IVipInfoService vipInfoService;

    @Autowired
    public TestController(IUserService userService, ICredsService credsService, IDealService dealService,
                          IUserRatingService sellerRatingService, ICategoryService categoryService,
                          IAdvertService advertService, ICommentService commentService, IChatService chatService,
                          IMessageService messageService, IVipInfoService vipInfoService) {

        this.userService = userService;
        this.credsService = credsService;
        this.dealService = dealService;
        this.sellerRatingService = sellerRatingService;
        this.categoryService = categoryService;
        this.advertService = advertService;
        this.commentService = commentService;
        this.chatService = chatService;
        this.messageService = messageService;
        this.vipInfoService = vipInfoService;
    }

    @GetMapping(value = "all")
    private String getAll() {
        return userService.getAll().toString() +
                credsService.getAll().toString() +
                dealService.getAll().toString() +
                sellerRatingService.getAll().toString() +
                categoryService.getAll().toString() +
                advertService.getAll().toString() +
                commentService.getAll().toString() +
                chatService.getAll().toString() +
                messageService.getAll().toString() +
                vipInfoService.getAll().toString();
    }

    @GetMapping(value = "user")
    public String user(){
       return userService.getWithCredsByLogin("Dimmer").getCreds().toString();
    }
}

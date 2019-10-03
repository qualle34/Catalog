package com.senla.catalog.controller;

import com.senla.catalog.serviceapi.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/test")
public class TestController {

    @Autowired
    private IUserService userService;

    @Autowired
    private ICredsService credsService;

    @Autowired
    private IDealService dealService;

    @Autowired
    private ISellerRatingService sellerRatingService;

    @Autowired
    private ICategoryService categoryService;

    @Autowired
    private IAdvertService advertService;

    @Autowired
    private ICommentService commentService;

    @Autowired
    private IChatService chatService;

    @Autowired
    private IMessageService messageService;

    @Autowired
    private IVipInfoService vipInfoService;

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
       return userService.getWithCredsByEmail("vova@gmail.com").toString();
    }

//    advertDto.setComments(commentService.CommentListToDto(commentService.getByAdvert(advert)));
//    тоже не очень, сервис должен отдавать ДТО, например
//    public UserDto getUserById(Long Id);
//
//    и принимать ДТО, например
//    public void saveUser(UserDto user);
}

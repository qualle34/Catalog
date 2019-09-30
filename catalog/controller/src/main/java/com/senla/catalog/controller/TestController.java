package com.senla.catalog.controller;

import com.senla.catalog.entity.*;
import com.senla.catalog.entity.enums.AdvertType;
import com.senla.catalog.entity.enums.UserRole;
import com.senla.catalog.serviceapi.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
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

    @RequestMapping(value = "/test/all")
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

    // TODO: 27.09.2019 error
    @RequestMapping(value = "/test/add")
    private String addUser() {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = "1982-08-31";

        Date birthdate = null;

        try {
            birthdate = sdf.parse(date);
        } catch (ParseException e) {
            System.out.println("Error");
        }

        Creds creds = new Creds("Mah", "qwerty", UserRole.ADMIN, "mah@mail.ru");
        SellerRating sellerRating = new SellerRating(7.8F, 4);

        User user = new User("Маша", "Машина", birthdate, "+375333213882", "Варшава");

        user.setCreds(creds);
        user.setRating(sellerRating);

        userService.add(user);
        return "User added";
    }

    // TODO: 27.09.2019 error
    @RequestMapping(value = "/test/add_advert")
    private String addAdvert() {

        User user = userService.getById(4);
        Category category = categoryService.getById(5);

        Advert advert = new Advert("Test", "Test", 1234.4D, AdvertType.BUY,user, category);
        advertService.add(advert);
        return "Advert added";
    }

    @RequestMapping(value = "/test/add_category")
    private String addCategory() {

        Category category = new Category("Мебель");

        categoryService.add(category);
        return "Category added";
    }
}

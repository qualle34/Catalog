package com.senla.catalog.controller;

import com.senla.catalog.entity.Advert;
import com.senla.catalog.entity.Creds;
import com.senla.catalog.entity.SellerRating;
import com.senla.catalog.entity.User;
import com.senla.catalog.entity.constants.AdvertType;
import com.senla.catalog.entity.constants.UserRole;
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

    @RequestMapping(value = "/test")
    public String getPage() {
        return "test";
    }

    private void printAll() {
        System.out.println(userService.getAll().toString());
        System.out.println(credsService.getAll().toString());
        System.out.println(dealService.getAll().toString());
        System.out.println(sellerRatingService.getAll().toString());
        System.out.println(categoryService.getAll().toString());
        System.out.println(advertService.getAll().toString());
        System.out.println(commentService.getAll().toString());
        System.out.println(chatService.getAll().toString());
        System.out.println(messageService.getAll().toString());
        System.out.println(vipInfoService.getAll().toString());
    }

    private void addUser() {
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
    }

    private void printAdverts() {

        for (Advert advert : advertService.getByTypeSorted(AdvertType.SELL)) {
            System.out.print(advert.getId() + " " + advert.getTitle() + " " + advert.getUser().getRating().getRating());
            if (advert.getVipInfo() != null) {
                System.out.println(" vip");
            } else {
                System.out.println(" common");
            }
        }
    }
}

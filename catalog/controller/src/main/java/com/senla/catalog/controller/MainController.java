package com.senla.catalog.controller;

import com.senla.catalog.entity.*;
import com.senla.catalog.entity.constants.UserRole;
import com.senla.catalog.serviceapi.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class MainController {

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

    //test
    public void start() {
/*
Возможность проплатить нахождение объявления в топе выдачи.
Система рейтингов продавцов, влияющая на положение объявлений продавца в поисковой выдаче. Чем ниже рейтинг, тем ниже объявление в выдаче.
 */
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
    }

    private void communication() {
        User seller = userService.getById(4);
        User buyer = userService.getById(1);
        Chat chat = chatService.getById(1);

        Message message1 = new Message("Привет", new Date(), chat, buyer);
        messageService.add(message1);
        Message message2 = new Message("Привет, как лексус?", new Date(), chat, seller);
        messageService.add(message2);
    }

    private void printMessages() {

        for (Message message : chatService.getWithMessagesById(1).getMessageSet()) {
            System.out.println(message.toString());
        }
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

        Creds creds = new Creds("Mah", "qwerty", UserRole.USER, "mah@mail.ru");
        SellerRating sellerRating = new SellerRating(7.8F, 4);

        User user = new User("Маша", "Машина", birthdate, "+375333213882", "Варшава");

        user.setCreds(creds);
        user.setRating(sellerRating);

        userService.add(user);
    }
}

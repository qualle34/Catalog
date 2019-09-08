package com.senla.catalog.controller;

import com.senla.catalog.entity.Creds;
import com.senla.catalog.entity.SellerRating;
import com.senla.catalog.entity.User;
import com.senla.catalog.service.*;
import com.senla.catalog.serviceapi.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Controller {


    public static void main(String... args) {

        //test
        addUser();
    }

    private static void getAll() {

        IUserService userService = new UserService();
        ICredsService credsService = new CredsService();
        ISalesHistoryService salesHistoryService = new SalesHistoryService();
        ISellerRatingService sellerRatingService = new SellerRatingService();
        ICategoryService categoryService = new CategoryService();
        IAdvertService advertService = new AdvertService();
        ICommentService commentService = new CommentService();
        IChatService chatService = new ChatService();
        IMessageService messageService = new MessageService();

        System.out.println(userService.getAll().toString());
        System.out.println(credsService.getAll().toString());
        System.out.println(salesHistoryService.getAll().toString());
        System.out.println(sellerRatingService.getAll().toString());
        System.out.println(categoryService.getAll().toString());
        System.out.println(advertService.getAll().toString());
        System.out.println(commentService.getAll().toString());
        System.out.println(chatService.getAll().toString());
        System.out.println(messageService.getAll().toString());
    }

    private static void addUser() {

        IUserService userService = new UserService();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = "1982-08-31";

        Date birthdate = null;

        try {
            birthdate = sdf.parse(date);
        } catch (ParseException e) {
            System.out.println("Error");
        }

        Creds creds = new Creds("Mah", "qwerty", "user", "mah@mail.ru");
        SellerRating sellerRating = new SellerRating(7.8F, 4);

        User user = new User("Маша", "Машина", birthdate, "+375333213882", "Варшава", creds, sellerRating);

        userService.add(user);
    }
}

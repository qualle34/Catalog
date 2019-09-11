package com.senla.catalog.controller;

import com.senla.catalog.dao.util.HibernateUtil;
import com.senla.catalog.entity.*;
import com.senla.catalog.service.*;
import com.senla.catalog.serviceapi.*;
import org.hibernate.Session;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Controller {

    private Session session = HibernateUtil.getSession();

    private IUserService userService = UserService.getInstance(session);
    private ICredsService credsService = CredsService.getInstance(session);
    private ISalesHistoryService salesHistoryService = SalesHistoryService.getInstance(session);
    private ISellerRatingService sellerRatingService = SellerRatingService.getInstance(session);
    private ICategoryService categoryService = CategoryService.getInstance(session);
    private IAdvertService advertService = AdvertService.getInstance(session);
    private ICommentService commentService = CommentService.getInstance(session);
    private IChatService chatService = ChatService.getInstance(session);
    private IMessageService messageService = MessageService.getInstance(session);

    public void start() {
        //test

        System.out.println(userService.getByName("Андрей").toString());

//        addUser(session);
//        updateUser(session);
//        printAll(session);
//        deleteUser(session);

//        customUserQuery(session);

//        communication(session);
//        printMessages(session);

        session.close();
    }

    private void printMessages(Session session) {

        for (Message message : chatService.getById(1).getMessageList()) {
            System.out.println(message.toString());
        }
    }

    private void communication(Session session) {

        User seller = userService.getById(4);
        User buyer = userService.getById(1);
        Chat chat = chatService.getById(1);

        Message message1 = new Message("Привет", new Date(), chat, buyer);
        messageService.add(message1);
        Message message2 = new Message("Привет, как лексус?", new Date(), chat, seller);
        messageService.add(message2);
    }

    private void printAll(Session session) {

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

    private void updateUser(Session session) {

        User user = userService.getById(3);
        System.out.println(user.toString());
        user.setFirstname("Олег");
        user.setLastname("Олегов");
        userService.update(user);
    }

    private void deleteUser(Session session) {

        User user = userService.getById(7);
        userService.delete(user);
    }

    private void addUser(Session session) {

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

        User user = new User("Маша", "Машина", birthdate, "+375333213882", "Варшава");

        user.setCreds(creds);
        user.setRating(sellerRating);

        userService.add(user);
    }
}

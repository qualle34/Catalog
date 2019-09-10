package com.senla.catalog.controller;

import com.senla.catalog.dao.*;
import com.senla.catalog.dao.util.HibernateUtil;
import com.senla.catalog.daoapi.*;
import com.senla.catalog.entity.*;
import com.senla.catalog.service.*;
import com.senla.catalog.serviceapi.*;
import org.hibernate.Session;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

public class Controller {


    public static void main(String... args) {
        Session session = HibernateUtil.getSession();

        //test

//        addUser(session);
//        updateUser(session);
//        printAll(session);
//        deleteUser(session);

//        customUserQuery(session);

//        communication(session);
//        printMessages(session);

        session.close();
    }

    private static void printMessages(Session session){

        IChatDao chatDao = new ChatDao(session);
        IChatService chatService = new ChatService(chatDao, session);

        for (Message message : chatService.getById(1).getMessageList()){
            System.out.println(message.toString());
        }
    }

    private static void communication(Session session) {

        IUserDao userDao = new UserDao(session);
        IChatDao chatDao = new ChatDao(session);
        IMessageDao messageDao = new MessageDao(session);

        IUserService userService = new UserService(userDao, session);
        IChatService chatService = new ChatService(chatDao, session);
        IMessageService messageService = new MessageService(messageDao, session);

        User seller = userService.getById(4);
        User buyer = userService.getById(1);
        Chat chat = chatService.getById(1);

        Message message1 = new Message("Привет", new Date(), chat, buyer);
        messageService.add(message1);
        Message message2 = new Message("Привет, как лексус?", new Date(), chat, seller);
        messageService.add(message2);
    }

    private static void customUserQuery(Session session) {
        IUserDao userDao = new UserDao(session);
        System.out.println(userDao.getByName("Аня").toString());
    }

    private static void printAll(Session session) {

        IUserDao userDao = new UserDao(session);
        ICredsDao credsDao = new CredsDao(session);
        ISalesHistoryDao salesHistoryDao = new SalesHistoryDao(session);
        ISellerRatingDao sellerRatingDao = new SellerRatingDao(session);
        ICategoryDao categoryDao = new CategoryDao(session);
        IAdvertDao advertDao = new AdvertDao(session);
        ICommentDao commentDao = new CommentDao(session);
        IChatDao chatDao = new ChatDao(session);
        IMessageDao messageDao = new MessageDao(session);

        IUserService userService = new UserService(userDao, session);
        ICredsService credsService = new CredsService(credsDao, session);
        ISalesHistoryService salesHistoryService = new SalesHistoryService(salesHistoryDao, session);
        ISellerRatingService sellerRatingService = new SellerRatingService(sellerRatingDao, session);
        ICategoryService categoryService = new CategoryService(categoryDao, session);
        IAdvertService advertService = new AdvertService(advertDao, session);
        ICommentService commentService = new CommentService(commentDao, session);
        IChatService chatService = new ChatService(chatDao, session);
        IMessageService messageService = new MessageService(messageDao, session);

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

    private static void updateUser(Session session) {

        IUserDao userDao = new UserDao(session);
        IUserService userService = new UserService(userDao, session);
        User user = userService.getById(3);
        System.out.println(user.toString());
        user.setFirstname("Олег");
        user.setLastname("Олегов");
        userService.update(user);
    }

    private static void deleteUser(Session session) {

        IUserDao userDao = new UserDao(session);
        IUserService userService = new UserService(userDao, session);
        User user = userService.getById(7);
        userService.delete(user);
    }

    private static void addUser(Session session) {

        IUserDao userDao = new UserDao(session);
        IUserService userService = new UserService(userDao, session);

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

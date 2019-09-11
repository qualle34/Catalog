package com.senla.catalog.controller;

import com.senla.catalog.dao.util.HibernateUtil;
import com.senla.catalog.entity.*;
import com.senla.catalog.service.*;
import com.senla.catalog.serviceapi.*;
import com.senla.csvhelper.CsvService;
import org.hibernate.Session;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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

//        addUser();
//        updateUser();
//        printAll();
//        deleteUser();

//        customUserQuery();

//        communication();
//        printMessages();

//        printAdverts();

//        csvWriteUsers();
//        csvSendUsersToDb();

        session.close();
    }

    private void csvWriteUsers() {

        List<User> userList = userService.getAll();
        List<Object> objectList = (List<Object>) (List) userList;

        CsvService csvService = new CsvService();
        csvService.write(objectList);
    }

    private void csvSendUsersToDb() {

        List objectList = new CsvService().read(User.class);

        for (Object obj : objectList) {

            User user = (User) obj;

            user.getCreds().setUser(user);
            user.getRating().setUser(user);

            // reset old id (very important)
            user.setId(0);
            user.getCreds().setId(0);
            user.getRating().setId(0);

            userService.add(user);
        }
    }

    private void printMessages() {

        for (Message message : chatService.getWithMessagesById(1).getMessageList()) {
            System.out.println(message.toString());
        }
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

    private void printAdverts() {

        for (Advert advert : categoryService.getWithAdvertsByName("Электроника").getAdvertList()) {
            System.out.println(advert.toString());
        }
    }

    private void printAll() {

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

    private void updateUser() {

        User user = userService.getById(3);
        System.out.println(user.toString());
        user.setFirstname("Олег");
        user.setLastname("Олегов");
        userService.update(user);
    }

    private void deleteUser() {

        User user = userService.getById(2);
        userService.delete(user);
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

        Creds creds = new Creds("Mah", "qwerty", "user", "mah@mail.ru");
        SellerRating sellerRating = new SellerRating(7.8F, 4);

        User user = new User("Маша", "Машина", birthdate, "+375333213882", "Варшава");

        user.setCreds(creds);
        user.setRating(sellerRating);

        userService.add(user);
    }
}

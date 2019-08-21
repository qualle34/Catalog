package com.test;

import com.senla.csvhelper.CsvProcessor;

import java.util.ArrayList;

public class Test {

    public static void main(String[] args) {

        Dog dog1 = new Dog(23, "karl");
        Dog dog2 = new Dog(2, "deni");

        CsvProcessor processor = new CsvProcessor();

        User user1 = new User(1, "Karl", "1234", dog1);
        User user2 = new User(2, "Jon", "435");
        User user3 = new User(3, "Den", "2345", dog2);

        ArrayList<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);

        for (User user : users) {

            try {
                processor.writeObject(user);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        try {
            processor.writeObject(dog1);
            processor.writeObject(dog2);
        } catch (Exception e) {
            e.printStackTrace();
        }

//        ArrayList<User> users2 = new ArrayList<>();
//        User user11 = new User();
//        User user22 = new User();
//        User user33 = new User();
//
//        users2.add(user11);
//        users2.add(user22);
//        users2.add(user33);
//
//        for (int i = 0; i <= users2.size()-1; i++) {
//            User user = users2.get(i);
//            try {
//                user = (User) processor.readObject(user, i+1);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//            users2.set(i, user);
//        }
//
//      System.out.println(users2.toString());
    }

}

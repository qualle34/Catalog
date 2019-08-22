package com.test;

import com.senla.csvhelper.CsvWorker;

import java.util.LinkedList;

public class Test {

    public static void main(String[] args) {

        Dog dog1 = new Dog(1, "deni");
        Dog dog2 = new Dog(2, "karli");
        User user1 = new User(1, "Karl", "1234", dog2);
        User user2 = new User(2, "Jon", "435");
        User user3 = new User(3, "Den", "2345", dog1);


        LinkedList<Object> users = new LinkedList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);

        CsvWorker csvWorker = new CsvWorker();
        csvWorker.write(users);

        LinkedList users2 = csvWorker.read(new User());
        System.out.println(users2.toString());


        // csvWorker.write(users);

        //   LinkedList users2 = csvWorker.read(new User());
        //   System.out.println(users2.toString());


//        for (User user : users) {
//
//            try {
//                processor.writeObject(user);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//
//        try {
//            processor.writeObject(dog1);
//            processor.writeObject(dog2);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

//
//        ArrayList<User> users2 = new ArrayList<>();
//        User user11 = new User();
//        User user22 = new User();
//        User user33 = new User();
//
//        users2.add(user11);
//        users2.add(user22);
//        users2.add(user33);
//
//        for (int i = 0; i <= users2.size() - 1; i++) {
//            User user = users2.get(i);
//            try {
//                user = (User) processor.readObject(user, i + 1);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//            users2.set(i, user);
//        }
//
//        for (int i = 0; i <= users2.size() - 1; i++) {
//            User user = users2.get(i);
//            try {
//                if (user.getDog() != null) {
//                    int id = user.getDog().getId();
//                    int j = 1;
//                    do {
//                        if (processor.readObject(user.getDog(), j));)
//
//                    } while ()
//
//                    user.setDog((Dog) processor.readObject(user.getDog(), 1));
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//            users2.set(i, user);
//        }
//
//        for (User user : users2) {
//
//            System.out.print(user.toString());
//            if (user.getDog() != null) {
//                System.out.println(" " + user.getDog().toString());
//            } else {
//                System.out.println(" ");
//            }
//        }


//        User user = new User();
//        try {
//            user = (User) processor.readObject(user, 1);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        System.out.println(user.toString());
//        System.out.println(user.getDog().toString());
//
//        try {
//            user.setDog((Dog) processor.readObject(user.getDog(), 1));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//
//
//        System.out.println(user.getDog().getId());
    }

}

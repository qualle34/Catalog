package test;

import com.senla.csvhelper.CsvService;

import java.util.LinkedList;


public class Test {

    public static void main(String[] args) {

//        Dog dog1 = new Dog(1, "deni");
//        Dog dog2 = new Dog(2, "karli");
//        User user1 = new User(1, "Karl", "1234", dog2);
//        User user2 = new User(2, "Jon", "435");
//        User user3 = new User(3, "Den", "2345", dog1);
//
//        LinkedList<Object> users = new LinkedList<>();
//        users.add(user1);
//        users.add(user2);
//        users.add(user3);
//
//        CsvService csvService = new CsvService();
//        csvService.write(users);




        CsvService csvService = new CsvService();
        LinkedList users = csvService.read(User.class);
        LinkedList<User> users2 = new LinkedList<>();

        for (Object obj : users) {
            User user = (User) obj;
            users2.add(user);
        }

        for(User user : users2){
            System.out.println(user.toString());
        }

    }


}

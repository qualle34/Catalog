package com.senla.catalog.service;

import com.senla.catalog.daoapi.IUserDao;
import com.senla.catalog.entity.User;
import com.senla.catalog.service.basic.AbstractService;
import com.senla.catalog.serviceapi.IUserService;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserService extends AbstractService<User, Integer> implements IUserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private Session session;

    @Autowired
    private IUserDao userDao;

    @Override
    protected Class getChildClass() {
        return UserService.class;
    }

    @Override
    protected String getDaoClassName() {
        return "userDao";
    }

    @Override
    protected Class<User> getEntityClass() {
        return User.class;
    }

    @Override
    public List<User> getByName(String name) {

        try {
            return userDao.getByName(name);

        } catch (RuntimeException e) {
            logger.error("Get user by name error: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public User getFullUserById(int id) {

        try {
            return userDao.getFullUserById(id);

        } catch (RuntimeException e) {
            logger.error("Get full user by id error: " + e.getMessage());
            throw e;
        }
    }

    // TODO: 25.09.2019
    @Override
    public String ObjectToJson(User user) {

        StringBuilder sb = new StringBuilder();
        sb.append("{")
                .append("\"id\":").append(user.getId()).append(", ")
                .append("\"firstname\":\"").append(user.getFirstname()).append("\", ")
                .append("\"lastname\":\"").append(user.getLastname()).append("\", ")
                .append("\"birthdate\":\"").append(user.getBirthdate().toString()).append("\", ")
                .append("\"phone\":\"").append(user.getPhone()).append("\", ")
                .append("\"location\":\"").append(user.getLocation()).append("\" ")
                .append("}");

        return sb.toString();
    }

    @Override
    public String ObjectListToJson(List<User> userList) {

        StringBuilder sb = new StringBuilder();
        sb.append("{");

        for (User user : userList) {
            sb.append(ObjectToJson(user));
        }
        sb.append("}");

        return sb.toString();
    }

    @Override
    public User JsonToObject(String json) {
        String[] data = json.split(",");

        User user = new User();
        user.setId(Integer.parseInt(data[0].substring(data[0].indexOf(":") + 1)));
        user.setFirstname(data[1].substring(data[1].indexOf("\""), data[1].lastIndexOf("\"")));
        user.setLastname(data[2].substring(data[2].indexOf(":") + 1));
        user.setBirthdate(new Date());
        user.setPhone(data[3].substring(data[3].indexOf(":") + 1));
        user.setLocation(data[4].substring(data[4].indexOf(":") + 1));

        return user;
    }

    @Override
    public List<User> JsonToObjectList(String user) {
        return null;
    }


}

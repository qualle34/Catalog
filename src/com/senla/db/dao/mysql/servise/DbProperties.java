package com.senla.db.dao.mysql.servise;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

class DbProperties {

    private String driver;
    private String url;
    private String username;
    private String password;
    private String parameters;

    DbProperties() {
        getProperties();
    }

    String getDriver() {
        return driver;
    }

    String getUrl() {
        return url;
    }

    String getUsername() {
        return username;
    }

    String getPassword() {
        return password;
    }

    String getParameters() {
        return parameters;
    }

    private void getProperties() {
        Properties properties = new Properties();

        try (InputStream inputStream = new FileInputStream("data\\db.properties")) {

            properties.load(inputStream);

        } catch (IOException io) {
            io.printStackTrace();
        }

        driver = properties.getProperty("jdbc.driver");
        url = properties.getProperty("jdbc.url");
        username = properties.getProperty("jdbc.username");
        password = properties.getProperty("jdbc.password");
        parameters = properties.getProperty("jdbc.parameters");
    }
}

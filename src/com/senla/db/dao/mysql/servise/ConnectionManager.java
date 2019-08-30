package com.senla.db.dao.mysql.servise;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

class ConnectionManager {

    private static final Logger LOG =  Logger.getLogger(ConnectionManager.class.getName());
    private Connection connection;

    ConnectionManager() {
        DbProperties prop = new DbProperties();
        String url = prop.getUrl() + prop.getParameters();

        try {
            Class.forName(prop.getDriver()).newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            LOG.log(Level.WARNING, "Driver error: " + e.getMessage());
        }

        try {
            connection = DriverManager.getConnection(url, prop.getUsername(), prop.getPassword());
        } catch (SQLException e) {
            LOG.log(Level.WARNING, "Connection error: " + e.getMessage());
        }
    }

    Connection getConnection() {
        return connection;
    }

    void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
               LOG.log(Level.WARNING, "Close connection error: " + e.getMessage());
            }
        }
    }
}

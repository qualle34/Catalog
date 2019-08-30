package com.senla.db.mysql.manager;

import java.sql.*;

public class MySqlDaoManager {

    private static ConnectionManager connector = new ConnectionManager();
    private static Connection connection = connector.getConnection();
    private static boolean IS_AVILABLE = true;

    public static Connection getConnection() {
        IS_AVILABLE = false;
        return connection;
    }

    public static void returnConnection() {
        IS_AVILABLE = true;
    }

    public static void close() {
        connector.closeConnection();
    }
}

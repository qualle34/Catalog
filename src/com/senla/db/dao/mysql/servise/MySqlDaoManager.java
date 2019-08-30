package com.senla.db.dao.mysql.servise;

import com.senla.db.dao.IDaoManager;

import java.sql.*;
import java.util.List;

public abstract class MySqlDaoManager implements IDaoManager {

    private Connection connection;
    private ConnectionManager connector;

    public MySqlDaoManager() {
        connector = new ConnectionManager();
        connection = connector.getConnection();
    }

    protected abstract String getSelectAllQuery();

    protected abstract String getInsertQuery(Object object);

    protected abstract String getSelectQuery();

    protected abstract String getUpdateQuery(Object object);

    protected abstract String getDeleteQuery();

    protected abstract List<Object> resultListParser(ResultSet rs) throws SQLException;

    protected abstract Object resultParser(ResultSet rs) throws SQLException;

    @Override
    public List<Object> getAll() {
        List<Object> objectList = null;
        String query = getSelectAllQuery();

        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            objectList = resultListParser(resultSet);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return objectList;
    }

    @Override
    public boolean add(Object object) {
        String query = getInsertQuery(object);
        boolean result;

        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(query);
            result = true;

        } catch (SQLException e) {
            result = false;
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Object get(String pk) {
        String query = getSelectQuery();
        Object object = null;

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, pk);
            ResultSet resultSet = preparedStatement.executeQuery();
            object = resultParser(resultSet);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return object;
    }

    @Override
    public boolean update(Object object) {
        String query = getUpdateQuery(object);
        boolean result;

        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(query);
            result = true;

        } catch (SQLException e) {
            result = false;
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean delete(String pk) {
        String query = getDeleteQuery();
        boolean result;

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, pk);
            preparedStatement.executeUpdate();
            result = true;

        } catch (SQLException e) {
            result = false;
            e.printStackTrace();
        }
        return result;
    }

    public void close(){
        connector.closeConnection();
    }
}

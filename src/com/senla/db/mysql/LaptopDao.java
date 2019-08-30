package com.senla.db.mysql;

import com.senla.db.dao.ILaptopDao;
import com.senla.db.entity.Laptop;
import com.senla.db.mysql.manager.MySqlDaoManager;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class LaptopDao implements ILaptopDao {

    private Connection connection;

    public LaptopDao() {
        connection = MySqlDaoManager.getConnection();
    }

    @Override
    public List<Laptop> getAll() {
        List<Laptop> laptopList = new LinkedList<>();
        String query = "SELECT * FROM laptop;";

        try (Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {
                Laptop laptop = new Laptop(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getDouble(6), rs.getFloat(7));
                laptopList.add(laptop);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return laptopList;
    }

    @Override
    public boolean add(Laptop laptop) {
        String query = "INSERT INTO laptop VALUES(?, ?, ?, ?, ? ,? ,?);";
        boolean result;

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, laptop.getCode());
            statement.setString(2, laptop.getModel());
            statement.setInt(3, laptop.getSpeed());
            statement.setInt(4, laptop.getRam());
            statement.setInt(5, laptop.getHd());
            statement.setDouble(6, laptop.getPrice());
            statement.setFloat(7, laptop.getScreen());
            statement.executeUpdate();
            result = true;

        } catch (SQLException e) {
            result = false;
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Laptop get(String pk) {
        String query = "SELECT * FROM laptop WHERE model = ?;";
        Laptop laptop = null;

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, pk);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                laptop = new Laptop(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getDouble(6), rs.getFloat(7));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return laptop;
    }

    @Override
    public boolean update(Laptop laptop) {
        String query = "UPDATE laptop SET code = ?, speed = ?, ram = ?, hd = ?, price = ?, screen = ? WHERE model = ?;";
        boolean result;

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, laptop.getCode());
            statement.setInt(2, laptop.getSpeed());
            statement.setInt(3, laptop.getRam());
            statement.setInt(4, laptop.getHd());
            statement.setDouble(5, laptop.getPrice());
            statement.setFloat(6, laptop.getScreen());
            statement.setString(7, laptop.getModel());
            statement.executeUpdate();
            result = true;

        } catch (SQLException e) {
            result = false;
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean delete(String pk) {
        String query = "DELETE FROM laptop WHERE model = ?;";
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
}

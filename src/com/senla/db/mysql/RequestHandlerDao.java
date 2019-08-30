package com.senla.db.mysql;

import com.senla.db.dao.IRequestHandlerDao;
import com.senla.db.entity.Pc;
import com.senla.db.entity.Product;
import com.senla.db.mysql.manager.MySqlDaoManager;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class RequestHandlerDao implements IRequestHandlerDao {

    private Connection connection;

    public RequestHandlerDao() {
        connection = MySqlDaoManager.getConnection();
    }

    @Override
    public List<Pc> getPcByPriceLowerThan(float price) {
        List<Pc> pcList = new LinkedList<>();
        String query = "SELECT * FROM pc WHERE price < ?;";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setDouble(1, price);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Pc pc = new Pc(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getString(6), rs.getDouble(7));
                pcList.add(pc);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pcList;
    }

    @Override
    public List<Product> getProductBySpeedAboveThan(int speed) {
        List<Product> productList = new LinkedList<>();
        String query = "\n" +
                "SELECT product.maker, product.model, product.type FROM mystore.product JOIN mystore.pc USING(model) " +
                "WHERE speed >= ? AND maker IN (SELECT maker FROM mystore.product JOIN mystore.laptop USING(model) WHERE speed >= ?);";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, speed);
            statement.setInt(2, speed);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Product product = new Product(rs.getString(1), rs.getString(2), rs.getString(3));
                productList.add(product);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }

    @Override
    public List<Product> getPrinterMakers() {
        List<Product> productList = new LinkedList<>();
        String query = "SELECT * FROM mystore.product WHERE type LIKE 'Printer'";

        try (Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                Product product = new Product(rs.getString(1), rs.getString(2), rs.getString(3));
                productList.add(product);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }
}

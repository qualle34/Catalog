package com.senla.db.mysql;

import com.senla.db.dao.IProductDao;
import com.senla.db.entity.Product;
import com.senla.db.mysql.manager.MySqlDaoManager;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class ProductDao extends MySqlDaoManager implements IProductDao {

    private Connection connection;

    public ProductDao() {
        connection = MySqlDaoManager.getConnection();
    }

    @Override
    public List<Product> getAll() {
        List<Product> productList = new LinkedList<>();
        String query = "SELECT * FROM product;";

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

    @Override
    public boolean add(Product product) {
        String query = "INSERT INTO product VALUES(?, ?, ?);";
        boolean result;

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, product.getMaker());
            statement.setString(2, product.getModel());
            statement.setString(3, product.getType());
            statement.executeUpdate();
            result = true;

        } catch (SQLException e) {
            result = false;
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Product get(String pk) {
        String query = "SELECT * FROM product WHERE model = ?;";
        Product product = null;

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, pk);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                product = new Product(rs.getString(1), rs.getString(2), rs.getString(3));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public boolean update(Product product) {
        String query = "UPDATE product SET maker = ?, type = ? WHERE model = ?";
        boolean result;

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, product.getMaker());
            statement.setString(2, product.getType());
            statement.setString(3, product.getModel());
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
        String query = "DELETE FROM product WHERE model = ?;";
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

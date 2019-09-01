package com.senla.db.dao.mysqldao;

import com.senla.db.dao.IRequestHandlerDao;
import com.senla.db.entity.Pc;
import com.senla.db.entity.Product;
import com.senla.db.dao.mysqldao.manager.ConnectionManager;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class RequestHandlerDao implements IRequestHandlerDao {

    private static final Logger LOG = Logger.getLogger(ConnectionManager.class.getName());
    private Connection connection;

    public RequestHandlerDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Pc> getPcByPriceLowerThan(double price) {
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
            LOG.log(Level.WARNING, "Error in method (getPcByPriceLowerThan()): " + e.getMessage());
        }
        return pcList;
    }

    @Override
    public List<Product> getProductBySpeedAboveThan(int speed) {
        List<Product> productList = new LinkedList<>();
        String query = "SELECT product.maker, product.model, product.type FROM product JOIN pc USING(model) " +
                "WHERE speed >= ? AND maker IN (SELECT maker FROM product JOIN laptop USING(model) WHERE speed >= ?);";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, speed);
            statement.setInt(2, speed);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Product product = new Product(rs.getString(1), rs.getString(2), rs.getString(3));
                productList.add(product);
            }

        } catch (SQLException e) {
            LOG.log(Level.WARNING, "Error in method (getProductBySpeedAboveThan()): " + e.getMessage());
        }
        return productList;
    }

    @Override
    public List<Product> getPrinterMakers() {
        List<Product> productList = new LinkedList<>();
        String query = "SELECT * FROM product WHERE type LIKE 'Printer'";

        try (Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                Product product = new Product(rs.getString(1), rs.getString(2), rs.getString(3));
                productList.add(product);
            }

        } catch (SQLException e) {
            LOG.log(Level.WARNING, "Error in method (getPrinterMakers()): " + e.getMessage());
        }
        return productList;
    }

    @Override
    public Map<Integer, List<Pc>> getPcPriceGroupBySpeed() {
        Map<Integer, List<Pc>> groupedPc = null;
        List<Pc> pcList = new LinkedList<>();
        String query = "SELECT * FROM pc;";

        try (Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                Pc pc = new Pc(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getString(6), rs.getDouble(7));
                pcList.add(pc);
            }

            groupedPc = pcList.stream().collect(Collectors.groupingBy(Pc::getSpeed));

        } catch (SQLException e) {
            LOG.log(Level.WARNING, "Error in method (getPrinterMakers()): " + e.getMessage());
        }
        return groupedPc;
    }

    @Override
    public void transaction() {
        Statement statement = null;
        Savepoint savepoint = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.createStatement();

            statement.executeUpdate("INSERT INTO product VALUES('ASUS', 'ZEFIRUS', 'Pc');");
            savepoint = connection.setSavepoint();
            statement.executeUpdate("UPDATE product SET maker = 'ASUS', type = 'Laptop' WHERE model = 'ZEFIRUS'");

            connection.commit();
            connection.releaseSavepoint(savepoint);

        } catch (SQLException e) {
            try {
                connection.rollback(savepoint);
            } catch (SQLException rollError) {
                LOG.log(Level.WARNING, "Error in method (transaction()): " + rollError.getMessage());
            }
            LOG.log(Level.WARNING, "Error in method (transaction()): " + e.getMessage());
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                connection.setAutoCommit(true);
            } catch (SQLException e) {
                LOG.log(Level.WARNING, "Error in method (transaction()): " + e.getMessage());
            }
        }
    }
}
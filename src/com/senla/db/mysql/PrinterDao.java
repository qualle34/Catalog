package com.senla.db.mysql;

import com.senla.db.dao.IPrinterDao;
import com.senla.db.entity.Printer;
import com.senla.db.mysql.manager.MySqlDaoManager;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class PrinterDao implements IPrinterDao {

    private Connection connection;

    public PrinterDao() {
        connection = MySqlDaoManager.getConnection();
    }

    @Override
    public List<Printer> getAll() {
        List<Printer> printerList = new LinkedList<>();
        String query = "SELECT * FROM printer;";

        try (Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {
                Printer printer = new Printer(rs.getInt(1), rs.getString(2), rs.getString(3).charAt(0), rs.getString(4), rs.getDouble(5));
                printerList.add(printer);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return printerList;
    }

    @Override
    public boolean add(Printer printer) {
        String query = "INSERT INTO printer VALUES(?, ?, ?, ?, ?);";
        boolean result;

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, printer.getCode());
            statement.setString(2, printer.getModel());
            statement.setString(3, String.valueOf(printer.getColor()));
            statement.setString(4, printer.getType());
            statement.setDouble(5, printer.getPrice());
            statement.executeUpdate();
            result = true;

        } catch (SQLException e) {
            result = false;
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Printer get(String pk) {
        String query = "SELECT * FROM printer WHERE model = ?;";
        Printer printer = null;

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, pk);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                printer = new Printer(rs.getInt(1), rs.getString(2), rs.getString(3).charAt(0), rs.getString(4), rs.getDouble(5));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return printer;
    }

    @Override
    public boolean update(Printer printer) {
        String query = "UPDATE printer SET code = ?, color = ?, type = ?, price = ? WHERE model = ?;";
        boolean result;

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, printer.getCode());
            statement.setString(2, String.valueOf(printer.getColor()));
            statement.setString(3, printer.getType());
            statement.setDouble(4, printer.getPrice());
            statement.setString(5, printer.getModel());
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
        String query = "DELETE FROM printer WHERE model = ?;";
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

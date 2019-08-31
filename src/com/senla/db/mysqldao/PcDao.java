package com.senla.db.mysqldao;

import com.senla.db.dao.IPcDao;
import com.senla.db.entity.Pc;
import com.senla.db.mysqldao.manager.ConnectionManager;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PcDao implements IPcDao {

    private static final Logger LOG =  Logger.getLogger(ConnectionManager.class.getName());
    private Connection connection;

    public PcDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Pc> getAll() {
        List<Pc> pcList = new LinkedList<>();
        String query = "SELECT * FROM pc;";

        try (Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {
                Pc pc = new Pc(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getString(6), rs.getDouble(7));
                pcList.add(pc);
            }

        } catch (SQLException e) {
            LOG.log(Level.WARNING, "GetAll error: " + e.getMessage());
        }
        return pcList;
    }

    @Override
    public boolean add(Pc pc) {
        String query = "INSERT INTO pc VALUES(?, ?, ?, ?, ? ,? ,?);";
        boolean result;

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, pc.getCode());
            statement.setString(2, pc.getModel());
            statement.setInt(3, pc.getSpeed());
            statement.setInt(4, pc.getRam());
            statement.setInt(5, pc.getHd());
            statement.setString(6, pc.getCd());
            statement.setDouble(7, pc.getPrice());
            statement.executeUpdate();
            result = true;

        } catch (SQLException e) {
            result = false;
            LOG.log(Level.WARNING, "Add error: " + e.getMessage());
        }
        return result;
    }

    @Override
    public Pc get(String pk) {
        String query = "SELECT * FROM pc WHERE model = ?;";
        Pc pc = null;

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, pk);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                pc = new Pc(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getString(6), rs.getDouble(7));
            }

        } catch (SQLException e) {
            LOG.log(Level.WARNING, "Get error: " + e.getMessage());
        }
        return pc;
    }

    @Override
    public boolean update(Pc pc) {
        String query = "UPDATE pc SET code = ?, speed = ?, ram = ?, hd = ?, cd = ?, price = ? WHERE model = ?;";
        boolean result;

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, pc.getCode());
            statement.setInt(2, pc.getSpeed());
            statement.setInt(3, pc.getRam());
            statement.setInt(4, pc.getHd());
            statement.setString(5, pc.getCd());
            statement.setDouble(6, pc.getPrice());
            statement.setString(7, pc.getModel());
            statement.executeUpdate();
            result = true;

        } catch (SQLException e) {
            result = false;
            LOG.log(Level.WARNING, "Update error: " + e.getMessage());
        }
        return result;
    }

    @Override
    public boolean delete(String pk) {
        String query = "DELETE FROM pc WHERE model = ?;";
        boolean result;

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, pk);
            preparedStatement.executeUpdate();
            result = true;

        } catch (SQLException e) {
            result = false;
            LOG.log(Level.WARNING, "Delete error: " + e.getMessage());
        }
        return result;
    }
}
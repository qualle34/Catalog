package com.senla.db.dao.mysql;

import com.senla.db.dao.mysql.servise.MySqlDaoManager;
import com.senla.db.entity.Product;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class ProductManager extends MySqlDaoManager {

    @Override
    protected String getSelectAllQuery() {
        return "SELECT * FROM product;";
    }

    @Override
    protected String getInsertQuery(Object object) {
        Product product = (Product) object;
        return "INSERT INTO product VALUES('" + product.getMaker() + "', '" + product.getModel() + "', '" + product.getType() + "');";
    }

    @Override
    protected String getSelectQuery() {
        return "SELECT * FROM product WHERE model = ?;";
    }

    @Override
    protected String getUpdateQuery(Object object) {
        Product product = (Product) object;
        return "UPDATE product SET maker = '" + product.getMaker() + "', type = '" + product.getType() + "' WHERE model = '" + product.getModel() + "' ";
    }

    @Override
    protected String getDeleteQuery() {
        return "DELETE FROM product WHERE model = ?;";
    }

    @Override
    protected List<Object> resultListParser(ResultSet rs) throws SQLException {
        LinkedList<Object> productList = new LinkedList<>();

        while (rs.next()) {
            Product product = new Product(rs.getString(1), rs.getString(2), rs.getString(3));
            productList.add(product);
        }
        return productList;
    }

    @Override
    protected Object resultParser(ResultSet rs) throws SQLException {

        if (rs.next()) {
            return new Product(rs.getString(1), rs.getString(2), rs.getString(3));
        } else {
            return null;
        }
    }

    public void close(){
        super.close();
    }
}

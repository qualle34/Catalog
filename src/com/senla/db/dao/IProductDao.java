package com.senla.db.dao;

import com.senla.db.entity.Product;

import java.util.List;

public interface IProductDao {

    List<Product> getAll();

    boolean add(Product product);

    Product get(String pk);

    boolean update(Product product);

    boolean delete(String pk);
}

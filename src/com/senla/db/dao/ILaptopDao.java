package com.senla.db.dao;

import com.senla.db.entity.Laptop;

import java.util.List;

public interface ILaptopDao {

    List<Laptop> getAll();

    boolean add(Laptop laptop);

    Laptop get(String pk);

    boolean update(Laptop laptop);

    boolean delete(String pk);
}

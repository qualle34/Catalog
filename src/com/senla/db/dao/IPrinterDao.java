package com.senla.db.dao;

import com.senla.db.entity.Printer;

import java.util.List;

public interface IPrinterDao {

    List<Printer> getAll();

    boolean add(Printer printer);

    Printer get(String pk);

    boolean update(Printer printer);

    boolean delete(String pk);
}

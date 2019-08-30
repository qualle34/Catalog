package com.senla.db.dao;

import com.senla.db.entity.Pc;

import java.util.List;

public interface IPcDao {

    List<Pc> getAll();

    boolean add(Pc pc);

    Pc get(String pk);

    boolean update(Pc pc);

    boolean delete(String pk);
}

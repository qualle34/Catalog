package com.senla.catalog.daoapi;

import com.senla.catalog.entity.SalesHistory;

import java.util.List;

public interface ISalesHistoryDao extends IGenericDao<SalesHistory, Integer> {

    @Override
    List<SalesHistory> getAll();

    @Override
    void add(SalesHistory salesHistory);

    @Override
    SalesHistory get(Integer integer);

    @Override
    void update(SalesHistory salesHistory);

    @Override
    void delete(SalesHistory salesHistory);
}

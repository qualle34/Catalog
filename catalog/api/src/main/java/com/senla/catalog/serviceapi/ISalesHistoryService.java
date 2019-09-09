package com.senla.catalog.serviceapi;


import com.senla.catalog.entity.SalesHistory;

import java.util.List;

public interface ISalesHistoryService {

    List<SalesHistory> getAll();

    void add(SalesHistory salesHistory);

    SalesHistory getById(Integer id);

    void update(SalesHistory salesHistory);

    void delete(SalesHistory salesHistory);

}

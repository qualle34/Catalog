package com.senla.catalog.daoapi;

import com.senla.catalog.daoapi.basic.IGenericDao;
import com.senla.catalog.entity.Deal;
import com.senla.catalog.entity.User;

import java.util.List;

public interface IDealDao extends IGenericDao<Deal, Integer> {

    List<Deal> getDealListBySeller(User seller);

    List<Deal> getDealListByBuyer(User buyer);
}

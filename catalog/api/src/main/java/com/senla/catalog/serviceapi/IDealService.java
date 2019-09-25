package com.senla.catalog.serviceapi;

import com.senla.catalog.entity.Deal;
import com.senla.catalog.entity.User;
import com.senla.catalog.serviceapi.basic.IGenericService;

import java.util.List;

public interface IDealService extends IGenericService<Deal, Integer> {

    List<Deal> getDealListBySeller(User seller);

    List<Deal> getDealListByBuyer(User buyer);
}

package com.senla.catalog.daoapi;

import com.senla.catalog.daoapi.basic.IGenericDao;
import com.senla.catalog.entity.Deal;

import java.util.List;

public interface IDealDao extends IGenericDao<Deal, Long> {

    List<Deal> getBySeller(long sellerId);

    List<Deal> getByBuyer(long buyerId);
}

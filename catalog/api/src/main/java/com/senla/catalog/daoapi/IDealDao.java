package com.senla.catalog.daoapi;

import com.senla.catalog.daoapi.basic.IGenericDao;
import com.senla.catalog.entity.Deal;

import java.util.List;

public interface IDealDao extends IGenericDao<Deal, Long> {

    List<Deal> getBySellerId(long sellerId);

    List<Deal> getByBuyerId(long buyerId);

    void delete(long id);
}

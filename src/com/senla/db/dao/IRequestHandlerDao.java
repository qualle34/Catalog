package com.senla.db.dao;

import com.senla.db.entity.Pc;
import com.senla.db.entity.Product;

import java.util.List;
import java.util.Map;

public interface IRequestHandlerDao {

    List<Pc> getPcByPriceLowerThan(double price);

    List<Product> getProductBySpeedAboveThan(int speed);

    List<Product> getPrinterMakers();

    Map<Integer, List<Pc>> getPcPriceGroupBySpeed();

    void transaction();
}
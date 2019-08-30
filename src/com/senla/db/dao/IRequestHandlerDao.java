package com.senla.db.dao;

import com.senla.db.entity.Pc;
import com.senla.db.entity.Product;

import java.util.List;

public interface IRequestHandlerDao {

    List<Pc> getPcByPriceLowerThan(float price);

    List<Product> getProductBySpeedAboveThan(int speed);

    List<Product> getPrinterMakers();
}
package com.senla.db.service;

import com.senla.db.dao.*;
import com.senla.db.entity.Laptop;
import com.senla.db.entity.Pc;
import com.senla.db.entity.Printer;
import com.senla.db.entity.Product;
import com.senla.db.dao.mysqldao.*;
import com.senla.db.dao.mysqldao.manager.ConnectionManager;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

public class Service {

    private ConnectionManager connectionManager;

    private IProductDao productDao;
    private ILaptopDao laptopDao;
    private IPcDao pcDao;
    private IPrinterDao printerDao;
    private IRequestHandlerDao requestHandlerDao;

    public Service() {
        connectionManager = new ConnectionManager();
        Connection connection = connectionManager.getConnection();

        productDao = new ProductDao(connection);
        laptopDao = new LaptopDao(connection);
        pcDao = new PcDao(connection);
        printerDao = new PrinterDao(connection);
        requestHandlerDao = new RequestHandlerDao(connection);
    }

    public void printPcByPriceLowerThan(double price) {
        List<Pc> pcList = requestHandlerDao.getPcByPriceLowerThan(price);

        for (Pc pc : pcList) {
            System.out.println(pc.toString());
        }
    }

    public void printMakerBySpeedAboveThan(int speed) {
        List<Product> productList = requestHandlerDao.getProductBySpeedAboveThan(speed);

        for (Product product : productList) {
            System.out.println(product.getMaker());
        }
    }

    public void printPcGroupBySpeed() {
        Map<Integer, List<Pc>> groupBySpeed = requestHandlerDao.getPcPriceGroupBySpeed();

        for (Map.Entry<Integer, List<Pc>> entry : groupBySpeed.entrySet()) {
            double avgPrice = 0;

            for (Pc pc : entry.getValue()) {
                avgPrice += pc.getPrice();
            }
            avgPrice = avgPrice / (entry.getValue().size());
            System.out.println(entry.getKey() + " " + avgPrice);
        }
    }

    public void printPrinterMakers() {
        List<Product> prodPrinterList = requestHandlerDao.getPrinterMakers();

        for (Product product : prodPrinterList) {
            System.out.println(product.getMaker());
        }
    }


    public void getTransaction() {
        requestHandlerDao.transaction();
    }


    public void printAllFromProduct() {
        List<Product> productList = productDao.getAll();

        for (Product product : productList) {
            System.out.println(product.toString());
        }
    }

    public void printAllFromLaptop() {
        List<Laptop> laptopList = laptopDao.getAll();

        for (Laptop laptop : laptopList) {
            System.out.println(laptop.toString());
        }
    }

    public void printAllFromPc() {
        List<Pc> pcList = pcDao.getAll();

        for (Pc pc : pcList) {
            System.out.println(pc.toString());
        }
    }

    public void printAllFromPrinter() {
        List<Printer> printerList = printerDao.getAll();

        for (Printer printer : printerList) {
            System.out.println(printer.toString());
        }
    }


    public void addProduct(Product product) {
        productDao.add(product);
    }

    public void addLaptop(Laptop laptop) {
        laptopDao.add(laptop);
    }

    public void addPc(Pc pc) {
        pcDao.add(pc);
    }

    public void addPrinter(Printer printer) {
        printerDao.add(printer);
    }


    public void printProduct(String pk) {
        Product product = productDao.get(pk);
        System.out.println(product.toString());
    }

    public void printLaptop(String pk) {
        Laptop laptop = laptopDao.get(pk);
        System.out.println(laptop.toString());
    }

    public void printPc(String pk) {
        Pc pc = pcDao.get(pk);
        System.out.println(pc.toString());
    }

    public void printPrinter(String pk) {
        Printer printer = printerDao.get(pk);
        System.out.println(printer.toString());
    }


    public void updateProduct(Product product) {
        productDao.update(product);
    }

    public void updateLaptop(Laptop laptop) {
        laptopDao.update(laptop);
    }

    public void updatePc(Pc pc) {
        pcDao.update(pc);
    }

    public void updatePrinter(Printer printer) {
        printerDao.update(printer);
    }


    public void deleteProduct(String pk) {
        productDao.delete(pk);
    }

    public void deleteLaptop(String pk) {
        laptopDao.delete(pk);
    }

    public void deletePc(String pk) {
        pcDao.delete(pk);
    }

    public void deletePrinter(String pk) {
        printerDao.delete(pk);
    }


    public void close() {
        connectionManager.closeConnection();
    }
}

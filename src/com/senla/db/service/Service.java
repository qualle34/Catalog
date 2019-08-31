package com.senla.db.service;

import com.senla.db.dao.*;
import com.senla.db.entity.Laptop;
import com.senla.db.entity.Pc;
import com.senla.db.entity.Printer;
import com.senla.db.entity.Product;
import com.senla.db.mysqldao.*;
import com.senla.db.mysqldao.manager.ConnectionManager;

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

    public void printMakerBySpeedAboveThan() {
        List<Product> productList = requestHandlerDao.getProductBySpeedAboveThan(750);
        for (Product product : productList) {
            System.out.println(product.getMaker());
        }
    }

    public void printPcByPriceLowerThan() {
        List<Pc> pcList = requestHandlerDao.getPcByPriceLowerThan(500);
        for (Pc pc : pcList) {
            System.out.println(pc.toString());
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

    public void getAll() {
        List<Product> productList = productDao.getAll();
        System.out.println(productList.toString());

        List<Laptop> laptopList = laptopDao.getAll();
        System.out.println(laptopList.toString());

        List<Pc> pcList = pcDao.getAll();
        System.out.println(pcList.toString());

        List<Printer> printerList = printerDao.getAll();
        System.out.println(printerList.toString());
    }

    public void add() {
        Product product1 = new Product("Test", "T-1", "Laptop");
        Product product2 = new Product("Test", "T-2", "Pc");
        Product product3 = new Product("Test", "T-3", "Printer");
        productDao.add(product1);
        productDao.add(product2);
        productDao.add(product3);

        Laptop laptop = new Laptop(8, "T-1", 1, 1, 1, 1.0D, 14.3F);
        laptopDao.add(laptop);

        Pc pc = new Pc(12, "T-2", 1, 1, 1, "12x", 1.0D);
        pcDao.add(pc);

        Printer printer = new Printer(8, "T-3", 'y', "Jet", 1.0D);
        printerDao.add(printer);
    }

    public void getByPk() {
        Product product = productDao.get("T-1");
        System.out.println(product.toString());

        Laptop laptop = laptopDao.get("T-1");
        System.out.println(laptop.toString());

        Pc pc = pcDao.get("T-2");
        System.out.println(pc.toString());

        Printer printer = printerDao.get("T-3");
        System.out.println(printer.toString());
    }

    public void update() {
        Product product = new Product("Teste", "T-1", "Laptop");
        productDao.update(product);

        Laptop laptop = new Laptop(8, "T-1", 2, 1, 1, 1.0D, 14.3F);
        laptopDao.update(laptop);

        Pc pc = new Pc(12, "T-2", 2, 1, 1, "12x", 1.0D);
        pcDao.update(pc);

        Printer printer = new Printer(8, "T-3", 'n', "Jet", 1.0D);
        printerDao.update(printer);
    }

    public void delete() {
        laptopDao.delete("T-1");
        pcDao.delete("T-2");
        printerDao.delete("T-3");
        productDao.delete("T-1");
        productDao.delete("T-2");
        productDao.delete("T-3");
    }

    public void close() {
        connectionManager.closeConnection();
    }
}

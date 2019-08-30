package com.senla.db.service;

import com.senla.db.dao.*;
import com.senla.db.entity.Laptop;
import com.senla.db.entity.Pc;
import com.senla.db.entity.Printer;
import com.senla.db.entity.Product;
import com.senla.db.mysql.*;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        IProductDao productDao = new ProductDao();
        ILaptopDao laptopDao = new LaptopDao();
        IPcDao pcDao = new PcDao();
        IPrinterDao printerDao = new PrinterDao();

        IRequestHandlerDao requestHandlerDao = new RequestHandlerDao();



//        List<Pc> pcList = requestHandlerDao.getPcByPriceLowerThan(500);
//        System.out.println(pcList.toString());
//
//        List<Product> productList = requestHandlerDao.getProductBySpeedAboveThan(750);
//        System.out.println(productList.toString());

//        List<Product> prodPrinterList = requestHandlerDao.getPrinterMakers();
//        System.out.println(prodPrinterList.toString());



//        List<Product> productList = productDao.getAll();
//        System.out.println(productList.toString());
//
//        List<Laptop> laptopList = laptopDao.getAll();
//        System.out.println(laptopList.toString());
//
//        List<Pc> pcList = pcDao.getAll();
//        System.out.println(pcList.toString());
//
//        List<Printer> printerList = printerDao.getAll();
//        System.out.println(printerList.toString());



//        Product product1 = new Product("Test", "T-1", "Laptop");
//        Product product2 = new Product("Test", "T-2", "Pc");
//        Product product3 = new Product("Test", "T-3", "Printer");
//        productDao.add(product1);
//        productDao.add(product2);
//        productDao.add(product3);
//
//        Laptop laptop = new Laptop(8, "T-1", 1, 1, 1, 1.0D, 14.3F);
//        laptopDao.add(laptop);
//
//        Pc pc = new Pc(12, "T-2", 1, 1, 1, "12x", 1.0D);
//        pcDao.add(pc);
//
//        Printer printer = new Printer(8, "T-3", 'y', "Jet", 1.0D);
//        printerDao.add(printer);



//        Product product = productDao.get("T-1");
//        System.out.println(product.toString());
//
//        Laptop laptop = laptopDao.get("T-1");
//        System.out.println(laptop.toString());
//
//        Pc pc = pcDao.get("T-2");
//        System.out.println(pc.toString());
//
//        Printer printer = printerDao.get("T-3");
//        System.out.println(printer.toString());



//        Product product = new Product("Teste", "T-1", "Laptop");
//        productDao.update(product);
//
//        Laptop laptop = new Laptop(8, "T-1", 2, 1, 1, 1.0D, 14.3F);
//        laptopDao.update(laptop);
//
//        Pc pc = new Pc(12, "T-2", 2, 1, 1, "12x", 1.0D);
//        pcDao.update(pc);
//
//        Printer printer = new Printer(8, "T-3", 'n', "Jet", 1.0D);
//        printerDao.update(printer);



//        laptopDao.delete("T-1");
//        pcDao.delete("T-2");
//        printerDao.delete("T-3");
//        productDao.delete("T-1");
//        productDao.delete("T-2");
//        productDao.delete("T-3");

    }
}


package com.senla.db;

import com.senla.db.dao.IDaoManager;
import com.senla.db.dao.mysql.ProductManager;
import com.senla.db.entity.Product;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        IDaoManager productManager = new ProductManager();

        List<Object> productList = productManager.getAll();
        System.out.println(productList.toString());

//        Product product = new Product("Sony", "GR-123", "Printer");
//        productManager.add(product);

//        Product p = (Product) productManager.get("L222");
//        System.out.println(p.toString());

//        Product product = new Product("Sony", "GR-123", "Laptop");
//        productManager.update(product);

//        productManager.delete("Sony");

        ((ProductManager) productManager).close();
    }
}

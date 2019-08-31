package com.senla.db;

import com.senla.db.service.Service;

public class Main {

    public static void main(String[] args) {

        // for test
        Service service = new Service();

        service.printPcByPriceLowerThan();  // #1 query
        service.printMakerBySpeedAboveThan(); // #2 query
        service.printPcGroupBySpeed(); // #3 query
        service.printPrinterMakers(); // #4 query

        service.getTransaction();

        service.getAll();
        service.add();
        service.getByPk();
        service.update();
        service.delete();

        service.close();
    }
}
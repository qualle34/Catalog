package com.senla.db;

import com.senla.db.service.Service;

public class Main {

    public static void main(String[] args) {

        Service service = new Service();

        service.getAllRequests();

        service.getAll();
        service.add();
        service.getByPk();
        service.update();
        service.delete();

        service.close();
    }
}
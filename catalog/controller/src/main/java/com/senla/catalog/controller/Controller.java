package com.senla.catalog.controller;

import com.senla.catalog.service.CatService;
import com.senla.catalog.serviceapi.ICatService;

public class Controller {

    public static void main(String[] args) {
        ICatService catService = new CatService();
        catService.printCat(1);
    }
}

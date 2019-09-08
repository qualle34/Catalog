package com.senla.catalog.controller;

import com.senla.catalog.service.CategoryService;
import com.senla.catalog.service.UserService;
import com.senla.catalog.serviceapi.ICategoryService;
import com.senla.catalog.serviceapi.IUserService;

public class Controller {


    public static void main(String...args) {

        IUserService userService = new UserService();
        ICategoryService categoryService = new CategoryService();

        System.out.println(categoryService.get(3).toString());
        System.out.println(userService.get(1).getCreds().toString());
    }
}

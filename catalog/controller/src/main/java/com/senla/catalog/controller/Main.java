package com.senla.catalog.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext("com.senla.catalog");

        MainController controller = context.getBean(MainController.class);
        controller.start();
    }
}
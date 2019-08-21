package com.test;

import com.senla.csvhelper.CsvEntity;
import com.senla.csvhelper.CsvProperty;

@CsvEntity(filename = "dog.csv", valuesSeparator = ",")
public class Dog {

    @CsvProperty(propertyType = CsvProperty.Type.SimpleProperty, columnNumber = 1)
    private int id;

    @CsvProperty(propertyType = CsvProperty.Type.SimpleProperty, columnNumber = 2)
    private String name;

    public Dog() {
    }

    public Dog(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return id + " " + name;
    }
}

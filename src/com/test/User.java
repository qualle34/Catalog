package com.test;

import com.senla.csvhelper.CsvEntity;
import com.senla.csvhelper.CsvProperty;

@CsvEntity(filename = "user.csv", valuesSeparator = ",")
public class User {

    @CsvProperty(propertyType = CsvProperty.Type.SimpleProperty, columnNumber = 1)
    private int id;

    @CsvProperty(propertyType = CsvProperty.Type.SimpleProperty, columnNumber = 2)
    private String name;

    private String password;

    @CsvProperty(propertyType = CsvProperty.Type.CompositeProperty, columnNumber = 3, keyField = "id")
    private Dog dog;

    public User() {
    }

    public User(int id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public User(int id, String name, String password, Dog dog) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.dog = dog;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + password;
    }


}

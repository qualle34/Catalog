package test;

import com.senla.csvhelper.CsvEntity;
import com.senla.csvhelper.CsvProperty;

@CsvEntity(filename = "dog.csv", valuesSeparator = ",")
public class Dog {

    @CsvProperty(propertyType = CsvProperty.Type.SimpleProperty, columnNumber = 0)
    private int id;

    @CsvProperty(propertyType = CsvProperty.Type.SimpleProperty, columnNumber = 1)
    private String name;

    public Dog() {
    }

    public Dog(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return id + " " + name;
    }
}

package test;

import com.senla.csvhelper.CsvEntity;
import com.senla.csvhelper.CsvProperty;

@CsvEntity(directoryName = "D://data", valuesSeparator = ";")
public class Dog {

    @CsvProperty(propertyType = CsvProperty.Type.SimpleProperty, columnNumber = 0)
    private int id;

    @CsvProperty(propertyType = CsvProperty.Type.SimpleProperty, columnNumber = 1)
    private String name;

    @CsvProperty(propertyType = CsvProperty.Type.CompositeProperty, columnNumber = 2, keyField = "idf")
    private Label label;

    public Dog() {
    }

    public Dog(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Dog(int id, String name, Label label) {
        this.id = id;
        this.name = name;
        this.label = label;
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
        String line = id + " " + name;
        if (label != null) {
            line += " " + label.toString();
        }
        return line;
    }
}

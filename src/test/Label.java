package test;

import com.senla.csvhelper.annotation.CsvEntity;
import com.senla.csvhelper.annotation.CsvProperty;

@CsvEntity(directoryName = "D://data", valuesSeparator = ";")
public class Label {

    @CsvProperty(propertyType = CsvProperty.Type.SimpleProperty, columnNumber = 0)
    private int id;
    @CsvProperty(propertyType = CsvProperty.Type.SimpleProperty, columnNumber = 1)
    private String owner;

    public Label() {
    }

    public Label(int id, String owner) {
        this.id = id;
        this.owner = owner;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return id + " " + owner;
    }
}

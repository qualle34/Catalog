package test;

import com.senla.csvhelper.CsvEntity;
import com.senla.csvhelper.CsvProperty;

@CsvEntity(directoryName = "D://data", valuesSeparator = ";")
public class Label {

    @CsvProperty(propertyType = CsvProperty.Type.SimpleProperty, columnNumber = 0)
    private int idf;
    @CsvProperty(propertyType = CsvProperty.Type.SimpleProperty, columnNumber = 1)
    private String owner;

    public Label() {
    }

    public Label(int idf, String owner) {
        this.idf = idf;
        this.owner = owner;
    }

    public int getIdf() {
        return idf;
    }

    public void setIdf(int idf) {
        this.idf = idf;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return idf + " " + owner;
    }
}

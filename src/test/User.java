package test;

import com.senla.csvhelper.CsvEntity;
import com.senla.csvhelper.CsvProperty;

@CsvEntity(directoryName = "D://data", valuesSeparator = ",")
public class User {

    @CsvProperty(propertyType = CsvProperty.Type.SimpleProperty, columnNumber = 0)
    private int id;

    @CsvProperty(propertyType = CsvProperty.Type.SimpleProperty, columnNumber = 1)
    private String name;

    @CsvProperty(propertyType = CsvProperty.Type.SimpleProperty, columnNumber = 2)
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    @Override
    public String toString() {
        String line;
        if (dog != null) {
            line = id + " " + name + " " + password + " " + dog.toString();
        } else {
            line = id + " " + name + " " + password;
        }
        return line;
    }


}

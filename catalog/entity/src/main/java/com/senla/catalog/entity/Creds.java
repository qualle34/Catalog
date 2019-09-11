package com.senla.catalog.entity;

import com.senla.csvhelper.annotation.CsvEntity;
import com.senla.csvhelper.annotation.CsvProperty;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToOne;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "credentials")
@CsvEntity(directoryName = "D://data")
public class Creds {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    @CsvProperty(propertyType = CsvProperty.Type.SimpleProperty, columnNumber = 0)
    private int id;

    @Column(name = "login")
    @CsvProperty(propertyType = CsvProperty.Type.SimpleProperty, columnNumber = 1)
    private String login;

    @Column(name = "password")
    @CsvProperty(propertyType = CsvProperty.Type.SimpleProperty, columnNumber = 2)
    private String password;

    @Column(name = "role")
    @CsvProperty(propertyType = CsvProperty.Type.SimpleProperty, columnNumber = 3)
    private String role;

    @Column(name = "email")
    @CsvProperty(propertyType = CsvProperty.Type.SimpleProperty, columnNumber = 4)
    private String email;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Creds() {
    }

    public Creds(String login, String password, String role, String email) {
        this.login = login;
        this.password = password;
        this.role = role;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return id + " " + login + " " + password + " " + role + " " + email;
    }
}

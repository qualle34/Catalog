package com.senla.catalog.dto.user;

public class UserRegistrationDto {

    private String firstname;
    private String login;
    private String password;
    private String email;

    public UserRegistrationDto() {
    }

    public UserRegistrationDto(String firstname, String login, String password, String email) {
        this.firstname = firstname;
        this.login = login;
        this.password = password;
        this.email = email;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

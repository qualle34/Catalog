package com.senla.catalog.dto.auth;

public class AuthRequestDto {

    private String login;
    private String password;

    public AuthRequestDto() {
    }

    public AuthRequestDto(String login, String password) {
        this.login = login;
        this.password = password;
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
}

package com.senla.catalog.entity;

import com.senla.catalog.entity.constants.UserRole;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "credentials")
public class Creds {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int id;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private UserRole role;

    @Column(name = "email")
    private String email;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Creds() {
    }

    public Creds(String login, String password, UserRole role, String email) {
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

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Creds creds = (Creds) o;
        return id == creds.id &&
                Objects.equals(login, creds.login) &&
                Objects.equals(password, creds.password) &&
                Objects.equals(role, creds.role) &&
                Objects.equals(email, creds.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, password, role, email);
    }

    @Override
    public String toString() {
        return id + " " + login + " " + password + " " + role + " " + email;
    }
}

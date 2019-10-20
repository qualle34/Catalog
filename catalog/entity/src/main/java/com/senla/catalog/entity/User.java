package com.senla.catalog.entity;

import com.senla.catalog.entity.enums.UserRole;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToOne;
import javax.persistence.JoinColumn;
import javax.persistence.FetchType;
import javax.persistence.CascadeType;
import javax.persistence.TemporalType;
import javax.persistence.Temporal;
import javax.persistence.OneToMany;
import javax.persistence.ManyToMany;
import javax.persistence.JoinTable;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private long id;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "birthdate", columnDefinition = "DATETIME")
    @Temporal(TemporalType.DATE)
    private Date birthdate;

    @Column(name = "phone")
    private String phone;

    @Column(name = "location")
    private String location;

    @OneToOne(mappedBy = "user", optional = false, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Creds creds;

    @OneToOne(mappedBy = "user", optional = false, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private UserRating rating;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "role_id"))
    private Set<Role> roleSet = new HashSet<>();

    @OneToMany(mappedBy = "seller", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Deal> dealSet;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Advert> advertSet;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private Set<Comment> commentSet;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_chat", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "chat_id", referencedColumnName = "chat_id"))
    private Set<Chat> chatSet;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private Set<Message> messageSet;

    public User() {
    }

    public User(String firstname, String lastname, Date birthdate, String phone, String location) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthdate = birthdate;
        this.phone = phone;
        this.location = location;
    }

    public User(String firstname, String lastname, Date birthdate, String phone, String location, Creds creds, UserRating rating, Set<UserRole> roleSet) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthdate = birthdate;
        this.phone = phone;
        this.location = location;
        this.creds = creds;
        creds.setUser(this);
        this.rating = rating;
        rating.setUser(this);
        Set<Role> roles = new HashSet<>();
        for (UserRole role : roleSet) {
            roles.add(new Role(role));
        }
        this.roleSet = roles;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Creds getCreds() {
        return creds;
    }

    public void setCreds(Creds creds) {
        this.creds = creds;
        creds.setUser(this);
    }

    public UserRating getRating() {
        return rating;
    }

    public void setRating(UserRating rating) {
        this.rating = rating;
        rating.setUser(this);
    }

    public Set<UserRole> getRoleSet() {
        Set<UserRole> roles = new HashSet<>();
        for (Role role : roleSet) {
            roles.add(role.getRole());
        }
        return roles;
    }

    public void setRoleSet(Set<UserRole> roleSet) {
        Set<Role> roles = new HashSet<>();
        for (UserRole role : roleSet) {
            roles.add(new Role(role));
        }
        this.roleSet = roles;
    }

    public void addRole(UserRole role) {
        this.roleSet.add(new Role(role));
    }

    public Set<Deal> getDealSet() {
        return dealSet;
    }

    public void setDealSet(Set<Deal> dealSet) {
        this.dealSet = dealSet;
    }

    public Set<Advert> getAdvertSet() {
        return advertSet;
    }

    public void setAdvertSet(Set<Advert> advertSet) {
        this.advertSet = advertSet;
    }

    public Set<Comment> getCommentSet() {
        return commentSet;
    }

    public void setCommentSet(Set<Comment> commentSet) {
        this.commentSet = commentSet;
    }

    public Set<Chat> getChatSet() {
        return chatSet;
    }

    public void setChatSet(Set<Chat> chatSet) {
        this.chatSet = chatSet;
    }

    public Set<Message> getMessageSet() {
        return messageSet;
    }

    public void setMessageSet(Set<Message> messageSet) {
        this.messageSet = messageSet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                Objects.equals(firstname, user.firstname) &&
                Objects.equals(lastname, user.lastname) &&
                Objects.equals(birthdate, user.birthdate) &&
                Objects.equals(phone, user.phone) &&
                Objects.equals(location, user.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstname, lastname, birthdate, phone, location);
    }

    @Override
    public String toString() {
        return firstname + " " + lastname + " " + birthdate + " " + phone + " " + location;
    }

}
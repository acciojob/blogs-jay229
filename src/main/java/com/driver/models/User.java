package com.driver.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name ="User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String password;
    private  String firstName;
    private  String lastName;
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Blog> BlogList;


    public User(String username, String password, List<Blog> BlogList) {
        this.username = username;
        this.password = password;
        this.firstName = "test";
        this.lastName = "test";
        this.BlogList = BlogList;
    }

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Blog> getBlogList() {
        return BlogList;
    }

    public void setBlogList(List<Blog> blog) {
        this.BlogList = BlogList;
    }
}
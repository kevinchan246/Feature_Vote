package com.featurevote.domain;

import javax.annotation.processing.Generated;
import javax.persistence.*;



//User table in database
@Entity
@Table(name = "users") //this annotation is for avoiding the name/reserved word in mysql
public class User {
    private Long id;
    private String name;
    private String username;
    private String password;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) //auto-generate the id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}

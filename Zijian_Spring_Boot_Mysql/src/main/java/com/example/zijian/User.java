package com.example.zijian;

import org.hibernate.annotations.GeneratorType;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;


@Entity
public class User {
    @Id
    private Integer id;
    @Column(name = "name",nullable = true,length = 30)
    private String name;
    @Column(name = "password",nullable = true,length = 30)
    private String password;

    public User(){}

    public Integer getId(){return this.id;}

    public String getName(){return this.name;}

    public String getPassword(){return this.password;}

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

package com.example.zijian.Entity;

import javax.persistence.*;

@Entity
public class Utilisateur {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "age")
    private Integer age;

    public Utilisateur(){}

    public void setId(Integer id){
        this.id = id;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setName(String name){
        this.name = name;
    }

    public Integer getId(){return this.id;}
    public Integer getAge(){return this.age;}
    public String getName(){return this.name;}
}

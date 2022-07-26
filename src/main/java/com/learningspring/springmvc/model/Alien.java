package com.learningspring.springmvc.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Alien
{
    public Alien() {
    }

    public Alien(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }
    public String getName(){
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name){
        this.name = name;
    }
    @Id
    private int id;
    private String name;

    @Override
    public String toString() {
        return "Alien{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

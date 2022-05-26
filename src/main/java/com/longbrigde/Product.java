package com.longbrigde;

import javax.persistence.*;

@Entity
@Table(name= "product")
public class Product {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
    private String name;
    private String brand;
    private String made_in;
    private float price;

    public Product() {
    }

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

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getMade_in() {
        return made_in;
    }

    public void setMade_in(String made_in) {
        this.made_in = made_in;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}

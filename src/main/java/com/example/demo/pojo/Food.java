package com.example.demo.pojo;

import java.io.Serializable;
import java.math.BigDecimal;

public class Food implements Serializable {
    private int id;
    private String name;
    private String addre;
    private BigDecimal price;
    private String variety;

    public Food() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddre() {
        return addre;
    }

    public void setAddre(String addre) {
        this.addre = addre;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getVariety() {
        return variety;
    }

    public void setVariety(String variety) {
        this.variety = variety;
    }
}

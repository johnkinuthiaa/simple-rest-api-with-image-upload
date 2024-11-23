package com.slippery.fileupload.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.math.BigDecimal;

@Entity

public class Product {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;
    private String productName;
    private String description;
    private BigDecimal price;
    public Product(String productName,String description,BigDecimal price){
        this.productName =productName;
        this.description=description;
        this.price =price;
    }
    public Product(){}
    public void setId(Long id){
        this.id =id;
    }
    public Long getId(){
        return id;
    }
    public void setProductName(String productName){
        this.productName=productName;
    }
    public String getProductName(){
        return productName;
    }

    public BigDecimal getPrice() {
        return price;
    }
    public void setPrice(BigDecimal price){
        this.price=price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

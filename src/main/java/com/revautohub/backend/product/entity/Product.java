package com.revautohub.backend.product.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "products")
public class Product {
    //Primary key of the product table
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Product name
    @Column(nullable = false)
    private String name;

    //Product description
    @Column(nullable = false)
    private String description;

    //Product price
    @Column(nullable = false)
    private Double price;

    // Number of products available in stock
    @Column(nullable = false)
    private Integer stockQuantity;

    // Product image URL
    @Column(nullable = false)
    private String imageUrl;

    // Product category
    @Column(nullable = false)
    private String category;

    //Time product was created
    @Column(nullable = false)
    private LocalDateTime createdAt;

    //Constructor
    public Product() {
        this.createdAt = LocalDateTime.now();
    }

    //Getter for id
    public Long getId(){
        return id;
    }

    //Setter for id
    public void setId(Long id){
        this.id = id;
    }

    //Getter for name
    public String getName(){
        return name;
    }

    //Setter for name
    public void setName(String name){
        this.name = name;
    }

    //Getter for description
    public String getDescription(){
        return description;
    }

    //Setter for Description
    public void setDescription(String description){
        this.description = description;
    }

    //Getter for price
    public Double getPrice(){
        return price;
    }

    //Setter for price
    public void setPrice(Double price){
        this.price = price;
    }

    //Getter for StockQuantity
    public Integer getStockQuantity(){
        return stockQuantity;
    }

    //Setter for StockQuantity
    public void setStockQuantity(Integer stockQuantity){
        this.stockQuantity = stockQuantity;
    }

    //Getter for Image URL
    public String getImageUrl() {
        return imageUrl;
    }

    //Setter for Image URL
    public void setImageUrl(String imageUrl){
        this.imageUrl = imageUrl;
    }

    //Getter for category
    public String getCategory(){
        return category;
    }

    //Setter for category
    public void setCategory(String category){
        this.category = category;
    }

    //Getter for createdAt
    public LocalDateTime getCreatedAt(){
        return createdAt;
    }

    //Setter for createdAt
    public void setCreatedAt(LocalDateTime createdAt){
        this.createdAt = createdAt;
    }


}

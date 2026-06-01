package com.revautohub.backend.product.dto;

public class ProductRequestDTO {

    //Product name sent from frontend
    private String name;

    //Product description
    private String description;

    //Product price
    private Double price;

    //Stock quantity
    private Integer stockQuantity;

    //Product Image URL
    private String imageUrl;

    //Product category
    private String category;

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

    //Setter for description
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

    // Getter for stockQuantity
    public Integer getStockQuantity() {
        return stockQuantity;
    }

    // Setter for stockQuantity
    public void setStockQuantity(Integer stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    // Getter for imageUrl
    public String getImageUrl() {
        return imageUrl;
    }

    // Setter for imageUrl
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    // Getter for category
    public String getCategory() {
        return category;
    }

    // Setter for category
    public void setCategory(String category) {
        this.category = category;
    }



}

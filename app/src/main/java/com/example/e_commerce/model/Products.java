package com.example.e_commerce.model;

public class Products {
    private String description, image, category, price, productname, productid, time, date;

    public Products(){

    }

    public Products(String description, String image, String category, String price, String productname, String productid, String time, String date) {
        this.description = description;
        this.image = image;
        this.category = category;
        this.price = price;
        this.productname = productname;
        this.productid = productid;
        this.time = time;
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public String getImage() {
        return image;
    }

    public String getCategory() {
        return category;
    }

    public String getPrice() {
        return price;
    }

    public String getProductname() {
        return productname;
    }

    public String getProductid() {
        return productid;
    }

    public String getTime() {
        return time;
    }

    public String getDate() {
        return date;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public void setProductid(String productid) {
        this.productid = productid;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setDate(String date) {
        this.date = date;
    }
}

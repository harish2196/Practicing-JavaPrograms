package com.chainsys.project;


public class Product {
    public int id;
    public String name;
    public String model;
    public double price;

  
    public Product() {
       
    }

    public Product(int id, String name, String model, double price) {
        this.id = id;
        this.name = name;
        this.model = model;
        this.price = price;
    }

 
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

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

 
    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", model='" + model + '\'' +
                ", price=" + price +
                '}';
    }
}


package com.ehab.inventroyappstage2.data;

/**
 * Created by ehabhamdy on 3/26/18.
 */

public class Product {
    long id;
    String name;
    int price;
    int quantity;
    String supplierName;
    int supplierPhone;
    String supplierCountry;

    public Product(long id, String name, int price, int quantity, String supplierName, int supplierPhone, String supplierCountry) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.supplierName = supplierName;
        this.supplierPhone = supplierPhone;
        this.supplierCountry = supplierCountry;
    }

    public Product() {

    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public int getSupplierPhone() {
        return supplierPhone;
    }

    public String getSupplierCountry() {
        return supplierCountry;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public void setSupplierPhone(int supplierPhone) {
        this.supplierPhone = supplierPhone;
    }

    public void setSupplierCountry(String supplierCountry) {
        this.supplierCountry = supplierCountry;
    }
}

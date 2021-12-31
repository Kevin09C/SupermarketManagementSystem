package model;

import java.io.Serializable;

public class Products implements Serializable {
    private String name, category, supplier;
    private MyDate purchased_date, expirey_date;
    private double quantity, purchased_price, selling_price;

    public Products(String name, String category, String supplier, MyDate purchased_date, MyDate expirey_date,
             double quantity, double purchased_price, double selling_price){
        this.name = name;
        this.category = category;
        this.supplier = supplier;
        this.purchased_date = purchased_date;
        this.expirey_date = expirey_date;
        this.quantity = quantity;
        this.purchased_price = purchased_price;
        this.selling_price = selling_price;
    }

    public double getSelling_price() {
        return selling_price;
    }

    public void setSelling_price(double selling_price) {
        this.selling_price = selling_price;
    }

    public double getPurchased_price() {
        return purchased_price;
    }

    public void setPurchased_price(double purchased_price) {
        this.purchased_price = purchased_price;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public MyDate getExpirey_date() {
        return expirey_date;
    }

    public void setExpirey_date(MyDate expirey_date) {
        this.expirey_date = expirey_date;
    }

    public MyDate getPurchased_date() {
        return purchased_date;
    }

    public void setPurchased_date(MyDate purchased_date) {
        this.purchased_date = purchased_date;
    }

    public String getName() {
        return name;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return
                "name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", supplier='" + supplier + '\'' +
                ", purchased_date=" + purchased_date +
                ", expirey_date=" + expirey_date +
                ", quantity=" + quantity +
                ", purchased_price=" + purchased_price +
                ", selling_price=" + selling_price +
                '}';
    }
}

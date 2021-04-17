package com.example.apprestaurante.Models;

public class OrderModel {
    String itemName, price, orderNo;

    public OrderModel(String itemName, String price, String orderNo) {
        this.itemName = itemName;
        this.price = price;
        this.orderNo = orderNo;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }
}

package com.example.apprestaurante.Models;

public class OrderModel {
    String itemName, price, orderNo;
    int OrderImage, idUser;

    public OrderModel(String itemName, String price, String orderNo, int orderImage, int idUser) {
        this.itemName = itemName;
        this.price = price;
        this.orderNo = orderNo;
        this.OrderImage = orderImage;
        this.idUser = idUser;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
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

    public int getOrderImage() {
        return OrderImage;
    }

    public void setOrderImage(int orderImage) {
        OrderImage = orderImage;
    }
}

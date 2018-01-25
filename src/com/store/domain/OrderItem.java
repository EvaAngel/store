package com.store.domain;

public class OrderItem {
    private String orderitem_id;
    private String orderitem_name;
    private Double orderitem_account;
    private int orderitem_num;
    private Product product;
    private Order order;

    public String getOrderitem_id() {
        return orderitem_id;
    }

    public void setOrderitem_id(String orderitem_id) {
        this.orderitem_id = orderitem_id;
    }

    public String getOrderitem_name() {
        return orderitem_name;
    }

    public void setOrderitem_name(String orderitem_name) {
        this.orderitem_name = orderitem_name;
    }

    public Double getOrderitem_account() {
        return orderitem_account;
    }

    public void setOrderitem_account(Double orderitem_account) {
        this.orderitem_account = orderitem_account;
    }

    public int getOrderitem_num() {
        return orderitem_num;
    }

    public void setOrderitem_num(int orderitem_num) {
        this.orderitem_num = orderitem_num;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}

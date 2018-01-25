package com.store.domain;

import java.util.Date;
import java.util.List;

public class Order {
    private String order_id;
    private Double order_account;
    private String order_status;
    private String order_address;
    private Date order_createtime;
    private List<OrderItem> orderItems;
    private User user;

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public Double getOrder_account() {
        return order_account;
    }

    public void setOrder_account(Double order_account) {
        this.order_account = order_account;
    }

    public String getOrder_status() {
        return order_status;
    }

    public void setOrder_status(String order_status) {
        this.order_status = order_status;
    }

    public String getOrder_address() {
        return order_address;
    }

    public void setOrder_address(String order_address) {
        this.order_address = order_address;
    }

    public Date getOrder_createtime() {
        return order_createtime;
    }

    public void setOrder_createtime(Date order_createtime) {
        this.order_createtime = order_createtime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }
}

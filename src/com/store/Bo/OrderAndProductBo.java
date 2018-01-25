package com.store.Bo;

import com.store.domain.Order;
import com.store.domain.OrderItem;
import com.store.domain.Product;

import java.util.List;

public class OrderAndProductBo {
    private List<OrderItem> orderItem;
    private Order order;


    public List<OrderItem> getOrderItem() {
        return orderItem;
    }

    public void setOrderItem(List<OrderItem> orderItem) {
        this.orderItem = orderItem;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}

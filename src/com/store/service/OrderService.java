package com.store.service;

import com.store.domain.Cart;
import com.store.domain.Order;
import com.store.domain.User;

import java.util.List;

public interface OrderService {
    public List<Order> queryOrder(User user);
    public void addOrder(Cart cart);
}

package com.store.dao;

import com.store.Bo.OrderAndProductBo;
import com.store.domain.Order;
import com.store.domain.User;

import java.util.List;

public interface OrderDao {
    public List<Order> queryOrderAndProduct(String userid);
}

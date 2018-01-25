package com.store.service.impl;

import com.store.Bo.OrderAndProductBo;
import com.store.dao.OrderDao;
import com.store.dao.impl.OrderDaoImpl;
import com.store.domain.*;
import com.store.service.OrderService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class OrderServiceImpl implements OrderService {
    @Override
    public List<Order> queryOrder(User user){
        //获取user对象id
        String userid=user.getId();
        //dao层三表查询根据订单信息获取BO展示层数据
        OrderDao orderDao=new OrderDaoImpl();
        List<Order> list=orderDao.queryOrderAndProduct(userid);
        //跳转结果
        return list;
    }

    @Override
    public void addOrder(Cart cart) {
         //获取购物车信息，提取出订单项
        Map<String,CartItem> cartitem=cart.getCts();
        OrderAndProductBo orderAndProductBo=new OrderAndProductBo();
        List<OrderItem> orderItem=new ArrayList<>();
        Set<Map.Entry<String,CartItem>> cartItemEntry= cartitem.entrySet();
        for(Map.Entry entry:cartItemEntry)
        {
            OrderItem orderItem1=new OrderItem();
            CartItem cartItem1=(CartItem) entry.getValue();
            orderItem1.setProduct(cartItem1.getProduct());
        }
        orderAndProductBo.setOrderItem(orderItem);
        // 调用dao层插入订单方法，方法参数为Bo展示层对象
        //添加订单操作完成
    }
}

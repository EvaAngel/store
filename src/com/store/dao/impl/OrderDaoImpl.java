package com.store.dao.impl;

import com.store.Bo.OrderAndProductBo;
import com.store.dao.OrderDao;
import com.store.domain.*;
import com.store.util.ConnectToMysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDaoImpl implements OrderDao {
    /**
     * 根据用户id获取用户订单信息
     *
     * @param userid 用户id
     * @return 展示层类型orderandproductbo类 方便页面展示
     */
    @Override
    public List<Order> queryOrderAndProduct(String userid){
        // String sql="select p.id,p.custom_price,p.market_price,p.photo,p.describe,p.release_time,p.is_hot,p.is_flag,p.c_id,oi.orderitem_id,oi.orderitem_name,oi.orderitem_num,oi.orderitem_account,o.order_id,o.order_account,o.order_status,o.order_address,o.order_createtime from t_product p inner join t_orderitem oi on p.id=oi.product_id inner join t_order o on oi.order_id=o.order_id where o.user_id=?";
        String sql = "select * from t_order where user_id=?";
        PreparedStatement prepstat = ConnectToMysql.connectToMysql(sql);
        List<Order> list = new ArrayList<>();
        try {
            prepstat.setString(1, userid);
            ResultSet rs = prepstat.executeQuery();
            while (rs.next()) {
                //这里声明一下：其实这里的展示层类可以用orderitem类来代替，因为在里面含有product与order类。
                //所以，这里得出的结论是要不不用展示层类，要不不用组合引用。这里都用了，抱歉
                Order order = new Order();
                order.setOrder_id(rs.getString("order_id"));
                order.setOrder_account(rs.getDouble("order_account"));
                order.setOrder_status(rs.getString("order_status"));
                order.setOrder_address(rs.getString("order_address"));
                order.setOrder_createtime(rs.getDate("order_createtime"));
                User user = new User();
                user.setId(userid);
                order.setUser(user);
                list.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try{
            prepstat.close();
            ConnectToMysql.closeConnection();
        }catch (Exception e){e.printStackTrace();}
        }
        //为每个订单填入订单项
        for (Order o : list) {
            String sql2 ="select oi.orderitem_id,oi.orderitem_name,oi.orderitem_num,oi.orderitem_account,oi.product_id from  t_orderitem oi inner join t_order o on oi.order_id=o.order_id where o.order_id=?";
           PreparedStatement prepstat2 = ConnectToMysql.connectToMysql(sql2);
            try {
                prepstat2.setString(1, o.getOrder_id());
                ResultSet rs2 = prepstat2.executeQuery();

            List<OrderItem> orderItems = new ArrayList<>();
            while (rs2.next()) {
                OrderItem orderItem = new OrderItem();
                orderItem.setOrderitem_id(rs2.getString("oi.orderitem_id"));
                orderItem.setOrderitem_name(rs2.getString("oi.orderitem_name"));
                orderItem.setOrderitem_num(rs2.getInt("oi.orderitem_num"));
                orderItem.setOrderitem_account(rs2.getDouble("oi.orderitem_account"));
                String product_id = rs2.getString("oi.product_id");
                Product product = new Product();
                String sql3 = "select * from t_product where id=?";
                PreparedStatement prepstat3 = ConnectToMysql.connectToMysql(sql3);
                prepstat3.setString(1, product_id);
                ResultSet rs3=prepstat3.executeQuery();
                while (rs3.next()) {
                    product.setId(rs3.getString("id"));
                    product.setCustom_price(rs3.getDouble("custom_price"));
                    product.setMarket_price(rs3.getDouble("market_price"));
                    product.setPhoto(rs3.getString("describe"));
                    product.setRelease_time(rs3.getDate("release_time"));
                    product.setIs_hot(rs3.getInt("is_hot"));
                    product.setIs_flag(rs3.getInt("is_flag"));
                    Category category = new Category();
                    category.setId(rs3.getString("c_id"));
                    product.setCategory(category);
                }

                orderItem.setProduct(product);
                orderItems.add(orderItem);
                o.setOrderItems(orderItems);

            }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
                return list;
            }
        }

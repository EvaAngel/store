package com.store.servlet;

import com.store.Bo.OrderAndProductBo;
import com.store.domain.Cart;
import com.store.domain.Order;
import com.store.domain.User;
import com.store.service.OrderService;
import com.store.service.impl.OrderServiceImpl;
import com.store.servlet.base.BaseServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class OrderServlet extends BaseServlet {
    /**
     * 查询指定用户的订单信息
     * @param req
     * @param resp
     * @return 返回状态信息
     */
    public String queryOrder(HttpServletRequest req, HttpServletResponse resp) {
        //System.out.print("进入orderservlet成功");
        //获取用户信息
        HttpSession session=req.getSession();
        User user=(User) session.getAttribute("user");
        //根据用户信息获取订单信息
        if (user!=null) {
            OrderService orderService = new OrderServiceImpl();
                List<Order> list = orderService.queryOrder(user);
                req.setAttribute("list", list);
                req.setAttribute("msg", "获取用户订单信息成功");
            }
        //跳转页面
        return "order/ordermsg.jsp";
    }

    public String addOrder(HttpServletRequest req, HttpServletResponse resp){
        try {
            //获取购物车物品
            HttpSession session = req.getSession();
            Cart cart=(Cart) session.getAttribute("cart");
            //购物车相当于一个订单，调用service层的添加购物车服务
            OrderService orderService=new OrderServiceImpl();
            orderService.addOrder(cart);
            //重定向到订单列表
            resp.sendRedirect("order/ordermsg.jsp");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

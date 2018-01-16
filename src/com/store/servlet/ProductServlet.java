package com.store.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.store.domain.Product;
import com.store.service.ProductService;
import com.store.service.impl.ProductServiceImpl;
import com.store.servlet.base.BaseServlet;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet("/product")
public class ProductServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
    public String getProById(HttpServletRequest req, HttpServletResponse resp)
    {
    	//获取商品id
    	String id=req.getParameter("id");
    	//service层获取id所对应的商品信息
    	ProductService ps=new ProductServiceImpl();
    	Product product=ps.getProById(id);
    	//存入request作用域中
    	req.setAttribute("product", product);
    	//重定向到商品页面或者错误提示页面。
    	if(product==null)
    	{
    		req.setAttribute("msg", "获取商品详情失败");
    		return "/jsp/msg.jsp";
    	}
    	return "/product/product.jsp";
    }
}

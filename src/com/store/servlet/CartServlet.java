package com.store.servlet;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.store.dao.ProductDao;
import com.store.dao.impl.ProductDaoImpl;
import com.store.domain.Cart;
import com.store.domain.CartItem;
import com.store.domain.Product;
import com.store.servlet.base.BaseServlet;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/cart")
public class CartServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
    public String add2Cart(HttpServletRequest req, HttpServletResponse resp)
    {
    	//首先判断是否登陆
    	if(req.getSession().getAttribute("user")!=null)
    	{
    	//获取商品id、数量
    	String id =req.getParameter("id");
    	String count=req.getParameter("count");
    	//生成购物项
    	CartItem ct=new CartItem();
    	ProductDao pd =new ProductDaoImpl();
    	Product product=pd.getProById(id);
    	ct.setProduct(product);
    	ct.setCount(Integer.valueOf(count));
    	//将购物项加入购物车
    	Cart cart;
    	if(req.getSession().getAttribute("cart")==null){
    	cart=new Cart();
    	//将购物车放入session域中
    	req.getSession().setAttribute("cart", cart);
    	}
    	else
    	cart=(Cart) req.getSession().getAttribute("cart");	
    	cart.add2Cart(ct);
    	//重定向到cart.jsp 。。因为request中无数据
    	try
		{
			resp.sendRedirect(req.getContextPath()+"/cart/cart.jsp");
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	}
    	else
    	{
    		try
			{
				resp.sendRedirect(req.getContextPath()+"/index.jsp");
			} catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    	return null;
    }
}

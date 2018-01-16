package com.store.servlet;

import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.store.domain.Product;
import com.store.service.ProductService;
import com.store.service.impl.ProductServiceImpl;
import com.store.servlet.base.BaseServlet;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet("/index")  //注解相当于web下的配置
public class IndexServlet extends BaseServlet
{
	private static final long serialVersionUID = 1L;

	public void index(HttpServletRequest req, HttpServletResponse resp)
	{
		try
		{
			//调用service查询热门与最新商品，每一个返回一个list
			ProductService ps=new ProductServiceImpl();
			List<Product> hPro=ps.getHotProduct();
			List<Product> nPro=ps.getNewProduct();
			//将两个list放入request域中
			req.setAttribute("hpro", hPro);
			req.setAttribute("npro", nPro);
			//请求转发到index.jsp
			req.getRequestDispatcher("/user/login.jsp").forward(req, resp);
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

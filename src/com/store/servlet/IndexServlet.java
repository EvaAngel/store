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
@WebServlet("/index")  //ע���൱��web�µ�����
public class IndexServlet extends BaseServlet
{
	private static final long serialVersionUID = 1L;

	public void index(HttpServletRequest req, HttpServletResponse resp)
	{
		try
		{
			//����service��ѯ������������Ʒ��ÿһ������һ��list
			ProductService ps=new ProductServiceImpl();
			List<Product> hPro=ps.getHotProduct();
			List<Product> nPro=ps.getNewProduct();
			//������list����request����
			req.setAttribute("hpro", hPro);
			req.setAttribute("npro", nPro);
			//����ת����index.jsp
			req.getRequestDispatcher("/user/login.jsp").forward(req, resp);
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

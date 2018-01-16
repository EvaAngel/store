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
    	//��ȡ��Ʒid
    	String id=req.getParameter("id");
    	//service���ȡid����Ӧ����Ʒ��Ϣ
    	ProductService ps=new ProductServiceImpl();
    	Product product=ps.getProById(id);
    	//����request��������
    	req.setAttribute("product", product);
    	//�ض�����Ʒҳ����ߴ�����ʾҳ�档
    	if(product==null)
    	{
    		req.setAttribute("msg", "��ȡ��Ʒ����ʧ��");
    		return "/jsp/msg.jsp";
    	}
    	return "/product/product.jsp";
    }
}

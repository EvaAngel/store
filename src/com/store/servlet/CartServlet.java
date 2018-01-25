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
    	//�����ж��Ƿ��½
    	if(req.getSession().getAttribute("user")!=null)
    	{
    	//��ȡ��Ʒid������
    	String id =req.getParameter("id");
    	String count=req.getParameter("count");
    	//���ɹ�����
    	CartItem ct=new CartItem();
    	ProductDao pd =new ProductDaoImpl();
    	Product product=pd.getProById(id);
    	ct.setProduct(product);
    	ct.setCount(Integer.valueOf(count));
    	//����������빺�ﳵ
    	Cart cart;
    	if(req.getSession().getAttribute("cart")==null){
    	cart=new Cart();
    	//�����ﳵ����session����
    	req.getSession().setAttribute("cart", cart);
    	}
    	else
    	cart=(Cart) req.getSession().getAttribute("cart");	
    	cart.add2Cart(ct);
    	//�ض���cart.jsp ������Ϊrequest��������
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

	public String watchCart(HttpServletRequest req, HttpServletResponse resp) {
       return "cart/cart.jsp";
	}
}

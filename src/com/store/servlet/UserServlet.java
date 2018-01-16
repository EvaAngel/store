package com.store.servlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.UUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.store.constant.constant;
import com.store.domain.User;
import com.store.service.UserService;
import com.store.service.impl.UserServiceImpl;
import com.store.servlet.base.BaseServlet;

public class UserServlet extends BaseServlet
{
	/*
	 * ����û�����ת����
	 */
	public String registerUI(HttpServletRequest req, HttpServletResponse resp)
	{
		return "user/register.jsp";
	}

	/*
	 * ����û�ע�Ṧ��
	 */
	public String register(HttpServletRequest req, HttpServletResponse resp)
	{
		// ��ȡ��������װ��user����
		User user = new User();
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		user.setId(UUID.randomUUID().toString());
		user.setUsername(username);
		user.setPassword(password);
		// ����service�������ע��
        UserService us=new UserServiceImpl();
        us.regist(user);
		// ������ʾ��Ϣ��ת��/user/msg.jsp
        req.setAttribute("msg", "ע��ɹ�����ǰ�����伤��");
        return "jsp/msg.jsp";
		
	}
	/*
	 * ����û��ʼ������
	 * */
	public String active(HttpServletRequest req, HttpServletResponse resp)
	{
		//��ȡ�û�code��Ϣ
		String code=req.getParameter("code");
		//����service������ɼ���״̬���޸�
		UserService us=new UserServiceImpl();
		us.changeStatus(code);
		//������ʾ��Ϣ����ת���û���ҳ
		req.setAttribute("msg", "����ɹ����뾡��ʹ��");
		return "jsp/msg.jsp";
	}
	/*
	 * ����û���½����
	 * */
	public String login(HttpServletRequest req, HttpServletResponse resp)
	{
		//��ȡ�û�������
		User user=new User();
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		user.setUsername(username);
		user.setPassword(password);
		//����service������֤�Ƿ�Ϸ� ����user
		UserService us=new UserServiceImpl();
		User user2=us.validate(user);
		//��userΪ�գ���ʾ���Ϸ������ص�login.jsp
		if(user2==null)
		{
			try
			{
				resp.sendRedirect("user/login.jsp");
			} catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		//��user��codestatusΪ�գ����ص�msg.jsp��ʾδ����
		if(user2.getActivestatus()==constant.NO_ACTIVE_STATUS)
		{
			req.setAttribute("msg", "����ȥ������м������");
		    return "jsp/msg.jsp";
		}
		//req.set��½�ɹ���Ϣ
		req.setAttribute("msg", "��½�ɹ���");
		req.getSession().setAttribute("user", user2);
		//��user��name����cookie��
		try
		{
			Cookie c =new Cookie("saveName", URLEncoder.encode(username,"UTF-8"));
		    c.setMaxAge(Integer.MAX_VALUE);
		    c.setPath(req.getContextPath()+"/");
		    resp.addCookie(c);
		} catch (UnsupportedEncodingException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "function/main.jsp";
	}
	public String logout(HttpServletRequest req, HttpServletResponse resp)
	{
		//����session
		req.getSession().invalidate();
		//���¶���login.jsp
		try
		{
			resp.sendRedirect("user/login.jsp");
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}

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
	 * 完成用户的跳转功能
	 */
	public String registerUI(HttpServletRequest req, HttpServletResponse resp)
	{
		return "user/register.jsp";
	}

	/*
	 * 完成用户注册功能
	 */
	public String register(HttpServletRequest req, HttpServletResponse resp)
	{
		// 获取参数，封装成user对象
		User user = new User();
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		user.setId(UUID.randomUUID().toString());
		user.setUsername(username);
		user.setPassword(password);
		// 调用service方法完成注册
        UserService us=new UserServiceImpl();
        us.regist(user);
		// 生成提示消息，转发/user/msg.jsp
        req.setAttribute("msg", "注册成功，请前往邮箱激活");
        return "jsp/msg.jsp";
		
	}
	/*
	 * 完成用户邮件激活功能
	 * */
	public String active(HttpServletRequest req, HttpServletResponse resp)
	{
		//获取用户code信息
		String code=req.getParameter("code");
		//调用service方法完成激活状态的修改
		UserService us=new UserServiceImpl();
		us.changeStatus(code);
		//生成提示信息，跳转到用户主页
		req.setAttribute("msg", "激活成功，请尽情使用");
		return "jsp/msg.jsp";
	}
	/*
	 * 完成用户登陆操作
	 * */
	public String login(HttpServletRequest req, HttpServletResponse resp)
	{
		//获取用户名密码
		User user=new User();
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		user.setUsername(username);
		user.setPassword(password);
		//调用service方法验证是否合法 返回user
		UserService us=new UserServiceImpl();
		User user2=us.validate(user);
		//若user为空，表示不合法，返回到login.jsp
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
		//若user的codestatus为空，返回到msg.jsp表示未激活
		if(user2.getActivestatus()==constant.NO_ACTIVE_STATUS)
		{
			req.setAttribute("msg", "请先去邮箱进行激活操作");
		    return "jsp/msg.jsp";
		}
		//req.set登陆成功信息
		req.setAttribute("msg", "登陆成功！");
		req.getSession().setAttribute("user", user2);
		//将user的name放入cookie中
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
		//销毁session
		req.getSession().invalidate();
		//重新定向到login.jsp
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

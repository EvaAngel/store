package com.store.servlet.base;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BaseServlet extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
        //这个地方是真的妙啊：即了解了到底什么是动态加载（运行时决定执行那个对象的那个方法），又了解了反射的
		//动态加载过程，回忆多态。反射与多态的目的都是为了减少代码量，减少if-else。
		String mh = req.getParameter("method");
		try
		{
			if(mh==null||mh.trim().length()==0){mh="index";}
			//反射是已知方法名，在程序运行时动态加载执行某个方法。
			Method method = this.getClass().getMethod(mh, HttpServletRequest.class,HttpServletResponse.class);
			//执行此方法
			String path=(String) method.invoke(this,req, resp);
			//请求转发
			if(path!=null)
			{
				System.out.println(path);
				req.getRequestDispatcher(path).forward(req, resp);
			}

		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	public void index(HttpServletRequest req, HttpServletResponse resp)
	{
		try
		{
			req.getRequestDispatcher("500.jsp").forward(req, resp);
		}  catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

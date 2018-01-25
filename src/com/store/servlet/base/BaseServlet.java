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
        //����ط������������˽��˵���ʲô�Ƕ�̬���أ�����ʱ����ִ���Ǹ�������Ǹ������������˽��˷����
		//��̬���ع��̣������̬���������̬��Ŀ�Ķ���Ϊ�˼��ٴ�����������if-else��
		String mh = req.getParameter("method");
		try
		{
			if(mh==null||mh.trim().length()==0){mh="index";}
			//��������֪���������ڳ�������ʱ��̬����ִ��ĳ��������
			Method method = this.getClass().getMethod(mh, HttpServletRequest.class,HttpServletResponse.class);
			//ִ�д˷���
			String path=(String) method.invoke(this,req, resp);
			//����ת��
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

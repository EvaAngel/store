package com.store.servlet;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.store.domain.PageBean;
import com.store.service.CategoryService;
import com.store.service.impl.CategoryServiceImpl;
import com.store.servlet.base.BaseServlet;

public class CategoryServlet extends BaseServlet
{
	//��ѯ���з���
	public String findAll(HttpServletRequest req, HttpServletResponse resp)
	{
		//1  ������ֵ�����ʽ
		resp.setContentType("text/html;charset=utf-8");
		//2 service���ȡ������Ϣ������ֵΪstring����
		CategoryService cs =new CategoryServiceImpl();
		String categoryAll=cs.getAll();
		//3 �����д�뷵��ҳ��
		try
		{
			resp.getWriter().println(categoryAll);
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//4 ����null
		return null;
	}
	//ʵ����Ʒ����չʾ�ķ�ҳ����
	public String findByPage(HttpServletRequest req, HttpServletResponse resp)
	{
		//��ȡ����id�뵱ǰҳ��Ϣ
		String id=req.getParameter("cid");
		String pagenumber=req.getParameter("pageNumber");
		//����service���ѯ��Ҫչʾ����Ʒ��Ϣ������PageBean���ͣ�ҳ�棩
		CategoryService cs=new CategoryServiceImpl();
		PageBean pb=cs.getProByPage(pagenumber,id);
		//���������request��������
		req.setAttribute("pb", pb);
		//����ת����jsp��Ʒչʾҳ�档
		return "product/product_list.jsp";
	}
}

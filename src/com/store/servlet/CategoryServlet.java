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
	//查询所有分类
	public String findAll(HttpServletRequest req, HttpServletResponse resp)
	{
		//1  处理返回值编码格式
		resp.setContentType("text/html;charset=utf-8");
		//2 service层获取分类信息，返回值为string类型
		CategoryService cs =new CategoryServiceImpl();
		String categoryAll=cs.getAll();
		//3 将结果写入返回页面
		try
		{
			resp.getWriter().println(categoryAll);
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//4 返回null
		return null;
	}
	//实现商品分类展示的分页功能
	public String findByPage(HttpServletRequest req, HttpServletResponse resp)
	{
		//获取分类id与当前页信息
		String id=req.getParameter("cid");
		String pagenumber=req.getParameter("pageNumber");
		//调用service层查询所要展示的商品信息，返回PageBean类型（页面）
		CategoryService cs=new CategoryServiceImpl();
		PageBean pb=cs.getProByPage(pagenumber,id);
		//将对象存入request作用域中
		req.setAttribute("pb", pb);
		//请求转发到jsp商品展示页面。
		return "product/product_list.jsp";
	}
}

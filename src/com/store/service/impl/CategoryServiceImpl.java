package com.store.service.impl;

import java.util.List;

import com.google.gson.Gson;
import com.store.constant.constant;
import com.store.dao.CategoryDao;
import com.store.dao.impl.CategoryDaoImpl;
import com.store.domain.Category;
import com.store.domain.PageBean;
import com.store.domain.Product;
import com.store.service.CategoryService;

public class CategoryServiceImpl implements CategoryService
{
	//查询所有分类并格式化
	public String getAll()
	{
		//1 调用dao层获取分类信息的list集合
		CategoryDao cd=new CategoryDaoImpl();
		List<Category> categoryAll=cd.getAll();
		//2 将集合封装成json数据格式
		if(categoryAll!=null && categoryAll.size()>0)
		{
			Gson gson=new Gson();
			return gson.toJson(categoryAll);
		}
		return null;
	}
	//获取分页数据并将结果返回为pagenumber类型
	public PageBean getProByPage(String pagenumber,String id)
	{
		//生成pagebean对象
		PageBean pb=new PageBean();
		//调用dao层获取指定页数的商品信息
		CategoryDao cd=new CategoryDaoImpl();
		List<Product> proAll=cd.getProByPage(pagenumber,id);
		//调用dao层获取总记录数
		int sumCount=cd.getSumCount(id);
		//封装成一个pagebean并返回
		pb.setProAll(proAll);
		pb.setCurPage(Integer.valueOf(pagenumber));
		pb.setNumPage(sumCount/constant.CATEGORY_PAGE_PRO_COUNT);
		pb.setSumCount(sumCount);
		pb.setSumPage(constant.CATEGORY_PAGE_PRO_COUNT);
		return pb;
	}
}

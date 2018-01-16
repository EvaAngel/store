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
	//��ѯ���з��ಢ��ʽ��
	public String getAll()
	{
		//1 ����dao���ȡ������Ϣ��list����
		CategoryDao cd=new CategoryDaoImpl();
		List<Category> categoryAll=cd.getAll();
		//2 �����Ϸ�װ��json���ݸ�ʽ
		if(categoryAll!=null && categoryAll.size()>0)
		{
			Gson gson=new Gson();
			return gson.toJson(categoryAll);
		}
		return null;
	}
	//��ȡ��ҳ���ݲ����������Ϊpagenumber����
	public PageBean getProByPage(String pagenumber,String id)
	{
		//����pagebean����
		PageBean pb=new PageBean();
		//����dao���ȡָ��ҳ������Ʒ��Ϣ
		CategoryDao cd=new CategoryDaoImpl();
		List<Product> proAll=cd.getProByPage(pagenumber,id);
		//����dao���ȡ�ܼ�¼��
		int sumCount=cd.getSumCount(id);
		//��װ��һ��pagebean������
		pb.setProAll(proAll);
		pb.setCurPage(Integer.valueOf(pagenumber));
		pb.setNumPage(sumCount/constant.CATEGORY_PAGE_PRO_COUNT);
		pb.setSumCount(sumCount);
		pb.setSumPage(constant.CATEGORY_PAGE_PRO_COUNT);
		return pb;
	}
}

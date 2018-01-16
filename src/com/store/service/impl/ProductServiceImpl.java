package com.store.service.impl;

import java.util.List;

import com.store.dao.ProductDao;
import com.store.dao.impl.ProductDaoImpl;
import com.store.domain.Product;
import com.store.service.ProductService;

public class ProductServiceImpl implements ProductService
{
public List<Product> getHotProduct()
{
	//dao���ѯ��������Ʒ�����������
	ProductDao pd=new ProductDaoImpl();
	List<Product> hPro=pd.getHotProduct();
	return hPro;
}
public List<Product> getNewProduct()
{
	//dao���ѯ������Ʒ�����������
	ProductDao pd=new ProductDaoImpl();
	List<Product> nPro=pd.getNewProduct();
	return nPro;
}
//����id��ȡ��Ʒ��ϸ��Ϣ
	public Product getProById(String id)
	{
		//dao����ò����������
		Product p=new ProductDaoImpl().getProById(id);
		//�жϲ�ѯ����ֵ
		if(p==null)
		{
			return null;
		}
		else return p;
	}
}

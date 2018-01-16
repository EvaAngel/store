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
	//dao层查询最热门商品并将结果返回
	ProductDao pd=new ProductDaoImpl();
	List<Product> hPro=pd.getHotProduct();
	return hPro;
}
public List<Product> getNewProduct()
{
	//dao层查询最新商品并将结果返回
	ProductDao pd=new ProductDaoImpl();
	List<Product> nPro=pd.getNewProduct();
	return nPro;
}
//根据id获取商品详细信息
	public Product getProById(String id)
	{
		//dao层调用并将结果返回
		Product p=new ProductDaoImpl().getProById(id);
		//判断查询返回值
		if(p==null)
		{
			return null;
		}
		else return p;
	}
}

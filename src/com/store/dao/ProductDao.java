package com.store.dao;

import java.util.List;

import com.store.domain.Product;

public interface ProductDao
{

	List<Product> getHotProduct();

	List<Product> getNewProduct();
    
	Product getProById(String id);
}

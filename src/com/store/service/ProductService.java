package com.store.service;

import java.util.List;

import com.store.domain.Product;

public interface ProductService
{

	List<Product> getHotProduct();
	List<Product> getNewProduct();
	Product getProById(String id);
}

package com.store.dao;

import java.util.List;

import com.store.domain.Category;
import com.store.domain.Product;

public interface CategoryDao
{

	List<Category> getAll();

	List<Product> getProByPage(String pagenumber,String id);

	int getSumCount(String id);

}

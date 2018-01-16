package com.store.service;

import com.store.domain.PageBean;

public interface CategoryService
{

	String getAll();

	PageBean getProByPage(String pagenumber,String id);

}

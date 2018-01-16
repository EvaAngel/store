package com.store.dao;

import java.util.List;

import com.store.domain.User;

public interface UserDao
{
	public int ACTIVESTATUS=1;
	public void insert(User user);

	public void putStatusById(String code);

	public List<User> getUserAll();
}

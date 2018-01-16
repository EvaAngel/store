package com.store.service;

import com.store.domain.User;

public interface UserService
{
	public void regist(User user);

	public void changeStatus(String code);

	public User validate(User user);
}

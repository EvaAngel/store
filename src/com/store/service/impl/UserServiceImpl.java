package com.store.service.impl;

import java.util.List;

import com.store.dao.UserDao;
import com.store.dao.impl.UserDaoImpl;
import com.store.domain.User;
import com.store.service.UserService;
import com.store.util.SendJavaMailUtil;

public class UserServiceImpl implements UserService
{
	/*
	 * 完成注册业务逻辑
	 */
	public void regist(User user)
	{
		// 调用dao层完成注册
		UserDao ud = new UserDaoImpl();
		ud.insert(user);
		// 发送激活邮件
		String test = "付鑫先生你好, 很高兴的通知您，已经被我公司猩便利录用，若同意录用，请点击以下链接完成验证，<a href='http://localhost:8080/store/user?method=active&code="
				+ user.getId() + "'>点此验证</a>";
		SendJavaMailUtil.sendMal(test);
	}

	/*
	 * 完成更改业务逻辑
	 */
	public void changeStatus(String code)
	{
		// 调用dao层完成更改
		UserDao ud = new UserDaoImpl();
		ud.putStatusById(code);

	}

	/*
	 * 完成用户登陆验证功能
	 */
	public User validate(User user)
	{
		// dao层获取所有的用户信息：感觉这里很耗时间
		UserDao ud = new UserDaoImpl();
		List<User> userAll = ud.getUserAll();
		// 比对用户名与密码
		for (int i = 0; i < userAll.size(); i++)
		{
			if (user.getUsername().equals(userAll.get(i).getUsername())
					&& user.getPassword().equals(userAll.get(i).getPassword()))
			{
               return user;
			}
		}
		// 返回null或者匹配的user
		return null;
	}
}

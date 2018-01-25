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
	 * ���ע��ҵ���߼�
	 */
	public void regist(User user)
	{
		// ����dao�����ע��
		UserDao ud = new UserDaoImpl();
		ud.insert(user);
		// ���ͼ����ʼ�
		String test = "�����������, �ܸ��˵�֪ͨ�����Ѿ����ҹ�˾�ɱ���¼�ã���ͬ��¼�ã������������������֤��<a href='http://localhost:8080/store/user?method=active&code="
				+ user.getId() + "'>�����֤</a>";
		SendJavaMailUtil.sendMal(test);
	}

	/*
	 * ��ɸ���ҵ���߼�
	 */
	public void changeStatus(String code)
	{
		// ����dao����ɸ���
		UserDao ud = new UserDaoImpl();
		ud.putStatusById(code);

	}

	/*
	 * ����û���½��֤����
	 */
	public User validate(User user)
	{
		// dao���ȡ���е��û���Ϣ���о�����ܺ�ʱ��
		UserDao ud = new UserDaoImpl();
		List<User> userAll = ud.getUserAll();
		// �ȶ��û���������
		for (int i = 0; i < userAll.size(); i++)
		{
			if (user.getUsername().equals(userAll.get(i).getUsername())
					&& user.getPassword().equals(userAll.get(i).getPassword()))
			{
               return userAll.get(i);
			}
		}
		// ����null����ƥ���user
		return null;
	}
}

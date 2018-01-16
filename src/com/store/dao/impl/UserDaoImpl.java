package com.store.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.store.dao.UserDao;
import com.store.domain.User;
import com.store.util.ConnectToMysql;

public class UserDaoImpl implements UserDao
{
	/*
	 * 用户保存到数据库功能
	 */
	public void insert(User user)
	{
		String sql = "insert into t_user values (?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement prepstat = ConnectToMysql.connectToMysql(sql);
		try
		{
			prepstat.setString(1, user.getId());
			prepstat.setString(2, user.getUsername());
			prepstat.setString(3, user.getPassword());
			prepstat.setString(4, user.getEmail());
			prepstat.setString(5, user.getSex());
			prepstat.setString(6, user.getName());
			prepstat.setDate(7, user.getBirthday());
			prepstat.setString(8, user.getTelephone());
			prepstat.setInt(9, user.getActivecode());
			prepstat.setString(10, user.getActivestatus());
			prepstat.executeUpdate();
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * 更改用户注册状态
	 */
	@Override
	public void putStatusById(String code)
	{
		// TODO Auto-generated method stub
		String sql = "update t_user set activestatus=? where id=?";
		PreparedStatement prepstat = ConnectToMysql.connectToMysql(sql);
		try
		{
			prepstat.setInt(1, UserDao.ACTIVESTATUS);
			prepstat.setString(2, code);
			prepstat.executeUpdate();
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * 实现获取所有user用户的功能
	 */
	public List<User> getUserAll()
	{
		List<User> listAll = new ArrayList<>();
		try
		{
			String sql = "select * from t_user";
			PreparedStatement prepstat = ConnectToMysql.connectToMysql(sql);
			ResultSet rs = prepstat.executeQuery();
			while (rs.next())
			{
				User user = new User();
				user.setId(rs.getString("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
				user.setSex(rs.getString("sex"));
				user.setName(rs.getString("name"));
				user.setBirthday(rs.getDate("birthday"));
				user.setTelephone(rs.getString("telephone"));
				user.setActivecode(rs.getInt("activecode"));
				user.setActivestatus(rs.getString("activestatus"));
                listAll.add(user);
			}
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listAll;
	}
}

package com.store.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.store.constant.constant;
import com.store.dao.CategoryDao;
import com.store.domain.Category;
import com.store.domain.Product;
import com.store.domain.User;
import com.store.util.ConnectToMysql;

public class CategoryDaoImpl implements CategoryDao
{
	@Override
	public List<Category> getAll()
	{
		List<Category> listAll = new ArrayList<>();
		try
		{
			String sql = "select * from t_category";
			PreparedStatement prepstat = ConnectToMysql.connectToMysql(sql);
			ResultSet rs = prepstat.executeQuery();
			while (rs.next())
			{
				Category category = new Category();
				category.setId(rs.getString("id"));
				category.setName(rs.getString("name"));
                listAll.add(category);
			}
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listAll;
	}
	//获取指定页数下的分类商品的信息
	public List<Product> getProByPage(String pagenumber,String id)
	{
		List<Product> listAll = new ArrayList<>();
		int m=(Integer.valueOf(pagenumber)-1)*constant.CATEGORY_PAGE_PRO_COUNT;
		try
		{
			String sql = "select * from t_product where c_id=? limit ?,?";
			PreparedStatement prepstat = ConnectToMysql.connectToMysql(sql);
			prepstat.setString(1, id);
			prepstat.setInt(2, m);
			prepstat.setInt(3, constant.CATEGORY_PAGE_PRO_COUNT);
			ResultSet rs = prepstat.executeQuery();
			while (rs.next())
			{
				Product product = new Product();
				product.setId(rs.getString("id"));
				product.setCustom_price(rs.getDouble("custom_price"));
				product.setMarket_price(rs.getDouble("market_price"));
				product.setPhoto(rs.getString("photo"));
				product.setDescribe(rs.getString("describe"));
				product.setRelease_time(rs.getDate("release_time"));
				product.setIs_hot(rs.getInt("is_hot"));
				product.setIs_flag(rs.getInt("is_flag"));
				// 这个地方如何为多的实体category赋值
				String c_id = rs.getString("c_id");
				Category c = new Category();
				c.setId(c_id);
				product.setCategory(c);
				listAll.add(product);
			}
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listAll;
	}
	//获取分类商品的总记录数
	@Override
	public int getSumCount(String id)
	{
		int sum=0;
		try
		{
			String sql = "select sum(1) from t_product where c_id=?";
			PreparedStatement prepstat = ConnectToMysql.connectToMysql(sql);
			prepstat.setString(1, id);
			ResultSet rs = prepstat.executeQuery();
			while (rs.next())
			{
				sum=rs.getInt("sum(1)");
			}
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sum;
	}
}

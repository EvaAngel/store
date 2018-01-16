package com.store.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.store.constant.constant;
import com.store.dao.ProductDao;
import com.store.domain.Category;
import com.store.domain.Product;
import com.store.util.ConnectToMysql;
import com.sun.prism.Presentable;

public class ProductDaoImpl implements ProductDao
{
	public List<Product> getHotProduct()
	{
		List<Product> hPro = new ArrayList<>();
		try
		{
			String sql = "select * from t_product where is_hot=? and is_flag=? order by release_time desc limit ?";
			PreparedStatement prepstat = ConnectToMysql.connectToMysql(sql);
			prepstat.setString(1, constant.PRODUCT_IS_HOT);
			prepstat.setString(2, constant.PRODUCT_NOT_FLAG);
			prepstat.setInt(3, constant.PRODUCT_NUMBER);
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
				hPro.add(product);
			}
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return hPro;
	}

	public List<Product> getNewProduct()
	{
		List<Product> nPro = new ArrayList<>();
		try
		{
			String sql = "select * from t_product where is_flag=? order by release_time desc limit ?";
			PreparedStatement prepstat = ConnectToMysql.connectToMysql(sql);
			prepstat.setString(1, constant.PRODUCT_NOT_FLAG);
			prepstat.setInt(2, constant.PRODUCT_NUMBER);
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
				nPro.add(product);
			}
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return nPro;
	}

	public Product getProById(String id)
	{
		Product product = new Product();
		try
		{
			String sql = "select * from t_product where id=? limit 1";
			PreparedStatement prepstat = ConnectToMysql.connectToMysql(sql);
			prepstat.setString(1, id);
			ResultSet rs = prepstat.executeQuery();
			while(rs.next()){
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
			}
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return product;
	}
}

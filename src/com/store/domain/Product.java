package com.store.domain;

import java.util.Date;

public class Product
{
    private String id;
    private Double custom_price;
    private Double market_price;
    private String photo;
    private String describe;
    private Date release_time;
    private Integer is_hot;
    private Integer is_flag;
    private Category category;
	public String getId()
	{
		return id;
	}
	public void setId(String id)
	{
		this.id = id;
	}
	public Double getCustom_price()
	{
		return custom_price;
	}
	public void setCustom_price(Double custom_price)
	{
		this.custom_price = custom_price;
	}
	public Double getMarket_price()
	{
		return market_price;
	}
	public void setMarket_price(Double market_price)
	{
		this.market_price = market_price;
	}
	public String getPhoto()
	{
		return photo;
	}
	public void setPhoto(String photo)
	{
		this.photo = photo;
	}
	public String getDescribe()
	{
		return describe;
	}
	public void setDescribe(String describe)
	{
		this.describe = describe;
	}
	public Date getRelease_time()
	{
		return release_time;
	}
	public void setRelease_time(Date release_time)
	{
		this.release_time = release_time;
	}
	public Integer getIs_hot()
	{
		return is_hot;
	}
	public void setIs_hot(Integer is_hot)
	{
		this.is_hot = is_hot;
	}
	public Integer getIs_flag()
	{
		return is_flag;
	}
	public void setIs_flag(Integer is_flag)
	{
		this.is_flag = is_flag;
	}
	public Category getCategory()
	{
		return category;
	}
	public void setCategory(Category category)
	{
		this.category = category;
	}
    
}

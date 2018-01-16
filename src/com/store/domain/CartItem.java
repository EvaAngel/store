package com.store.domain;

public class CartItem
{
    private Product product;
    private int count;
    private double subtotal;
	public Product getProduct()
	{
		return product;
	}
	public void setProduct(Product product)
	{
		this.product = product;
	}
	public int getCount()
	{
		return count;
	}
	public void setCount(int count)
	{
		this.count = count;
	}
	public double getSubtotal()
	{
		return product.getCustom_price()*count;
	}
	public void setSubtotal(double subtotal)
	{
		this.subtotal = subtotal;
	}
    
}

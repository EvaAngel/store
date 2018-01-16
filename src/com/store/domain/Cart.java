package com.store.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

// 完成对map集合的一个遍历操作
public class Cart
{
	// 购物项集合
	private Map<String, CartItem> cts =new HashMap<>();
	/*static Map<String, CartItem> getcts()
	{
		if(cts!=null)
		{
			return cts;
		}
		else
			return new HashMap<String, CartItem>();
	}*/
	// 总金额
	private double total;

	// ----------------------------------
	public Map<String, CartItem> getCts()
	{
		return cts;
	}

	public void setCts(Map<String, CartItem> cts)
	{
		this.cts = cts;
	}

	public double getTotal()
	{
		return total;
	}

	public void setTotal(double total)
	{
		this.total = total;
	}

	// ---------------------------------------------------
	// 将购物项加入购物车
	public void add2Cart(CartItem ct)
	{
		// 1 判断购物车是否有该商品
		// 有，则修改购物车中该商品数量
		// 没有，put添加到购物车
		if (cts.size()!=0)
		{
			Set<Entry<String, CartItem>> entry = cts.entrySet();
			for (Entry<String,CartItem> e:entry)
			{
				String id = e.getKey();
				// 有此商品,数量++
				if (id.equals(ct.getProduct().getId()))
				{
					e.getValue().setCount(e.getValue().getCount() + 1);
					total += ct.getSubtotal();
					return;
				}
			}
			cts.put(ct.getProduct().getId(), ct);
			total += ct.getSubtotal();
		} else
		{
			cts.put(ct.getProduct().getId(), ct);
			total += ct.getSubtotal();
		}
	}

	// 将购物项根据其id移除购物车
	public void removeCart(String id)
	{
		Map.Entry<String, CartItem> entry = (Entry<String, CartItem>) cts.entrySet();
		for (int i = 0; i < cts.size(); i++)
		{
			if (id.equals(entry.getKey()))
			{
				cts.remove(entry.getKey());
				total -= entry.getValue().getSubtotal();
				return;
			}
		}
	}

	// 清空购物车
	public void clearCart()
	{
		cts.clear();
		total = 0;
	}
}

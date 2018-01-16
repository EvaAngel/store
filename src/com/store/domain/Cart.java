package com.store.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

// ��ɶ�map���ϵ�һ����������
public class Cart
{
	// �������
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
	// �ܽ��
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
	// ����������빺�ﳵ
	public void add2Cart(CartItem ct)
	{
		// 1 �жϹ��ﳵ�Ƿ��и���Ʒ
		// �У����޸Ĺ��ﳵ�и���Ʒ����
		// û�У�put��ӵ����ﳵ
		if (cts.size()!=0)
		{
			Set<Entry<String, CartItem>> entry = cts.entrySet();
			for (Entry<String,CartItem> e:entry)
			{
				String id = e.getKey();
				// �д���Ʒ,����++
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

	// �������������id�Ƴ����ﳵ
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

	// ��չ��ﳵ
	public void clearCart()
	{
		cts.clear();
		total = 0;
	}
}

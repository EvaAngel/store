package com.store.domain;

import java.util.List;

public class PageBean
{
   private List<Product> proAll;
   private int curPage;
   private int sumPage;
   private int sumCount;
   private int numPage;
public List<Product> getProAll()
{
	return proAll;
}
public void setProAll(List<Product> proAll)
{
	this.proAll = proAll;
}
public int getCurPage()
{
	return curPage;
}
public void setCurPage(int curPage)
{
	this.curPage = curPage;
}
public int getSumPage()
{
	return sumPage;
}
public void setSumPage(int sumPage)
{
	this.sumPage = sumPage;
}
public int getSumCount()
{
	return sumCount;
}
public void setSumCount(int sumCount)
{
	this.sumCount = sumCount;
}
public int getNumPage()
{
	return numPage;
}
public void setNumPage(int numPage)
{
	this.numPage = numPage;
}
   
}

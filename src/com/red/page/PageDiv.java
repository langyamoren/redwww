package com.red.page;

import java.io.Serializable;
import java.util.List;

public class PageDiv<T extends Serializable>
{
	
     private List<T>  list;  //封装每一页的数据
     private int offSet;     //起始偏移
     private int pageSize;   //每页多少条记录
     private int totalCount; //总共多少条记录
     
     public PageDiv(){}
     public PageDiv(int offSet,int pageSize,int totalCount,List<T> list)
     {
    	 this.offSet=offSet;
    	 this.pageSize=pageSize;
    	 this.totalCount=totalCount;
    	 this.list=list;
     }
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	public int getOffSet() {
		return offSet;
	}
	public void setOffSet(int offSet) {
		this.offSet = offSet;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
     
     
}

package com.red.action.web;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.Action;
import com.red.action.ActionBase;
import com.red.beans.Course;
import com.red.page.PageDiv;
import com.red.page.Pager;

public class CoursesAction extends ActionBase 
{
	private static final long serialVersionUID = 9138414291014651051L;
    private List<Course> list=new ArrayList<Course>();
    private Pager pager;       //分页的page
	private int pageSize=20;    //每页大小
	private int totalCount=0;  //总记录数
	private int pageNo;        //当前页数
    @Override
	public String execute() throws Exception 
	{
    	if(null==pager)pager=new Pager();
    	PageDiv<Course> pd=courseService.getAllCourse(pager.getOffset(), pageSize);
    	list=pd.getList();
    	totalCount=pd.getTotalCount();
		return Action.SUCCESS;
	}
	public List<Course> getList() {
		return list;
	}
	public void setList(List<Course> list) {
		this.list = list;
	}
	public Pager getPager() {
		return pager;
	}
	public void setPager(Pager pager) {
		this.pager = pager;
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
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

}

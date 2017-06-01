package com.red.action.web;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.Action;
import com.red.action.ActionBase;
import com.red.beans.Chapter;
import com.red.beans.Course;
import com.red.page.PageDiv;
import com.red.page.Pager;

public class CourseListAction extends ActionBase
{
	private static final long serialVersionUID = 255017605818610834L;
    private Course course;
    private List<Chapter> list=new ArrayList<Chapter>();
    private Pager pager;       //分页的page
	private int pageSize=20;    //每页大小
	private int totalCount=0;  //总记录数
	private int pageNo;        //当前页数
	private int chapterNo;
    @Override
	public String execute() throws Exception 
	{
    	if(null==pager)
    		{
    		pager=new Pager();
    		}
    	if(null!=course&&course.getId()>0)
    	{
        course=courseService.getCourseById(course.getId());
    	PageDiv<Chapter> pd=courseService.getChapterByCourseId(course.getId(), pager.getOffset(), pageSize);
    	list=pd.getList();
    	totalCount=pd.getTotalCount();
    	chapterNo=totalCount-pager.getOffset();
    	}else
    	{
    		this.addActionError("请选择课程!");
    	}
		return Action.SUCCESS;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public List<Chapter> getList() {
		return list;
	}
	public void setList(List<Chapter> list) {
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
	public int getChapterNo() {
		return chapterNo;
	}
	public void setChapterNo(int chapterNo) {
		this.chapterNo = chapterNo;
	}
    
	
}

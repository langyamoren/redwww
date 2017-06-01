package com.red.action.admin;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.red.action.ActionBase;
import com.red.beans.Chapter;
import com.red.beans.Course;
import com.red.beans.CourseType;
import com.red.page.PageDiv;
import com.red.page.Pager;

public class CourseAction extends ActionBase 
{

	private static final long serialVersionUID = -7727149032306380060L;
	
	private Course course;
	private List<CourseType> courseType=new ArrayList<CourseType>();
	private List<Course> courseList=new ArrayList<Course>();
	private List<Chapter> chapterList=new ArrayList<Chapter>();
	private Pager pager;       //分页的page
	private int pageSize=20;    //每页大小
	private int totalCount=0;  //总记录数
	private int pageNo;        //当前页数
	private int chapterNo;
	private String actionMsg;
	/**
	 * 跳转到增加课程界面
	 * @return
	 * @throws Exception
	 */
	public String addCourse()throws Exception
	{
		courseType=courseService.getCourseTypeAll();
		return "add";
	}
	/**
	 * 增加课程
	 * @return
	 * @throws Exception
	 */
	public String addSaveCourse()throws Exception
	{
		if(null!=course&&null!=course.getCourseType()&&course.getCourseType().getId()>0)
		{
			course.setCounts(0);
            if(courseService.addCourse(course))
            {
            	this.addActionMessage("增加课程成功！");
            }else
            {
            	this.addActionError("增加课程失败,请填写完整数据!");
            }
		}else
		{
			this.addActionError("增加课程失败,请填写完整数据!");
		}
		return addCourse();
	}
	
	/**
	 * 浏览课程信息
	 * @return
	 * @throws Exception
	 */
	public String browseCourse()throws Exception
	{
		if(null==pager)pager=new Pager();
		PageDiv<Course> pd=courseService.getAllCourse(pager.getOffset(), pageSize);
		if(null!=pd)
		{
			courseList=pd.getList();
			totalCount=pd.getTotalCount();
		}
		return Action.SUCCESS;
	}
	/**
	 * 跳至修改课程界面
	 * @return
	 * @throws Exception
	 */
	public String updateCourse()throws Exception
	{
		if(null!=course&&course.getId()>0)
		{
			course=courseService.getCourseById(course.getId());
		}
		courseType=courseService.getCourseTypeAll();
		return "edit";
	}
	public String updateSaveCourse()throws Exception
	{
		if(null!=course&&course.getId()>0)
		{
			Course old=courseService.getCourseById(course.getId());
			old.setCourseType(course.getCourseType());
			old.setDescs(course.getDescs());
			old.setIslock(course.getIslock());
			old.setIsrecom(course.getIsrecom());
			old.setKeyword(course.getKeyword());
			if(!old.getPicture().equals(course.getPicture()))
			{
				//删以前的首页图
				String path="res/upres/course_pic/"+old.getPicture();
				String realpath=ServletActionContext.getServletContext().getRealPath(path);
				File f=new File(realpath);
				if(f.exists())f.delete();
				old.setPicture(course.getPicture());
			}
			old.setSorts(course.getSorts());
			old.setTitle(course.getTitle());
			if(courseService.updateCourse(old))
			{
				this.addActionMessage("修改课程成功!");
			}else
			{
				this.addActionError("修改课程失败！");
			}
		}else
		{
			this.addActionError("修改数据失败，请填写完整资料");
		}
		return browseCourse();
	}
	
	public String deleteCourse()throws Exception
	{
		if(null!=course&&course.getId()>0)
		{
			
		     if(!courseService.hasChapter(course.getId())&&courseService.deleteCourseById(course.getId()))
		     {
		    	 //删除首页图片，和首页对应的html
		    	 this.addActionMessage("删除课程成功");
		     }else
		     {
		    	 this.addActionError("删除课程失败");
		     }
		}else
		{
			 this.addActionError("删除课程失败");
		}
		
		return browseCourse();
	}
	/**
	 * 得到课程下所有的内容列表
	 * @return
	 * @throws Exception
	 */
	public String listCourse()throws Exception
	{
/*		if(null!=course&&course.getId()>0)
		{
			course=courseService.getCourseById(course.getId());
			chapterList=courseService.getChapterByCourseId(course.getId());
			if(null!=actionMsg&&!"".equals(actionMsg))
			{
				this.addActionMessage(actionMsg);
			}
		}
		return "list";*/
    	if(null==pager){pager=new Pager();}
	if(null!=course&&course.getId()>0)
	{
		if(null!=actionMsg&&!"".equals(actionMsg))
		{
			this.addActionMessage(actionMsg);
		}
	    course=courseService.getCourseById(course.getId());
		PageDiv<Chapter> pd=courseService.getChapterByCourseId(course.getId(), pager.getOffset(), pageSize);
		chapterList=pd.getList();
		totalCount=pd.getTotalCount();
		chapterNo=totalCount-pager.getOffset();
	}else
	{
		this.addActionError("请选择课程!");
	}
	return "list";
	}
	
	
	
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public List<CourseType> getCourseType() {
		return courseType;
	}
	public void setCourseType(List<CourseType> courseType) {
		this.courseType = courseType;
	}
	public List<Course> getCourseList() {
		return courseList;
	}
	public void setCourseList(List<Course> courseList) {
		this.courseList = courseList;
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
	public List<Chapter> getChapterList() {
		return chapterList;
	}
	public void setChapterList(List<Chapter> chapterList) {
		this.chapterList = chapterList;
	}
	public String getActionMsg() {
		return actionMsg;
	}
	public void setActionMsg(String actionMsg) {
		this.actionMsg = actionMsg;
	}
	public int getChapterNo() {
		return chapterNo;
	}
	public void setChapterNo(int chapterNo) {
		this.chapterNo = chapterNo;
	}

	
	

}

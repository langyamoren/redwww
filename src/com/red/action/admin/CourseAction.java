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
	private Pager pager;       //��ҳ��page
	private int pageSize=20;    //ÿҳ��С
	private int totalCount=0;  //�ܼ�¼��
	private int pageNo;        //��ǰҳ��
	private int chapterNo;
	private String actionMsg;
	/**
	 * ��ת�����ӿγ̽���
	 * @return
	 * @throws Exception
	 */
	public String addCourse()throws Exception
	{
		courseType=courseService.getCourseTypeAll();
		return "add";
	}
	/**
	 * ���ӿγ�
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
            	this.addActionMessage("���ӿγ̳ɹ���");
            }else
            {
            	this.addActionError("���ӿγ�ʧ��,����д��������!");
            }
		}else
		{
			this.addActionError("���ӿγ�ʧ��,����д��������!");
		}
		return addCourse();
	}
	
	/**
	 * ����γ���Ϣ
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
	 * �����޸Ŀγ̽���
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
				//ɾ��ǰ����ҳͼ
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
				this.addActionMessage("�޸Ŀγ̳ɹ�!");
			}else
			{
				this.addActionError("�޸Ŀγ�ʧ�ܣ�");
			}
		}else
		{
			this.addActionError("�޸�����ʧ�ܣ�����д��������");
		}
		return browseCourse();
	}
	
	public String deleteCourse()throws Exception
	{
		if(null!=course&&course.getId()>0)
		{
			
		     if(!courseService.hasChapter(course.getId())&&courseService.deleteCourseById(course.getId()))
		     {
		    	 //ɾ����ҳͼƬ������ҳ��Ӧ��html
		    	 this.addActionMessage("ɾ���γ̳ɹ�");
		     }else
		     {
		    	 this.addActionError("ɾ���γ�ʧ��");
		     }
		}else
		{
			 this.addActionError("ɾ���γ�ʧ��");
		}
		
		return browseCourse();
	}
	/**
	 * �õ��γ������е������б�
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
		this.addActionError("��ѡ��γ�!");
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

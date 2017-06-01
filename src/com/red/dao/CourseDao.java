package com.red.dao;

import java.util.List;

import com.red.beans.Course;
import com.red.dao.base.RedCoreDao;
import com.red.page.PageDiv;

public interface CourseDao extends RedCoreDao<Course>{

	   /**
	    * 获取要显示的课程，常用于主页
	    * @param count 要显示的条数
	    * @return
	    */
	   public List<Course> getCourseByTop(int count);
	   /**
	    * 获取所有课程，分页显示
	    * @param offSet
	    * @param pageSize
	    * @return
	    */
	   public PageDiv<Course> getCourseByPage(int offSet ,int pageSize);
	   /**
	    * 根据课程所在类别获取所有课程，以sort长升充排列
	    * 
	    * @param typeId
	    * @param offSet
	    * @param pageSize
	    * @return
	    */
	   
	   public PageDiv<Course> getCourseByType(int typeId,int offSet ,int pageSize);
	   /**
	    * 获取推荐的课程，以sort升序排列
	    * @param topCount   要显示的推荐课程数
	    * @return
	    */
	   public List<Course> getCourseByRecom(int topCount);
	   /**
	    * 通过关键字来查找相关的课程
	    * @param keyword
	    * @param topCount
	    * @return
	    */
	   
	   public List<Course> getCourseByKeyword(String keyword,int topCount);
 
}

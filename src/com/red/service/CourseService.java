package com.red.service;

import java.util.List;

import com.red.beans.Chapter;
import com.red.beans.Course;
import com.red.beans.CourseType;
import com.red.page.PageDiv;
public interface CourseService  //extends ServiceBase
{
	/***************************课程类别****************************************/
       public boolean addCourseType(CourseType courseType);
       public boolean updateCourseType(CourseType courseType);
       public boolean deleteCoutseTypeById(Integer id);
       public CourseType getCourseTypeById(Integer id);
       public boolean hasCourse(Integer courseTypeId);
       public List<CourseType> getCourseTypeAll();
	
	/***************************Course课程相关方法************************************/
	
	public boolean addCourse(Course course);  //增加课程
	public boolean deleteCourseById(Integer id);  //删除课程
	public boolean updateCourse(Course course); //修改课程
	public Course getCourseById(Integer id);    //加载课程 
	public List<Course> getCourseByTop(Integer topCount); //查找课程
	public List<Course> getCourseByRecom(int topCount);//查找推荐课程
	public List<Course> getCourseByKeyword(String keyword,int topCount);//查找相关课程
	public PageDiv<Course> getAllCourse(int offSet,int pageSize);
	public boolean hasChapter(Integer courseId);  //判断课程 下有没有部分
	
	/***************************chapter节相关方法************************************/
	public boolean addChapter(Chapter chapter);
	public boolean deleteChapterById(Integer id);
	public boolean updateChapter(Chapter chapter);
	public Chapter getChapterById(Integer id);
	public List<Chapter> getChapterByCourseTopCount(Integer courseId,Integer topCount);
	public List<Chapter> getChapterByCourseId(Integer courseId);
	public PageDiv<Chapter> getChapterByCourseId(Integer courseId,int offSet,int pageSize);  //根据课程id查找其下所有内容
	public List<Chapter> getTopChapter(Integer topCount);    //查找最新发布的节


}

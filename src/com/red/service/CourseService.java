package com.red.service;

import java.util.List;

import com.red.beans.Chapter;
import com.red.beans.Course;
import com.red.beans.CourseType;
import com.red.page.PageDiv;
public interface CourseService  //extends ServiceBase
{
	/***************************�γ����****************************************/
       public boolean addCourseType(CourseType courseType);
       public boolean updateCourseType(CourseType courseType);
       public boolean deleteCoutseTypeById(Integer id);
       public CourseType getCourseTypeById(Integer id);
       public boolean hasCourse(Integer courseTypeId);
       public List<CourseType> getCourseTypeAll();
	
	/***************************Course�γ���ط���************************************/
	
	public boolean addCourse(Course course);  //���ӿγ�
	public boolean deleteCourseById(Integer id);  //ɾ���γ�
	public boolean updateCourse(Course course); //�޸Ŀγ�
	public Course getCourseById(Integer id);    //���ؿγ� 
	public List<Course> getCourseByTop(Integer topCount); //���ҿγ�
	public List<Course> getCourseByRecom(int topCount);//�����Ƽ��γ�
	public List<Course> getCourseByKeyword(String keyword,int topCount);//������ؿγ�
	public PageDiv<Course> getAllCourse(int offSet,int pageSize);
	public boolean hasChapter(Integer courseId);  //�жϿγ� ����û�в���
	
	/***************************chapter����ط���************************************/
	public boolean addChapter(Chapter chapter);
	public boolean deleteChapterById(Integer id);
	public boolean updateChapter(Chapter chapter);
	public Chapter getChapterById(Integer id);
	public List<Chapter> getChapterByCourseTopCount(Integer courseId,Integer topCount);
	public List<Chapter> getChapterByCourseId(Integer courseId);
	public PageDiv<Chapter> getChapterByCourseId(Integer courseId,int offSet,int pageSize);  //���ݿγ�id����������������
	public List<Chapter> getTopChapter(Integer topCount);    //�������·����Ľ�


}

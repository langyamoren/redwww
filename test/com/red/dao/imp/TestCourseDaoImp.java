package com.red.dao.imp;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.red.beans.Course;
import com.red.dao.CourseDao;
import com.red.page.PageDiv;

public class TestCourseDaoImp
{
	
	@Test
	public void testGetCourseByTop()
	{
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		CourseDao cd=(CourseDao) ac.getBean("courseDao");
		List<Course> list=cd.getCourseByTop(10);
		for(Course tem:list)
		{
			System.out.println(tem.getTitle());
		}
	}
	
	@Test
	public void testGetCourseByPage()
	{
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		CourseDao cd=(CourseDao) ac.getBean("courseDao");
		PageDiv<Course> pd=cd.getCourseByPage(0, 2);
		List<Course> list=pd.getList();
		for(Course tem:list)
		{
			System.out.println(tem.getTitle());
		}
		
	}
	
	@Test
	public void testGetCourseByType()
	{
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		CourseDao cd=(CourseDao) ac.getBean("courseDao");
		PageDiv<Course> pd=cd.getCourseByType(2, 0, 2);
		List<Course> list=pd.getList();
		for(Course tem:list)
		{
			System.out.println(tem.getTitle());
		}
	}
	
	@Test 
	public void testGetCourseByRecom()
	{
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		CourseDao cd=(CourseDao) ac.getBean("courseDao");
		List<Course> list=cd.getCourseByRecom(2);
		for(Course tem:list)
		{
			System.out.println(tem.getTitle());
		}
		
	}
	
	@Test
	public void testGetCourseByKeyword()
	{
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		CourseDao cd=(CourseDao) ac.getBean("courseDao");
		List<Course> list=cd.getCourseByKeyword("php", 2);
		for(Course tem:list)
		{
			System.out.println(tem.getTitle());
		}
	}
	

}

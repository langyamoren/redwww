package com.red.dao.imp;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.red.beans.CourseType;
import com.red.dao.CourseTypeDao;

public class TestCourseTypeDaoImp 
{
  @Test
  public void testGetAllCourseType()
  {
	  ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		CourseTypeDao cd=(CourseTypeDao) ac.getBean("courseTypeDao");
		List<CourseType> list=cd.getAllCourseType();
		for(CourseType tem:list)
		{
			System.out.println(tem.getName()+"\t"+tem.getSorts());
		}
  }
}

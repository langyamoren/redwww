package com.red.dao.imp;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.red.beans.Admin;
import com.red.dao.AdminDao;

public class TestAdminDaoImp 
{

	@Test
	public void testGetAll()
	{
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		AdminDao ad=(AdminDao) ac.getBean("adminDao");
		List<Admin> all=ad.getAllAdmin();
		for(Admin tem:all)
		{
			System.out.println(tem.getAdminName());
		}
	}
	@Test
	public void testCheckLogin()
	{
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		AdminDao ad=(AdminDao) ac.getBean("adminDao");
		System.out.println(ad.checkLogin("billow1", "billow8liu"));
	}
	@Test
	public void testcheckAdminExist()
	{
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		AdminDao ad=(AdminDao) ac.getBean("adminDao");
		System.out.println(ad.checkAdminExist("billow"));
	}
}

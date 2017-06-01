package com.red.dao.imp;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.red.beans.Member;
import com.red.dao.MemberDao;
import com.red.page.PageDiv;

public class TestMemberDaoImp {
	
	@Test
	public void testGetAllMember()
	{
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		MemberDao md=(MemberDao) ac.getBean("memberDao");
		PageDiv<Member> pd=md.getAllMember(0, 10);
		List<Member> list=pd.getList();
		for(Member tem:list)
		{
			System.out.println(tem.getId()+"\t"+tem.getEmail()+"\t"+tem.getName());
		}
		System.out.println("--------------------------------------------");
		System.out.println("pageSize:"+pd.getPageSize()+"\ttotalcount:"+pd.getTotalCount());
	}
	@Test
	public void testGetMemberByLevel()
	{
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		MemberDao md=(MemberDao) ac.getBean("memberDao");
		PageDiv<Member> pd=md.getMemberByLevel(3, 0, 10);
		List<Member> list=pd.getList();
		for(Member tem:list)
		{
			System.out.println(tem.getId()+"\t"+tem.getEmail()+"\t"+tem.getName());
		}
		System.out.println("--------------------------------------------");
		System.out.println("pageSize:"+pd.getPageSize()+"\ttotalcount:"+pd.getTotalCount());
	}
	
	@Test
	public void testGetNewComer()
	{
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		MemberDao md=(MemberDao) ac.getBean("memberDao");	
		List<Member> list=md.getNewComer(10);
		for(Member tem:list)
		{
			System.out.println(tem.getId()+"\t"+tem.getEmail()+"\t"+tem.getName());
		}
	}
	
	@Test
	public void testGetRecomeMembers()
	{
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		MemberDao md=(MemberDao) ac.getBean("memberDao");
		PageDiv<Member> pd=md.getRecomeMembers(2, 0, 10);
		List<Member> list=pd.getList();
		for(Member tem:list)
		{
			System.out.println(tem.getId()+"\t"+tem.getEmail()+"\t"+tem.getName());
		}
		System.out.println("--------------------------------------------");
		System.out.println("pageSize:"+pd.getPageSize()+"\ttotalcount:"+pd.getTotalCount());
	}
	
	@Test
	public void testCheckMemberExist()
	{
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		MemberDao md=(MemberDao) ac.getBean("memberDao");
		System.out.println(md.checkMemberExist("classku@163.com"));
	}
	@Test
	public void testCheckMember()
	{
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		MemberDao md=(MemberDao) ac.getBean("memberDao");
		System.out.println(md.checkMember("classku@163.com","kkk").getEmail());
		
	}

}

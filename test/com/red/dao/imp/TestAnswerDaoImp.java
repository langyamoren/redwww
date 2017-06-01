package com.red.dao.imp;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.red.beans.Answer;
import com.red.dao.AnswerDao;

public class TestAnswerDaoImp 
{
	@Test
	public void testGetByQuestion()
	{
	
	ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
	AnswerDao aw=(AnswerDao) ac.getBean("answerDao");
	List<Answer>  all=aw.getByQuestion(3);
	System.out.println(all.size());
	
	}
}

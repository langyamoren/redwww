package com.red.dao.imp;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.red.beans.ArticleType;
import com.red.dao.ArticleTypeDao;

public class TestArticleTypeImp 
{
   @Test
   public void testGetAll()
   {
	   ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
	   ArticleTypeDao at=(ArticleTypeDao) ac.getBean("articleTypeDao");
	   List<ArticleType> list=at.getAllArticleType();
	   for(ArticleType tem:list)
	   {
		   System.out.println(tem.getId()+"\t"+tem.getName()+"\t"+tem.getSorts());
	   }
	   
   }
}

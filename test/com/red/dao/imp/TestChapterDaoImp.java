package com.red.dao.imp;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.red.beans.Chapter;
import com.red.dao.ChapterDao;
import com.red.page.PageDiv;

public class TestChapterDaoImp 
{
  @Test
   public void testGetLastChapter()
   {
	   ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
	   ChapterDao cd=(ChapterDao) ac.getBean("chapterDao");
	   List<Chapter> list=cd.getLastChapter(10);
	   for(Chapter tem:list)
	   {
		   System.out.println(tem.getTitle());
	   }
	   
   }
   
   @Test
   public void testGetByCourseId()
   {
	   ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
	   ChapterDao cd=(ChapterDao) ac.getBean("chapterDao");
	   PageDiv<Chapter> pd=cd.getChapterByCourseId(1, 0, 10);
	   List<Chapter> list=pd.getList();
	   for(Chapter tem:list)
	   {
		   System.out.println(tem.getTitle());
	   }
   }
}

package com.red.dao.imp;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.red.beans.Article;
import com.red.dao.ArticleDao;
import com.red.page.PageDiv;

public class TestArticleDaoImp 
{
	@Test
    public void testGetByType()
    {
    	ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
    	ArticleDao ad=(ArticleDao) ac.getBean("articleDao");
    	PageDiv<Article> pd=ad.getArticleByType(5, 0, 10) ;
    	List<Article> list=pd.getList();
    	for(Article tem:list)
    	{
    		System.out.println(tem.getTitle()+"\t"+tem.getDates()+"\t"+tem.getIspass());
    	}
    	System.out.println(pd.getPageSize()+"\t"+pd.getTotalCount());
    	
    }
	@Test
	public void testGetTopArticle()
	{
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
    	ArticleDao ad=(ArticleDao) ac.getBean("articleDao");
    	long start=System.currentTimeMillis();
    	List<Article> list=ad.getArticleTop(10);
    	for(Article tem:list)
    	{
    		System.out.println(tem.getTitle()+"\t"+tem.getArticleType().getName()+"\t"+tem.getDates()+"\t"+tem.getIspass());
    	}
    	long end=System.currentTimeMillis();
    	System.out.println((end-start)+"ms");
    	
	}
	@Test
	public void testGetByType2()
	{
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
    	ArticleDao ad=(ArticleDao) ac.getBean("articleDao");
    	long start=System.currentTimeMillis();
    	List<Article> list=ad.getArticleByType(5, 10);
    	for(Article tem:list)
    	{
    		System.out.println(tem.getTitle()+"\t"+tem.getArticleType().getName()+"\t"+tem.getDates()+"\t"+tem.getIspass());
    	}
    	long end=System.currentTimeMillis();
    	System.out.println((end-start)+"ms");
    	
	}
	
	@Test
	public void testGetAllArticle()
	{
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
    	ArticleDao ad=(ArticleDao) ac.getBean("articleDao");
    	PageDiv<Article> pd=ad.getAllArticle(0, 10);
    	List<Article> list=pd.getList();
    	for(Article tem:list)
    	{
    		System.out.println(tem.getTitle()+"\t"+tem.getArticleType().getName()+"\t"+tem.getDates()+"\t"+tem.getIspass());
    	}
    	System.out.println(pd.getPageSize()+"\t"+pd.getTotalCount());
	}
	@Test
	public void testAboutArticle()
	{
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
    	ArticleDao ad=(ArticleDao) ac.getBean("articleDao");
    	List<Article> list=ad.getArticleAbout("mysql", 10);
    	for(Article tem:list)
    	{
    		System.out.println(tem.getTitle()+"\t"+tem.getArticleType().getName()+"\t"+tem.getDates()+"\t"+tem.getIspass());
    	}
    	
	}
	
}

package com.red.service.imp;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.red.beans.Article;
import com.red.beans.ArticleType;
import com.red.beans.Member;
import com.red.service.ArticleService;

public class TestArticleServiceImp
{
     @Test 
     public void testAddArticle()
     {
    	 ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
    	ArticleService as=(ArticleService) ac.getBean("articleService");
/*    	Article a=new Article();
    	ArticleType at=new ArticleType();
    	at.setName("пбндуб");
    	at.setSorts((byte)7);
    	at.setId(2);
    	a.setArticleType(at);
    	a.setContent("content<html>sfsdfs");
    	a.setIspass(false);
    	a.setIsred(false);
    	a.setKeyword("mysql linux");
    	Member m=new Member();
    	m.setId(2);
    	a.setMember(m);
    	a.setSorts((byte)6);
    	a.setTitle("test article");
    	System.out.println(as.addArticle(a));*/
    	ArticleType at=new ArticleType();
    	at.setId(2);
    	Article a=as.getArticleById(73);
    	a.getArticleType().setId(2);
    System.out.println(as.updateArticle(a));
    	

     }
}

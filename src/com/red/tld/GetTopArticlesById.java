package com.red.tld;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.springframework.web.context.support.WebApplicationContextUtils;

import com.red.beans.Article;
import com.red.service.ArticleService;
import com.red.util.Tools;

public class GetTopArticlesById extends SimpleTagSupport
{
   private int typeId;  //文章类别
   private int itermMaxLen=20;  //每行最大文字
   private String title;   //标题
   private String url;    //更多 url
   private int topCount;//显示多少条最新信息
   private String className;//类名
   private boolean showDate;
   public void doTag() throws JspException, IOException
	 {
		 StringBuilder sb=new StringBuilder();
		 ArticleService as=(ArticleService)WebApplicationContextUtils.getRequiredWebApplicationContext(((PageContext)getJspContext()).getServletContext()).getBean("articleService");
		 List<Article> list=as.getArticleByTop(typeId, topCount);
	     SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	     
	     //ariticle_top
 sb.append("<div class='"+className+"'>");
	 sb.append("<div class='tit_list'>");
	 sb.append(" <h2>"+title+"</h2>");
	 sb.append(" <a href='"+url+"'  target='_blank'>更多>></a>");
	 sb.append(" </div>");
	 sb.append(" <ul>");
	 if(null!=list&&list.size()>0)
	 {
		 for(int i=0;i<list.size();i++)
		 {
		   Article ar=list.get(i);
		   if(showDate)
		   {
	       sb.append("<li><b>["+ar.getArticleType().getName()+"]&nbsp;&nbsp;</b>");
	       sb.append("<a href='html/article/a"+ar.getArticleType().getId()+ar.getId()+".html'  target='_blank'>");
	       sb.append(Tools.cutString(ar.getTitle(), itermMaxLen)+"</a>&nbsp;&nbsp;");
	       sb.append("&nbsp;&nbsp;<font color='#CC0000;'>"+sf.format(ar.getDates())+"</font></li>");
		   }else
		   {
			   sb.append("<li>");
		       sb.append("<a target='_blank' href='html/article/a"+ar.getArticleType().getId()+ar.getId()+".html'>");
		       sb.append(Tools.cutString(ar.getTitle(), itermMaxLen)+"</a>&nbsp;&nbsp;");
		       sb.append("</li>");
		   }
		}
	 }else
	 {
	 sb.append("<li>数据库暂无数据</li>");
	 }
	 sb.append(" </ul>");
 sb.append("</div>");
 //输出处理结果到页面上
 getJspContext().getOut().println(sb); 
	 }
public int getTypeId() {
	return typeId;
}
public void setTypeId(int typeId) {
	this.typeId = typeId;
}
public int getItermMaxLen() {
	return itermMaxLen;
}
public void setItermMaxLen(int itermMaxLen) {
	this.itermMaxLen = itermMaxLen;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getUrl() {
	return url;
}
public void setUrl(String url) {
	this.url = url;
}
public int getTopCount() {
	return topCount;
}
public void setTopCount(int topCount) {
	this.topCount = topCount;
}
public String getClassName() {
	return className;
}
public void setClassName(String className) {
	this.className = className;
}
public boolean isShowDate() {
	return showDate;
}
public void setShowDate(boolean showDate) {
	this.showDate = showDate;
}
   
   
}

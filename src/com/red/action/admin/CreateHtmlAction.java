package com.red.action.admin;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.red.action.ActionBase;
import com.red.util.HtmlGenerator;

public class CreateHtmlAction extends ActionBase 
{

	private static final long serialVersionUID = 4639704071803252675L;

	@Override
	public String execute() throws Exception
	{
		String basePath=this.getText("red.basePath");
		
		String url=basePath+"/"+this.getText("red.html.right.url");
		
		//创建静态页面生成器实例
		HtmlGenerator hg = new HtmlGenerator(basePath);
		String realPath=ServletActionContext.getServletContext().getRealPath("/"+this.getText("red.html.right.path")+"right.html");
		//发布成静态页面html/right.html
		if (hg.createHtmlPage(url,realPath))
		{
		  this.addActionMessage("生成html：html/right.html");				
		}
		//发布成静态页面html/main.html
		String url1	=basePath+"/"+this.getText("red.html.main.url");
		String realPath1=ServletActionContext.getServletContext().getRealPath("/"+this.getText("red.html.main.path")+"main.html");
		
		if (hg.createHtmlPage(url1,realPath1))
		{
		  this.addActionMessage("生成html：html/main.html");				
		}
		//发布成静态页面html/index.html
		String url2	=basePath+"/html/main.html";
		String realPath2=ServletActionContext.getServletContext().getRealPath("/index.html");
		
		if (hg.createHtmlPage(url2,realPath2))
		{
		  this.addActionMessage("生成html：index.html");				
		}
		//发布成静态页面html/articles.html
		String url3	=basePath+"/"+this.getText("red.html.articles.url");
		String realPath3=ServletActionContext.getServletContext().getRealPath("/"+this.getText("red.html.articles.path")+"articles.html");
		
		if (hg.createHtmlPage(url3,realPath3))
		{
		  this.addActionMessage("生成html：html/articles.html");				
		}
		//发布成静态页面html/downloads.html
		String url4	=basePath+"/"+this.getText("red.html.downloads.url");
		String realPath4=ServletActionContext.getServletContext().getRealPath("/"+this.getText("red.html.downloads.path")+"downloads.html");
		
		if (hg.createHtmlPage(url4,realPath4))
		{
		  this.addActionMessage("生成html：html/downloads.html");				
		}
		return Action.SUCCESS;
	}

}

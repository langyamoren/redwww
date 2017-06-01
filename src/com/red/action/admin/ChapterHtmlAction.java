package com.red.action.admin;

import java.text.MessageFormat;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.red.action.ActionBase;
import com.red.util.HtmlGenerator;

public class ChapterHtmlAction extends ActionBase
{
	private static final long serialVersionUID = -5200386184776808919L;
    String [] chapterParam;
	@Override
	public String execute() throws Exception 
	{
		for(String tem:chapterParam)
		{
			//System.out.println(tem);
			Object []params=tem.split("[|]{2}");
			String basePath=this.getText("red.basePath");
			String url=basePath+"/"+MessageFormat.format(this.getText("red.html.course.content.url"),params);
			
			//创建静态页面生成器实例
			HtmlGenerator hg = new HtmlGenerator(basePath);
			String realPath=ServletActionContext.getServletContext().getRealPath("/"+this.getText("red.html.course.content.path")+"c"+params[1]+"c"+params[0]+".html");
			//发布成静态页面
			if (hg.createHtmlPage(url,realPath))
			{
			  this.addActionMessage("生成html：html/right.html");				
			}	
		}
		return Action.SUCCESS;
	}
	public String[] getChapterParam() {
		return chapterParam;
	}
	public void setChapterParam(String[] chapterParam) {
		this.chapterParam = chapterParam;
	}
    
}

package com.red.action.admin;

import java.text.MessageFormat;

import org.apache.struts2.ServletActionContext;

import com.red.action.ActionBase;
import com.red.beans.Course;
import com.red.page.PageDiv;
import com.red.page.Pager;
import com.red.util.HtmlGenerator;

public class CoursesHtmlAction extends ActionBase 
{
	private static final long serialVersionUID = 5593406995853852170L;
	private int pageSize=20;    //每页大小
	 private Pager pager;       //分页的page
	@Override
	public String execute() throws Exception {
		if(null==pager)pager=new Pager();
    	PageDiv<Course> pd=courseService.getAllCourse(0, pageSize);
    	
    	int totalCount=pd.getTotalCount();
    	int totalPage=(totalCount+pageSize-1)/pageSize;
    	for(int i=1;i<=totalPage;i++)
	    {
	    	String basePath=this.getText("red.basePath");
			String url=basePath+"/"+MessageFormat.format(this.getText("red.html.courses.url"),(i-1)*pageSize);
			
			//创建静态页面生成器实例
			HtmlGenerator hg = new HtmlGenerator(basePath);
			String realPath=ServletActionContext.getServletContext().getRealPath("/"+this.getText("red.html.courses.path")+"courses_"+i+"_.html");
			//发布成静态页面
			if (hg.createHtmlPage(url,realPath))
			{
			  this.addActionMessage("生成html：courses_"+i+"_.html");				
			}	
	    }
		return super.execute();
	}

}

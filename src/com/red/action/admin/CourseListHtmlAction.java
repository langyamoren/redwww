package com.red.action.admin;

import java.text.MessageFormat;

import org.apache.struts2.ServletActionContext;

import com.red.action.ActionBase;
import com.red.beans.Chapter;
import com.red.beans.Course;
import com.red.page.PageDiv;
import com.red.util.HtmlGenerator;

public class CourseListHtmlAction extends ActionBase
{
	private static final long serialVersionUID = -1822420106690732061L;
    private Course course;
    private int pageSize=20;
	@Override
	public String execute() throws Exception 
	{
	    if(null!=course&&course.getId()>0)
	    {
			PageDiv<Chapter> pd=courseService.getChapterByCourseId(course.getId(), 0, pageSize);
		    int totalNo=pd.getTotalCount();
		    int totalPage=(totalNo+pageSize-1)/pageSize;
		    for(int i=1;i<=totalPage;i++)
		    {
		    	String basePath=this.getText("red.basePath");
				String url=basePath+"/"+MessageFormat.format(this.getText("red.html.course.list.url"),course.getId(),(i-1)*pageSize);
				
				//创建静态页面生成器实例
				HtmlGenerator hg = new HtmlGenerator(basePath);
				String realPath=ServletActionContext.getServletContext().getRealPath("/"+this.getText("red.html.course.list.path")+"course"+course.getId()+"_"+i+"_.html");
				//发布成静态页面
				if (hg.createHtmlPage(url,realPath))
				{
				  this.addActionMessage("生成html：course"+course.getId()+"_"+i+"_.html");				
				}	
		    }
	    }
		return super.execute();
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}

}

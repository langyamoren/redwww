package com.red.tld;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.springframework.web.context.support.WebApplicationContextUtils;
import com.red.beans.QuestionType;
import com.red.service.QuestionService;
public class QuestionTypeList extends SimpleTagSupport
{
	public void doTag() throws JspException, IOException
	  {
	    StringBuilder sb=new StringBuilder();
	    QuestionService as=(QuestionService)WebApplicationContextUtils.getRequiredWebApplicationContext(((PageContext)getJspContext()).getServletContext()).getBean("questionService");
        List<QuestionType>  farther=as.getParent();
      
      
         for(QuestionType tem:farther)
         {
      	   sb.append("<h3>"+tem.getName()+"</h3>");
      	   List<QuestionType> sons=as.getSons(tem.getId());
      	   if(null!=sons&&sons.size()>0)
      	   {
      		   sb.append("<ul>");
      		   for(QuestionType son:sons)
      		   {
      			   sb.append("<li><a  href='red/question/questionList?typeId="+son.getId()+"'>");
      			   sb.append(son.getName());
      			   sb.append("</a></li>");
      		   }
      		   sb.append("</ul>");
      	   }
         }
     
  	//输出处理结果到页面上
  	getJspContext().getOut().println(sb); 
     
	  }
}

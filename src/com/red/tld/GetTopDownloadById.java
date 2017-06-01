package com.red.tld;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import org.springframework.web.context.support.WebApplicationContextUtils;
import com.red.beans.Download;
import com.red.service.DownloadService;
import com.red.util.Tools;

public class GetTopDownloadById extends SimpleTagSupport
{
   private int typeId;  //下载类别
   private int itermMaxLen=20;  //每行最大文字
   private String title;   //标题
   private String url;    //更多 url
   private int topCount;//显示多少条最新信息
   public void doTag() throws JspException, IOException
	 {
		 StringBuilder sb=new StringBuilder();
		 DownloadService as=(DownloadService)WebApplicationContextUtils.getRequiredWebApplicationContext(((PageContext)getJspContext()).getServletContext()).getBean("downloadService");
		 List<Download> list=as.getDownTopByType(typeId, topCount);
		 SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	     
	     
 sb.append("<div class='ariticle_top'>");
	 sb.append("<div class='tit_list'>");
	 sb.append(" <h2>"+title+"</h2>");
	 sb.append(" <a href='"+url+"'  target='_blank'>更多>></a>");
	 sb.append(" </div>");
	 sb.append(" <ul>");
	 if(null!=list&&list.size()>0)
	 {
		 for(int i=0;i<list.size();i++)
		 {
		   Download ar=list.get(i);
	      // sb.append("<li><a href='html/article/a"+ar.getDownType().getId()+ar.getId()+".html'>"+Tools.cutString(ar.getTitle(), itermMaxLen)+"</a></li>");
		   sb.append("<li><b style='margin-right:15px;'>["+ar.getDownType().getName()+"]</b>");
		   sb.append("<a target='_blank' href='html/down/d"+ar.getDownType().getId()+ar.getId()+".html'>"+Tools.cutString(ar.getTitle(), itermMaxLen)+"</a>");
			sb.append("<font style='color:#cc0000; margin-left:20px;'>"+sf.format(ar.getDates())+"</font></li>");
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
   
   
}

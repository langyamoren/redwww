<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@taglib uri="http://jsptags.com/tags/navigation/pager" prefix="pg" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>精品课程</title>
<style type="text/css">
#course_all_list{ list-style:none;}
#course_all_list li{ border-bottom:1px #CCCCCC solid; margin-bottom:20px; width:665px; height:104px; position:relative;}
#course_all_list li img{border:1px #CCCCCC solid;padding:2px;position:absolute;left: 11px;top: 10px;}
#course_all_list li h1{ border-bottom:1px #CCCCCC dashed; font-size:16px; width:485px; height:30px; line-height:30px;position:absolute;left: 167px;top: 11px;}
#course_all_list li h1 a{ text-decoration:none; color:#000000;}
#course_all_list li span{position:absolute;left: 533px;top: 24px;}
#course_all_list li h1 a:hover{ text-decoration:underline; color:#CC0000;}
#course_all_list li p{position:absolute;left: 167px;top: 42px;width: 485px;line-height:20px;}
#course_all_list li p a{ text-decoration:none; color:#666666; font-size:12px;}
#course_all_list li p a:hover{ text-decoration:underline;}
#course_all_list li center a{ text-decoration:none; color:#666666;font-weight:bold; font-size:12px;}
#course_all_list li center a:hover{ text-decoration:underline;}
</style>
</head>

<body>
<div>
<style type="text/css">
@import url(//www.google.com/cse/api/branding.css);
</style>
<div class="cse-branding-right" style="background-color:#FFFFFF;color:#000000; margin-top:10px; margin-left:30px;">
  <div class="cse-branding-form">
    <form action="http://www.redwww.com/html/search.html" id="cse-search-box">
      <div>
        <input type="hidden" name="cx" value="partner-pub-2147148573164130:rgjrrm1tnzq"/>
        <input type="hidden" name="cof" value="FORID:11" />
        <input type="hidden" name="ie" value="GB2312" />
        <input type="text" name="q" size="40" style="border:1px #CCCCCC solid; height:26px; line-height:26px;" />
        <input type="submit" name="sa" value="&#x641c;&#x7d22;"  style="border:1px #CCCCCC solid; height:26px; line-height:26px;" />
      </div>
    </form>
  </div>
  <div class="cse-branding-logo">
    <img src="//www.google.com/images/poweredby_transparent/poweredby_FFFFFF.gif" 

alt="Google" />
  </div>
  <div class="cse-branding-text">
    &#33258;&#23450;&#20041;&#25628;&#32034;
  </div>
</div>


</div>
  <ul id="course_all_list">
    <s:iterator value="list" status="stat">
     <li>
	    <a href="html/course/course<s:property value="id"/>_1_.html">
       <img  src="res/upres/course_pic/<s:property value="picture"/>" width="140" height="80" alt="<s:property value="title"/>" />
	   </a>
	   <h1>
	   <a target="_blank" href="html/course/course<s:property value="id"/>_1_.html">
	   <s:property value="title"/></a></h1>
	   <span><s:date name="dates" format="yyyy-MM-dd HH:mm:ss"/></span>
	   <p><a target="_blank" href="html/course/course<s:property value="id"/>_1_.html">
	   <s:property  value="%{@com.red.util.HtmlRegexpUtil@getDesc(descs,120)}"/><b>[详细信息]</b></a></p>
	 </li>
	 
    </s:iterator>
    <li><center>
	<pg:pager
    url="red/course/courses"
    items="${totalCount}"
    index="center"
    maxPageItems="20"
    maxIndexPages="10"
    isOffset="<%=true%>"
    export="offset,currentPageNumber=pageNumber"
    scope="page">
  
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<pg:first>
			  <a href="html/course/courses_1_.html">首页</a></pg:first>
			
			
			<pg:pages>
			   <a href="html/course/courses_<%=pageNumber%>_.html"><%= pageNumber %></a></pg:pages>
		
			
			<pg:last>
			  <a href="html/course/courses_<s:property value="totalCount%pageSize==0?totalCount/pageSize:totalCount/pageSize+1"/>_.html">最后一页</a></pg:last>
	</pg:pager>
	&nbsp;&nbsp;
	总共
	<font color="#FF0000">
	<s:property value="pager.offset/pageSize+1"/>
	</font>
	/
	<s:property value="totalCount%pageSize==0?totalCount/pageSize:totalCount/pageSize+1"/>页
	&nbsp;&nbsp;总共${totalCount}条	
				 </center></li>
  </ul>
</body>
</html>

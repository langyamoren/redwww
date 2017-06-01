<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="red" uri="http://www.redwww.com/tld" %>
<%@taglib uri="http://jsptags.com/tags/navigation/pager" prefix="pg" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>"/> 
<title>答疑解惑-<s:property value="questionType.questionType.name"/></title>
<style type="text/css">
 #questions{ width:730px;}
  #questions #que_left{ width:200px; float:left; border:1px #CCCCCC solid; padding:2px; margin:10px;}
  #questions #que_left h3{display:block; width:196px;  font-size:14px; font-weight:bold; color:#CC0000; line-height:30px; padding-left:10px; clear:both;}
  #questions #que_left ul li{ font-size:12px; margin-left:20px; line-height:26px; width:80px; float:left;}
  #questions #que_left ul li a{ color:#333333; text-decoration:none;font-weight:bold;}
  #questions #que_left ul li a:hover{ text-decoration:underline;}
  
  #questions #que_right{ width:500px; float:left;}
  #questions #que_right .ques_lists{ border:1px #CCCCCC solid; margin:10px 10px 10px 0px;}
  #questions #que_right .ques_lists ul{ list-style:none;}
  #questions #que_right .ques_lists ul li{ line-height:24px; padding-left:10px; border-bottom:1px #CCCCCC dashed;}
  #questions #que_right .ques_lists ul li a{ color:#333333; text-decoration:none;}
   #questions #que_right .ques_lists ul li a:hover{ text-decoration:underline;}
   #pageDiv{ text-align: center;}
   #pageDiv a{ color:#333333; text-decoration:none;}
   #pageDiv a:hover{ text-decoration:underline;}
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
<div id="questions">
	<div id="que_left">
	  <div class="tit_list">
           <h2>问题类别</h2>
	   </div>
	   <div>
	    <red:questionTypeList />
	   <!-- 
	      <h3>数据库</h3>
		  <ul>
			  <li><a href="#">mysql</a></li>
			  <li><a href="#">Oracle</a></li>
			  <li><a href="#">DB2</a></li>
			  <li><a href="#">Oracle</a></li>
			  <li><a href="#">DB2</a></li>
		  </ul>
		   -->
	   </div>
	</div>
	
	<div id="que_right">
	  <div class="ques_lists">
		   <div class="tit_list">
			   <h2><s:property value="questionType.questionType.name"/></h2>
				
		   </div>
		   <ul>
		        <s:iterator value="questionList">
				    <li>
				      <b>[<s:property value="questionType.name"/>]</b>
				      <a href="red/question/questionDesc?questionId=<s:property value="id"/>">
				      <s:property value="title" escape="false"/>
				      </a>
				    </li>
			   </s:iterator>
		   </ul>
	   </div>
	    
   </div>
	
	<div id="pageDiv">
				<pg:pager
			    url="red/question/questionList"
			    items="${totalCount}"
			    index="center"
			    maxPageItems="40"
			    maxIndexPages="10"
			    isOffset="<%=true%>"
			    export="offset,currentPageNumber=pageNumber"
			    scope="page">
			    <pg:param name="typeId" value="${typeId}"/>
						<pg:first>
						  <a href="<%= pageUrl %>"><nobr>首页</nobr></a>
						</pg:first>
						
						<pg:prev>
						  <a href="<%= pageUrl %>"><nobr>上一页</nobr></a>
						</pg:prev>
						<pg:pages>
						   <a href="<%= pageUrl %>"><%= pageNumber %></a> 
						</pg:pages>
						<pg:next>
						  <a href="<%= pageUrl %>"><nobr>下一页</nobr></a>
						</pg:next>
						
						<pg:last>
						  <a href="<%= pageUrl %>"><nobr>最后一页</nobr></a>
						</pg:last>
			
				</pg:pager>
				&nbsp;&nbsp;
				总共
				<font color="#FF0000">
				<s:property value="pager.offset/pageSize+1"/>
				</font>
				/
				<s:property value="totalCount%pageSize==0?totalCount/pageSize:totalCount/pageSize+1"/>页
				&nbsp;&nbsp;总共${totalCount}条 
			</div>
	
	<div class="clear"></div>
</div>
</body>
</html>

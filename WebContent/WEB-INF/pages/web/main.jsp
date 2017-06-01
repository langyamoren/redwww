<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@taglib prefix="red" uri="http://www.redwww.com/tld" %>
<%@taglib prefix="s" uri="/struts-tags" %>
    <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>"/>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030" />
<title>首页</title>
<style type="text/css">
/*左部分-广告*/
#main #left #adw{ list-style:none;}
#main #left #adw li { float:left; margin-left:5px;}
/*右部分-问题*/
#main #left #maintop{ clear:both; padding-top:10px; height:380px;}
#main #left #maintop #question_list{ width:240px; height:380px; border:1px #CCCCCC solid; margin-left:6px; float:left;}
#main #left #maintop #question_list ul{ list-style:none;}
#main #left #maintop #question_list ul li{ line-height:26px; padding-left:10px;}
#main #left #maintop #question_list ul li a{ color:#000000; text-decoration:none;}
#main #left #maintop #question_list ul li a:hover{ text-decoration:underline;}

/*新闻列表*/
#main #left #maintop #news_top{ width:470px;  float:right; list-style:none; line-height:30px;}
#main #left #maintop #news_top h1{ font-size:16px;}
#main #left #maintop #news_top h1 a{ text-decoration:none; color:#CC0000; font-size:16px;}
#main #left #maintop #news_top h1 a:hover{ text-decoration:underline;}
#main #left #maintop #news_top p{ line-height:24px; padding:0 3px;}
#main #left #maintop #news_top p a{text-decoration:none; color:#CC0000; font-size:12px;}
#main #left #maintop #news_top p a:hover{ text-decoration:underline;}
/*课程列表*/
#main #left #maintop #course_list{ list-style:none;}
#main #left #maintop #course_list li{ float:left; margin-left:15px;}
#main #left #maintop #course_list li p{ text-align:center; line-height:28px;}
#main #left #maintop #course_list li p a{ color:#333333; text-decoration:none;}
#main #left #maintop #course_list li p a:hover{ text-decoration:underline;}
/*标题*/
.tit_list{ height:28px; line-height:28px; background:url(res/image/redbak.png) repeat-x 0px -39px;}
.tit_list h2{ font-size:14px; color:#CC0000; font-weight:bold; width:100px; float:left; margin-left:10px;}
.tit_list a { display:block; float:right; color:#000000; text-decoration:none; font-size:12px; font-weight:300; padding-right:10px;}
.tit_list a:hover{ text-decoration:underline; color:#cc0000;}
/*文章列表*/
.article_list{ width:350px; height:220px; float:left; margin-left:5px; margin-right:3px; border:1px #CCCCCC solid; margin-bottom:10px;}
.article_list ul{ list-style:none; padding-left:10px;}
.article_list ul li{ line-height:24px;}
.article_list ul li span{ color:#CC0000;}
.article_list ul li a{ text-decoration:none; color:#000000;}
.article_list ul li a:hover{ text-decoration:underline;}

</style>
</head>
<body>
  <!--焦点广告-->
     <ul id="adw">
       <s:iterator value="focusList">
	   <li><a href="<s:property value="url"/>">
	   <img src="res/upres/focus/<s:property value="picture"/>" alt="<s:property value="title"/>" border="0"  width="235" height="160" /></a>
	   </li>
	   </s:iterator>
	 </ul>
	 <!--主体上部-->
	 <div id="maintop">
	    <!--问题-->
	    <div id="question_list">
		   <div class="tit_list">
           <h2>最新下载</h2>
		   <a href="html/downloads.html">更多&gt;&gt;</a>
		   </div>
		   <ul>
		      <s:iterator value="downList">
				<li><a href="<s:text name="red.html.down.path"></s:text>d<s:property value="downType.id"/><s:property value="id"/>.html"> <s:property  value="%{@com.red.util.HtmlRegexpUtil@getDesc(title,20)}"/></a></li>
			  </s:iterator>
		   </ul>
		</div>
		<!--新闻列表-->
		<div id="news_list">
		  <ul id="news_top">
		    <s:iterator value="newsList">
		     <li>
			    <h1><a href="<s:text name="red.html.article.path"></s:text>a<s:property value="articleType.id"/><s:property value="id"/>.html">
			    <s:property value="title"/></a></h1>
				<p>	
				 <s:property  value="%{@com.red.util.HtmlRegexpUtil@getDesc(content,60)}"/>	
				 <a href="<s:text name="red.html.article.path"></s:text>a<s:property value="articleType.id"/><s:property value="id"/>.html">【阅读全文】</a>
				</p>
			 </li>
			 </s:iterator>
			 
		  </ul>
		  <!--课程列-->
		  <ul id="course_list">
		      <s:iterator value="courseList">
				<li><a href="html/course/course<s:property value="id"/>_1_.html">
				     <img  src="res/upres/course_pic/<s:property value="picture"/>" width="140" height="80" alt="<s:property value="course.title"/>" />
				   </a>		
				   <p><a href="html/course/course<s:property value="id"/>_1_.html"><s:property value="title"/></a></p> 
		        </li>
		       </s:iterator>
				
		  </ul>
		</div>
		<div class="clear"></div>
	 </div><!--主体上部完成-->
	 
	  <!--广告图-->
	 <div style="padding:10px 1px; width:711px;">
<a href="http://www.host1plus.com/p/1261-0-1-63.html" target="_blank"><img border="0" src="http://www.host1plus.com/affiliates/banners/728x90cn.jpg" width="710" height="90" alt="Web Hosting"></a>
	 </div>
	 <!--文章列表-->
	 
<red:getArticles itermMaxLen="50" showDate="false" url="red/article/articleList?typeId=3" typeId="3" topCount="8" className="article_list" title="安全"/>
<red:getArticles itermMaxLen="50" showDate="false" url="red/article/articleList?typeId=4" typeId="4" topCount="8" className="article_list" title="Unix/Linux"/>
<red:getArticles itermMaxLen="50" showDate="false" url="red/article/articleList?typeId=5" typeId="5" topCount="8" className="article_list" title="数据库"/>
<red:getArticles itermMaxLen="50" showDate="false" url="red/article/articleList?typeId=7" typeId="7" topCount="8" className="article_list" title="Web开发"/>
</body>
</html>
<%@page language="java" import="com.red.util.HtmlRegexpUtil" contentType="text/html; charset=GB18030" pageEncoding="GB18030"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>"/>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>个人管理中心</title>
<link href="res/css/global.css" rel="stylesheet" type="text/css">
<style type="text/css">
#container{
width:780px;
margin:5 auto;
}
#tit_top #redBlock{ width:15px; height:30px; float:left; background-color:#CC0000;}
#tit_top h1{ float:left; width:300px; height:30px; line-height:30px; font-size:16px; margin-left:5px;}
#tit_top #membr_info{ height:30px; background-color:#CCCCCC;}
#tit_top #member_info p{ float:left; margin:0 10px; line-height:30px;}
#tit_top #member_info p img{display:inline;}
#space_nav{ margin:10px auto; height:18px;}
#space_nav ul{list-style:none;}
#space_nav ul li{ float:left;}
#space_nav ul li a{ display:block; width:100px; height:16px; border-right:6px #CC0000 solid; color:#333333; text-decoration:none; font-size:14px; font-weight:bold; line-height:16px; text-align:center;}
#space_nav ul li a:hover{
text-decoration:underline; color:#CC0000;}

#space_content{ margin-top:10px; clear:both;}
#space_content ul{ list-style:none;}
#space_content ul li{ border-bottom:1px #CCCCCC solid; height:140px; padding-top:10px;}
#space_content ul li img{ float:left; padding:0 10px;}
#space_content ul li h1{ float:left; width:580px; font-size:16px; font-weight:bold; border-bottom:1px #CCCCCC dashed;}
#space_content ul li #c_tit{float:left; text-align:right; width:580px; height:30px; line-height:30px; }
#space_content ul li #c_tit label{ font-weight:bold; margin-left:10px;}
#space_content ul li #course_desc{  line-height:20px; float:left; width:580px;}
#space_content ul li #course_but{ text-align:right; width:400px; float:left; line-height:25px;}
#space_content ul li #course_but label{ font-weight:bold; margin-left:20px;}
#space_content ul li #course_but img{margin-left:10px;  float:left;}

#space_content ul li a{ color:#333333; text-decoration:none;}
#space_content ul li a:hover{ text-decoration:underline;}
</style>

</head>

<body>
<div id="container">
    <%@include file="top.jsp" %>
	<div id="space_content">
	
	</div>
</div>

</body>
</html>

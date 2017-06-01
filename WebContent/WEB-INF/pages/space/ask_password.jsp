<%@page language="java" import="com.red.util.HtmlRegexpUtil" contentType="text/html; charset=GB18030" pageEncoding="GB18030"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>"/>
<sj:head debug="true" compressed="false" jquerytheme="showcase" customBasepath="themes"/>

<title>申请密码</title>
<style type="text/css">
#container{
width:780px;
margin:5 auto;
}
#tit_top #redBlock{ width:15px; height:30px; float:left; background-color:#CC0000;}
#tit_top h1{ float:left; width:150px; height:30px; line-height:30px; font-size:16px; margin-left:5px;}
#tit_top #membr_info{ height:30px; }
#tit_top #member_info p{ float:left; margin:0 10px; line-height:30px;}
#space_nav{ margin:10px auto; height:18px;}
#space_nav ul{list-style:none;}
#space_nav ul li{ float:left;}
#space_nav ul li a{ display:block; width:100px; height:16px; border-right:6px #CC0000 solid; color:#333333; text-decoration:none; font-size:14px; font-weight:bold; line-height:16px; text-align:center;}
#space_nav ul li a:hover{text-decoration:underline; color:#CC0000;}

#ask_container{ width:750px; margin:30px auto;}
#ask_container ul{padding-left: 50px;}
#ask_container ul li{line-height:30px;}

#askforpwd table{ border-collapse:collapse;}
#askforpwd table th{ background-color:#CC0000; color:#FFFFFF; line-height:26px;}
#askforpwd table td{ border:1px #CCCCCC dashed; line-height:24px; padding-left:6px;}
</style>
</head>
<body>
<div id="container">
    <%@include file="top.jsp" %>
	<div id="ask_container">
	 <h2>注意：</h2>
	 <ul>
	   <li>机器码不能为空</li>
	   <li>密码只能为一台电脑申请一次</li>
	   <li>申请以后不能更改</li>
	   <li>您确定要申请密码？</li>
	 </ul>
	<s:if test="flagPassword==true">
	 <form method="post"  action="red/savePassword_space">
      密码类型：
	<select name="pwd.pwdType" class="redInput">
	  <option value="红萌vip">红萌vip</option>
	</select>
	机器码：
	<input type="text" name="pwd.comCode" class="redInput"/>
	<input type="submit" value="申请密码"/>
 </form>
 </s:if>
	</div>
	<div id="askforpwd">
	<table width="660" border="0" align="center" cellpadding="0" cellspacing="0">
     <tr>
		<th width="46">序号</th>
		<th width="92">密码类型</th>
		<th width="206">机器码</th>
		<th width="204">密码</th>
		<th width="112">日期</th>
     </tr>
     <s:iterator value="pwdList" status="stat">
     <tr>
       <td><s:property value="#stat.index+1"/></td>
       <td><s:property value="pwdType"/></td>
       <td><s:property value="comCode"/></td>
       <td><s:property value="passwd"/></td>
       <td><s:date name="dates" format="yyyy-MM-dd"/></td>
     </tr>
     </s:iterator>
   </table>
   </div>
</div>
</body>
</html>
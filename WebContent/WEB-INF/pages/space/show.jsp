<%@page language="java" import="com.red.util.HtmlRegexpUtil" contentType="text/html; charset=GB18030" pageEncoding="GB18030"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%--
/*
* @Description: 快钱人民币支付网关接口范例
* @Copyright (c) 上海快钱信息服务有限公司
* @version 2.0
*/

/*
在本文件中，商家应从数据库中，查询到订单的状态信息以及订单的处理结果。给出支付人响应的提示。

本范例采用最简单的模式，直接从receive页面获取支付状态提示给用户。
*/

String orderId=(String)request.getParameter("orderId").trim();
String orderAmount=(String)request.getParameter("orderAmount").trim();
String msg=(String)request.getParameter("msg").trim();

--%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>快钱支付结果</title>
<meta http-equiv="content-type" content="text/html; charset=gb2312" >
<link href="res/css/global.css" rel="stylesheet" type="text/css">
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

</style>
	</head>
	
<BODY>
<div id="container">
<%@include file="top.jsp" %>
	<div align="pay_center">
		<table width="259" border="0" cellpadding="1" cellspacing="1" bgcolor="#CCCCCC" >
			<tr bgcolor="#FFFFFF">
				<td width="80">支付方式:</td>
				<td >快钱[99bill]</td>
			</tr>
			<tr bgcolor="#FFFFFF">
				<td >订单编号:</td>
				<td ><s:property value="orderId"/></td>
			</tr>
			<tr bgcolor="#FFFFFF">
				<td>订单金额:</td>
				<td><s:property value="orderAmount/100"/></td>
			</tr>
			<tr bgcolor="#FFFFFF">
				<td>支付结果:</td>
				<td><s:property value="msg"/></td>
			</tr>
	  </table>
	</div>
</div>
</BODY>
</HTML>
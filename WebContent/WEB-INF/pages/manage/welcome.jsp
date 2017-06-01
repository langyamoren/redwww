<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@ page import="javax.servlet.http.*" %>
<%@ page import="javax.servlet.*" %>
<%@ page import="java.io.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%
int temp = 0;
long star = 0;
long end = 0;
long ttime = 0;
Date before = new Date();
star = before.getTime();
for(int i=0;i<100000; i++)
{
temp=1+1;
}
Date after = new Date();
end = after.getTime();
ttime = end-star ;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <title>欢迎页面！</title>
    <base href="<%=basePath%>"/>
	<meta http-equiv="pragma" content="no-cache"/>
	<meta http-equiv="cache-control" content="no-cache"/>
	<meta http-equiv="expires" content="0"/>    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3"/>
	<meta http-equiv="description" content="This is my page"/>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
    <style type="text/css">
	  h3{
	  margin-top:10px;
	  font-size:16px;
	  color:#333333;
	  text-align:center;
	  line-height: 40px;
	  }
	  h4{
	  font-size:14px;
	  color:#CC0000;
	  font-weight:bold;
	  text-align:center;
	    line-height: 40px;
	    }
	  table{
	  border-collapse:collapse;}
      td{
	  border:1px #CC0000 solid; padding:3px;}

	</style>
  </head>
  
  <body>
	    <h3 align="center">欢迎光临红萌网管理系统</h3>

       <h4  align="center">服务器的有关参数</h4>
<table width=450 cellspacing=0 cellpadding=0 align="center">
<tr><td>
<table width=450 border=0 align="center" cellpadding=0 cellspacing=1>
<tr height=18 >
<td align=left width=150> 服务器名</td><td width="300"> <%= request.getServerName() %></td>
</tr>
<tr  height=18>
<td align=left> 服务器IP</td>
<td>&nbsp;</td>
</tr>
<tr  height=18>
<td align=left> 服务器端口</td><td> <%= request.getServerPort() %></td>
</tr>
<tr  height=18>
<td align=left> 服务器时间</td><td> <% out.println(new java.util.Date()); %></td>
</tr>
<tr  height=18>
<td align=left> 本文件路径</td><td> <%=request.getPathTranslated() %></td>
</tr>
<tr  height=18>
<td align=left> 服务器解译引擎</td><td> <% String publish=getServletContext().getServerInfo(); out.println(publish); %></td>
</tr>
<tr  height=18>
<td align=left> HTTP解译引擎</td><td> <%=request.getProtocol() %></td>
</tr>

</table>
</td>
</tr>
</table>

  </body>
</html>

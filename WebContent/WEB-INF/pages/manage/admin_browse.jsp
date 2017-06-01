<%@ page language="java" contentType="text/html; charset=GB18030" pageEncoding="GB18030"%>
<%@taglib prefix="s" uri="/struts-tags" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>"/> 

<meta http-equiv="Content-Type" content="text/html; charset=GB18030"/>
<title>管理员管理</title>
<link href="res/css/global.css" rel="stylesheet" type="text/css" />
<link href="res/dialog/dialog.css" rel="stylesheet" type="text/css" />
<script language="javascript" src="res/js/jquery-1.5.1.min.js"></script>
<script type="text/javascript" src="res/dialog/dialog.js"></script>
<style type="text/css">
#displayTable table{ border-collapse:collapse;}
#displayTable th{ background-color:#CC0000; line-height:26px;}
#displayTable table td{ border:1px #CCCCCC dashed; line-height:24px;}
#linkadd{margin-bottom:10px;}
#linkadd a{color:#333333;text-decoration:none;font-size: 16px; font-weight:bold;}
#linkadd a:hover{text-decoration:underline;}
</style>
</head>
<body style="padding-top:10px;">
<center>
	<div class="titleText"><h2 align="left">管理员管理</h2></div>
	<div id="linkadd" >
		<a href="mred/admin/goadmin">增加管理员</a>		
	</div>
	<div id="displayTable">
			<table border="0" cellspacing="0" cellpadding="0">
  <tr>
    <th width="60" align="center" valign="middle">序号</th>
    <th width="120" align="center" valign="middle">管理员名</th>
    <th width="80" align="center" valign="middle">查看</th>
    <th width="80" align="center" valign="middle">修改</th>
    <th width="80" align="center" valign="middle">删除</th>
  </tr>
  <s:iterator status="stat" value="adminList">
  <s:form method="post" namespace="/mred/admin">
  <tr>
    <td width="60" align="center" valign="middle"><s:property value="#stat.index+1"/></td>
    <td width="120" align="center" valign="middle">
    <s:property value="adminName"/><s:hidden name="admin.id" value="%{id}"/></td>
    <td width="80" align="center" valign="middle"><s:submit action="admin_view" value="查看"/></td>
    <td width="80" align="center" valign="middle"><s:submit action="admin_edit" value="修改"/></td>
    <td width="80" align="center" valign="middle">
    <s:if test="%{adminName!='admin'}">
     <s:submit action="admin_del" value="删除"/>
    </s:if>
    </td>
  </tr>
  </s:form>
  </s:iterator>
</table>

	</div>
</center>
<!-- 错误信息报告 -->
<div id="dialogID" style="display:none;">
   <font color="green"><s:actionmessage/></font>
  <font color="red"><s:actionerror/> <s:fielderror/></font>
</div>
  
<s:if test="hasActionMessages()||hasActionErrors()||hasFieldErrors()">
	<script language="javascript">
	dialog("温馨提示","id:dialogID","300px","auto","id"); 
	</script>	 
</s:if>
  </body>
</html>
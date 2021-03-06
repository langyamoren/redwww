<%@ page language="java" contentType="text/html; charset=gbk" pageEncoding="GB18030"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<s:head/>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>红萌网-下载类别管理</title>
<link href="res/css/global.css" rel="stylesheet" type="text/css" />
<link href="res/dialog/dialog.css" rel="stylesheet" type="text/css" />
<script language="javascript" src="res/js/jquery-1.5.1.min.js"></script>
<script type="text/javascript" src="res/dialog/dialog.js"></script>
<style type="text/css">
#articleTypeList{ border-collapse:collapse;}
#articleTypeList th{ background-color:#CC0000; color:#FFFFFF;}
#articleTypeList td{ border:1px #CCCCCC solid;}
</style>
</head>
<body>
<s:form namespace="/mred/download_type" action="add_download_type">
<table width="600" height="30" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td width="109" align="right" valign="middle">增加新类别：</td>
    <td width="185"><s:textfield name="downType.name"  cssClass="redInput" ></s:textfield></td>
    <td width="306" align="left" valign="middle"><s:submit cssClass="redButton" value="增加分类"></s:submit></td>
  </tr>
</table>
</s:form>
<table width="600" height="30" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td width="10">&nbsp;</td>
    <td width="590" align="left" valign="middle" style=" font-size:16px; font-weight:bold;">文章类别列表</td>
  </tr>
</table>
<table width="600" border="0" align="center" cellpadding="0" cellspacing="0" id="articleTypeList">
  <tr>
    <th width="50" height="30" align="center" valign="middle">序号</th>
    <th width="190" height="30" align="center" valign="middle">标题</th>
    <th width="100" height="30" align="center" valign="middle">排序</th>
    <th width="130" height="30" align="center" valign="middle">修改</th>
    <th width="130" height="30" align="center" valign="middle">删除</th>
  </tr>
  <s:iterator value="downList" status="state">
  <s:form namespace="/mred/download_type">
  <tr>
    <td height="30" align="center" valign="middle">
    <s:hidden name="downType.id" value="%{id}"></s:hidden>
    <s:property value="#state.index+1"/></td>
    <td height="30" align="left" valign="middle">
    <s:textfield name="downType.name" value="%{name}" cssClass="redInput" cssStyle="width:120px; margin-left:10px;"/></td>
    <td height="30" align="center" valign="middle">
    <s:textfield name="downType.sorts" value="%{sorts}" cssClass="redInput"  cssStyle="width:80px; margin-left:10px;"/></td>
    <td height="30" align="center" valign="middle">
    <s:submit action="update_download_type" value="修改" cssClass="redButton"/>
    </td>
    <td height="30" align="center" valign="middle">
    <s:submit action="delete_download_type" value="删除" cssClass="redButton"/>
    </td>
  </tr>
  </s:form>
  </s:iterator>
</table>
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
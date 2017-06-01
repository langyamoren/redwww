<%@ page language="java" contentType="text/html; charset=GB18030" pageEncoding="GB18030"%>
<%@page import="com.red.util.RcomeRandCode" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@taglib uri="http://jsptags.com/tags/navigation/pager" prefix="pg" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>"/> 
<meta http-equiv="Content-Type" content="text/html; charset=GB18030"/>
<title>会员管理</title>
<link href="res/css/global.css" rel="stylesheet" type="text/css" />
<link href="res/dialog/dialog.css" rel="stylesheet" type="text/css" />
<script language="javascript" src="res/js/jquery-1.5.1.min.js"></script>
<script type="text/javascript" src="res/dialog/dialog.js"></script>
<style type="text/css">
#mem_conatinaer table{ border-collapse:collapse;}
#mem_conatinaer table th{ background-color:#CC0000; color:#FFFFFF; font-size:12px; line-height:24px;}
#mem_conatinaer table td{ line-height:24px; border:1px #CCCCCC dashed;}
#mem_conatinaer table td a{ color:#333333; text-decoration:none;}
#mem_conatinaer table td a:hover{text-decoration:underline;}
</style>
</head>
<body>
<h2>会员管理</h2>
<div id="mem_conatinaer">
<s:form namespace="/mred/member" action="search_member" method="post" cssStyle="margin-left:50px;">
 Email:<s:textfield name="member.Email" cssClass="redInput"></s:textfield>
 <s:submit value="搜索" cssClass="redButton"></s:submit>
</s:form>
<table width="750" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <th width="48" align="center" valign="middle">序号</th>
    <th width="80" align="center" valign="middle">会员名</th>
    <th width="188" align="center" valign="middle">Email</th>
    <th width="84" align="center" valign="middle">QQ</th>
    <th width="58" align="center" valign="middle">积分</th>
    <th width="65" align="center" valign="middle">余额</th>
    <th width="71" align="center" valign="middle">推荐码</th>
    <th width="92" align="center" valign="middle">日期</th>
    <th width="64" align="center" valign="middle">修改</th>
  </tr>
  <s:iterator status="stat" value="memberList">
  <s:form namespace="/mred/member" method="post">
  <tr <s:if test="#stat.odd == true"> bgcolor="#EEEEEE"</s:if>>
    <td width="48" align="center" valign="middle"><s:property value="#stat.index+1"/><s:hidden name="member.id" value="%{id}"></s:hidden></td>
    <td width="80" align="center" valign="middle"><s:property value="name"/></td>
    <td width="188" align="left" valign="middle"><s:property value="Email"/></td>
    <td width="84" align="center" valign="middle"><s:property value="qq"/></td>
    <td width="58" align="center" valign="middle"><s:property value="integal"/></td>
    <td width="65" align="center" valign="middle"><s:property value="balance"/></td>
    <td width="71" align="center" valign="middle"><s:property value="@com.red.util.RcomeRandCode@parseToString(id)"/></td>
    <td width="92" align="center" valign="middle"><s:date name="dates" format="yyyy-MM-dd"></s:date></td>
	<td width="64" align="center" valign="middle"><s:submit value="查看" action="view_member" cssClass="redButton"/></td>
  </tr>
  </s:form>
  </s:iterator>
  <tr>
    <td colspan="10" align="center" valign="middle">
     <pg:pager
    url="mred/member/browseAll_member"
    items="${totalCount}"
    index="center"
    maxPageItems="30"
    maxIndexPages="10"
    isOffset="<%=true%>"
    export="offset,currentPageNumber=pageNumber"
    scope="page">
			<pg:first>
			  <a href="<%= pageUrl %>">首页</a>
			</pg:first>
			
			<pg:prev>
			  <a href="<%= pageUrl %>">上一页</a>
			</pg:prev>
			<pg:pages>
			   <a href="<%= pageUrl %>"><%= pageNumber %></a> 
			</pg:pages>
			<pg:next>
			  <a href="<%= pageUrl %>">下一页</a>
			</pg:next>
			
			<pg:last>
			  <a href="<%= pageUrl %>">最后一页</a>
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
    </td>
    </tr>
</table>
</div>
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
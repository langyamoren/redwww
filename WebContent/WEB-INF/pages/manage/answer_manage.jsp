<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>问题管理</title>
<style type="text/css">
.answerTable {
border-collapse:collapse;
}
.anwerTable >td{
border:1px #CCCCCC solid;
padding:3px;}
</style>
</head>
<body>

<h3><s:property value="question.title"/>?</h3>
<table width="780" border="0" cellspacing="0" cellpadding="0" class="answerTable">
 <s:iterator value="answerList" status="state">
 <s:form action="answer_delete" namespace="/mred/question">
  <tr>
    <td width="47" align="left" valign="middle"><s:property value="%{#state.index+1}"/></td>
    <td width="516"><s:property value="content"/><s:hidden name="answer.id" value="%{id}"/></td>
    <td width="87"><s:property value="member.name"/></td>
    <td width="67"><s:date name="dates" format="yyyy-MM-dd"/></td>
    <td width="63"><s:submit value="删除" cssClass="redButton"/></td>
  </tr>
  </s:form>
  </s:iterator>

</table>
</body>
</html>
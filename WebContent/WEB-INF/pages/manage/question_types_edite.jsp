<%@ page language="java" contentType="text/html; charset=GB18030" pageEncoding="GB18030"%>
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
<title>红萌网-修改问题类别</title>
<s:head/>
</head>
<body>
  <s:form theme="xhtml" method="post" name="/mred/question_types"  action="update_question_types">
     <s:select name="questionTypes.questionType.id" list="parents"  listKey="id" listValue="name"
	      cssClass="redInput" value="%{questionTypes.questionType.id}" label="一级类别">  
	  </s:select>
	  <s:hidden name="questionTypes.id" value="%{questionTypes.id}"/>

	  <s:textfield name="questionTypes.name" label="类别名称" required="true" cssClass="redInput" value="%{questionTypes.name}"></s:textfield>

      <s:select name="questionTypes.sorts" list="%{{0,1,2,3,4,5,6,7,8,9}}" value="%{questionTypes.sorts}" cssClass="redInput"></s:select>
	  <s:submit value="修改" cssClass="redButton"></s:submit>
  </s:form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=GB18030" pageEncoding="GB18030"%>
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
<title>提问问题</title>
<style type="text/css">
form{ margin:50px;}
form br{display: none;}
</style>
</head>
<body>
 <%@include file="top.jsp" %>
   <s:form theme="xhtml" action="askSave_question" namespace="/red/question" method="post">
    <s:doubleselect 
			    list="doubleSelectNodes" 
			    listKey="value" 
			    listValue="name"
			    doubleList="subNodes"
				doubleListKey="value"
				doubleListValue="name"
				doubleName="question.questionType.id"
				doubleValue="question.questionType.id"
			    cssClass="redInput"
			    label="选择分类"
			    />
      <s:textfield name="question.title" cssClass="redInput" label="标题" cssStyle="width:300px;"></s:textfield>
    
      <s:textarea name="question.descs" cssStyle="border:1px #CCCCCC solid; width:400px; height:160px; font-size:12px;" label="问题内容" cols="30" rows="15"></s:textarea>
      <s:submit value="提问" cssClass="redButton"></s:submit>
   
   </s:form>
</body>
</html>
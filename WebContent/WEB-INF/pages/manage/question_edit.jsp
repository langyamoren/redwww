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
<title>�޸�����</title>
</head>
<body>
<s:form theme="xhtml" action="question_updateSave" namespace="/mred/question">
   <s:hidden name="question.id"></s:hidden>
   <s:doubleselect 
			    list="doubleSelectNodes" 
			    listKey="value" 
			    listValue="name"
			    doubleList="subNodes"
				doubleListKey="value"
				doubleListValue="name"
				doubleName="question.questionType.id"
				doubleId="column2"
				name="column1"
				id="column1"
				value="question.questionType.questionType.id"
				doubleValue="question.questionType.id"
			    cssClass="redInput"
			    label="ѡ����ࣺ"
			    />

<s:textfield name="question.title" cssClass="redInput" value="%{question.title}" label="����"></s:textfield>
<s:textarea name="question.content" cssClass="redInput" value="%{question.content}" rows="8" cols="35" label="����"></s:textarea>
<s:select list="%{#{0:'���Ƽ�',1:'�Ƽ�'}}" name="question.ispop" label="�Ƿ��Ƽ�"  cssClass="redInput"></s:select>
<s:submit value="�޸�����"></s:submit>
</s:form>
</body>
</html>
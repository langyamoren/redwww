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
<title>红萌网-问题类别管理</title>
<link href="res/css/global.css" rel="stylesheet" type="text/css" />
<link href="res/dialog/dialog.css" rel="stylesheet" type="text/css" />
<script language="javascript" src="res/js/jquery-1.5.1.min.js"></script>
<script type="text/javascript" src="res/dialog/dialog.js"></script>
<style type="text/css">
  #add{ width:800px; height:140px; margin:0 auto; position:relative;}
  #add #frame{ width:700px; height:70px; border:1px #CCCCCC solid; position:absolute; left:20px; top:27px; z-index:1;}
  #add #tit{background-color:#FFFFFF;padding:0px 5px;position:absolute;left:51px;top:19px;width: 49px;height: 16px;z-index:999;}
  #add #frame form{ margin:20px 10px 5px 20px; width:700px; height:50px; position:relative;}
  #add #frame form .typename ,#add #frame select{ border:1px #CCCCCC solid; line-height:25px;}

  #type_list #headtit{ color:#FF3300; font-size:14px; font-weight:bold; margin-left:20px;}
  #type_list table{ border-collapse:collapse; margin-left:20px;}
  #type_list table tr{ height:25px;}
   #type_list table td{ border:1px #CCCCCC solid;}

</style>
<!-- 
<script src="../js/jquery-1.4.2.min.js"></script>
 -->
<script language="javascript">
$(function(){
   $("#type_list dl form :button").click(function(){
      var id=$(this).prev().prev().val();
      window.location="delete_types?at.id="+id;
   });


});

</script>
<s:head/>
</head>
<body>
<div id="add">
     <div id="tit" style="left: 51px; width: 75px;">增加分类</div>
     <div id="frame" style="top: 27px; height: 60px;">
	   <s:form action="add_question_types" namespace="/mred/question_types" method="post">
	      <s:token name="redtoken"></s:token>
	      <s:select name="questionTypes.questionType.id" list="parents"  listKey="id" listValue="name"
	     headerKey="0" headerValue="无上级分类"  cssClass="redInput"></s:select>
	      <s:textfield name="questionTypes.name" label="类别名称" required="true" cssClass="redInput"></s:textfield>
	      <s:submit value="增加" cssClass="redButton"></s:submit>
	   </s:form>
   </div>
</div>

 <!--列表-->
 <div id="type_list">
 
 <table border="0" cellpadding="0" cellspacing="0">
   <tr>
     <th>ID</th>
     <th colspan="2">类别名称</th>
     <th>排序</th>
     <th>操作</th>
   </tr>

  <s:iterator value="allTypes" status="state">
   <s:form method="post" namespace="/mred/question_types">
    <s:token name="questiontypetoken"></s:token>
   <tr
   <s:if test="null==questionType">
   bgcolor="#EEEEEE"
   </s:if>
   >
     <td width="60" align="center"><s:property value="id"/></td>
     <td width="120" align="center">
     <s:hidden name="questionTypes.id" value="%{id}"/>
    <s:if test="null==questionType">
     <s:property value="name"/>
    </s:if>
     
     </td>
     <td width="120" align="center">
         <s:if test="questionType.id!=null">
     <s:property value="name"/>
    </s:if>
     </td>
     <td width="50" align="center" valign="middle"><s:property value="sorts"/></td>
     <td width="100" align="center" valign="middle">
	     <s:component>
		 <s:submit action="edit_question_types" value="修改"></s:submit>
		 <s:submit action="delete_question_types" value="删除"></s:submit>
	    </s:component>     </td>
   </tr>
   </s:form>
   </s:iterator>
  
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
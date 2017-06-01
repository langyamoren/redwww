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
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>发布文章</title>
<link href="res/css/global.css" rel="stylesheet" type="text/css" />
<link href="res/dialog/dialog.css" rel="stylesheet" type="text/css" />
<script language="javascript" src="res/js/jquery-1.5.1.min.js"></script>
<script type="text/javascript" src="res/dialog/dialog.js"></script>
<script type="text/javascript" charset="utf-8" src="res/editor/kindeditor.js"></script>
<script type="text/javascript">
KE.show({
    id : 'contents',
    imageUploadJson : '../../../../mred/ajax/editorUploadFile',
    allowFileManager : false
});
 </script>
 <style type="text/css">

</style>
</head>
<body>
<h1 style="font-size:16px; margin:10px;">发布文章</h1>

<s:form action="addSave_article" namespace="/mred/article" method="post">

<table width="800" border="0" align="center" cellpadding="0" cellspacing="0" id="showC">
  <tr>
    <td width="83" height="32" align="right">标题：</td>
    <td width="431" height="32">
    <s:token name="article_add_token"></s:token>
    <s:textfield name="article.title" cssClass="redInput" cssStyle="width:400px;"/>
    <s:token name="redcourse"></s:token>
    </td>
    <td width="92" height="32" align="right" valign="middle">排序：</td>
    <td width="194" height="32">
    
    <s:select list="%{{9,8,7,6,5,4,3,2,1,0}}" name="article.sorts"  cssClass="redInput"></s:select>
    
    &nbsp;&nbsp;
    <label>描红</label>
    <s:select list="%{#{0:'否',1:'是'}}" name="article.isred" cssClass="redInput"></s:select>
</td>
  </tr>
  <tr>
    <td width="83" height="32" align="right">类别：</td>
   
    <td height="32">
    
    <table width="389" height="32" border="0" align="left" cellpadding="0" cellspacing="0">
      <tr>
        <td width="131" align="left" valign="middle">
        
        <s:select name="article.articleType.id" list="articleType"  cssClass="redInput" listKey="id" listValue="name" headerKey="0" headerValue="请选择分类"/>
        
        </td>
        <td width="48" align="right" valign="middle"><label>作者:</label></td>
        <td width="210" align="left" valign="middle">
        <label></label>
        <s:hidden name="article.member.id" value="1"></s:hidden>
        <s:textfield name="article.author" cssClass="redInput" cssStyle="width:60px;" value=" "></s:textfield></td>
      </tr>
    </table>
    
    </td>
    <td height="32" align="right" valign="middle">来源：</td>
    <td height="32">
    <s:select name="article.fromdesc" cssClass="redInput" cssStyle="width:145px;" list="{'本站转载','原创'}"></s:select>  
    </td>
  </tr>
  <tr>
    <td width="83" height="32" align="right">关键字：</td>
    <td height="32">
    
    <s:textfield name="article.keyword" cssClass="redInput" cssStyle="width:240px;"></s:textfield>
    <span>多个关键字用英文空格隔开</span>
    
    </td>
    <td height="32" align="right" valign="middle">来源地址：</td>
    <td height="32">
    
    <s:textfield name="article.fromaddr" cssClass="redInput" cssStyle="width:145px;"></s:textfield>
    
    </td>
  </tr>

  <tr>
    <td height="300" colspan="4" align="center" valign="top">
      <s:textarea id="contents" name="article.content" cssStyle="width:760px;height:300px;"></s:textarea></td>
  </tr>
  <tr>
    <td height="30" align="center" valign="middle">摘要：</td>
    <td height="30" colspan="3"></td>
  </tr>
  <tr>
    <td height="50" colspan="4" align="center" valign="middle">
      
      <s:textarea name="article.abstracts" cssClass="redInput" cssStyle="width:760px;height:40px;"></s:textarea></td>
  </tr>
  <tr>
    <td align="right">&nbsp;</td>
    <td colspan="3"><s:submit value="发布文章" cssClass="redButton"></s:submit></td>
  </tr>
</table>
</s:form>
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
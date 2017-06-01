<%@ page contentType="text/html; charset=gbk" language="java" import="java.sql.*" errorPage="" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>"/>

<meta http-equiv="Content-Type" content="text/html; charset=gbk" />
<title>焦点广告</title>
<link href="res/css/global.css" rel="stylesheet" type="text/css" />
<link href="res/dialog/dialog.css" rel="stylesheet" type="text/css" />
<script language="javascript" src="res/js/jquery-1.5.1.min.js"></script>
<script type="text/javascript" src="res/dialog/dialog.js"></script>
<script type="text/javascript" src="res/uploadify/swfobject.js"></script>
<style type="text/css">
.addpic{ font-size:12px; font-family:"宋体";}
.piclist{ border-collapse:collapse;}
.piclist th{ height:25px; background-color:#CC0000; color:#FFFFFF; font-weight:bold; text-align:center; line-height:25px;}
.piclist td{ height:100px; border:1px #CCCCCC solid; padding:5px; font-size:12px; font-family:"宋体";}
.myinput{ height:25px; line-height:25px; border:1px #CCCCCC solid;}
.mysub{ height:25px; line-height:25px; font-weight:bold; color:#FFFFFF; background-color:#CC0000; border:0px;}
</style>
</head>

<body>
<form method="post" action="mred/focus/focus_add" enctype="multipart/form-data">
<table width="760"  border="0" align="center" cellpadding="3" cellspacing="0" class="addpic">
  <tr>
    <td width="40" height="30" align="right" valign="middle">标题：</td>
    <td width="169" align="left" valign="middle">
    <s:token name="focustoken"></s:token>
    <input name="focus.title" type="text" class="myinput"  style="width:160px;"/></td>
    <td width="40" align="left" valign="middle">URL:</td>
    <td width="169" align="left" valign="middle">
    <input name="focus.url" type="text" class="myinput"  style="width:160px;"/></td>
    <td width="223" align="left" valign="middle">
    <input name="pic" id="pic" type="file"  class="myinput" /></td>
    <td width="83" align="left" valign="middle"><input name="Submit" type="submit" class="mysub" value="增加" /></td>
  </tr>
</table>
</form>

<table width="760" border="0" align="center" cellpadding="0" cellspacing="0" class="piclist">
  <tr>
    <th width="42">序号</th>
    <th width="219">图片</th>
    <th width="288">标题/URL</th>
    <th width="82">排序</th>
    <th width="129">操作</th>
  </tr>
  <s:iterator value="focusList"  status="state">
	  <s:form method="post" theme="simple" namespace="/mred/focus" enctype="multipart/form-data">
	  <tr>
	    <td align="center" valign="middle">
         <s:property value="#state.index+1"/>
        </td>
	    <td align="center" valign="middle"><img src="res/upres/focus/<s:property value="picture"/>" width="210" height="90" alt="<s:property value="title"/>"  style="background-color: #CC0000" /></td>
	    <td align="left" valign="middle">
		    <p>
		      标题：<input name="focus.title" type="text" class="myinput"  style="width:200px;" 
		      value="<s:property value="title"/>"/>
		      <s:token name="updateFocusToken"></s:token>
		      <input name="focus.id" type="hidden" class="myinput"  style="width:200px;" 
		      value="<s:property value="id"/>"/>
			</p>
	        <p>
	        URL:
	        <input name="focus.url" id="url" type="text" class="myinput"  style="width:200px;"
	          value="<s:property value="url"/>"/>
			</p>
			<p>
			  <s:file name="pic" cssClass="myinput"></s:file>
			</p>
	    </td>
	    <td><label>
	        
	      <input name="focus.sorts" type="text" class="myinput" style="width:60px;"
	      value="<s:property value="sorts"/>" />
	    </label></td>
	    <td><label>
	       <s:submit  value="修改"  action="focus_update" cssClass="mysub"></s:submit>
	      
	    </label>
	      <label>
	      <s:submit action="focus_delete" cssClass="mysub"  value="删除" />
	      </label>
	      <label></label></td>
		  </tr>
		  </s:form>
  
  </s:iterator>
</table>
<h4 align="center">注意：235*160</h4>
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

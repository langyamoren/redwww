<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@taglib prefix="s" uri="/struts-tags" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <base href="<%=basePath%>"/>
   
    <title>红萌网后台管理入口</title>
	<meta http-equiv="Content-Type" content="text/html; charset=GB18030" />
	<link href="res/css/global.css" rel="stylesheet" type="text/css" />
	<link href="res/dialog/dialog.css" rel="stylesheet" type="text/css" />
<script language="javascript" src="res/js/jquery-1.5.1.min.js"></script>
<script type="text/javascript" src="res/dialog/dialog.js"></script>
	<style type="text/css">
	body{text-align: center;}
	#content_main{
      text-align:left;
      margin:100px auto;
      width:428px;height:274px;
	}
	#content_main form{
	width:428px;height:274px; font-size:14px;
	font-family:"宋体";
	position:relative;
	
	background-image:url(res/image/login_back.jpg);
	}
	
	#label_user{ position:absolute; left:57px; top:107px;}
	#label_pwd{ position:absolute; left:58px; top:149px;}
	#label_rand{ position:absolute; left:61px; top:225px;}
	#label_refresh{ position:absolute; left:169px; top:190px;}
	.myinput{ height:30px; line-height:30px; border:1px #CCCCCC solid; width:200px;}
	
	#form_name{position:absolute; left:159px; top:95px;}
	#form_pwd{position:absolute; left:158px; top:139px;}
	#form_rand{position:absolute; left:116px; top:220px; border:1px #CCCCCC solid; width:60px;}
	#from_sub{position:absolute; left:267px; top:217px; width:80px; height:30px; font-weight:bold;
	background-color:#CC0000; color:#FFFFFF; line-height:30px; text-align:center;}
	#rand_img{ position:absolute; left:61px; top:179px; cursor: pointer;}
	</style>

  </head>
  
  <body>
 
    <div id="content_main">
	  <form action="mred/admin/admin_login" method="post">
	     <label id="label_user">用户名/email:</label>
		 <label id="label_pwd">密码：</label>
		 <label id="label_rand">验证码：</label>
		 <label id="label_refresh">看不清，请点击图片</label>
		 <img src="mred/ajax/randImg"  id="rand_img" border="0" onclick="this.src='mred/ajax/randImg?ran=random();'"/>
		 <input type="text" name="admin.adminName" id="form_name" class="myinput"/>
		 <input type="password" name="admin.adminPwd" id="form_pwd" class="myinput"/>
		 <input type="text" name="rand" id="form_rand" style="height:24px; line-height:24px;"/>
		 <input type="submit"  value="登陆" id="from_sub"/>
	  </form>
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

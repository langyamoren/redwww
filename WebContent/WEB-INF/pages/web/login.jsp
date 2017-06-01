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
<title>用户登陆</title>
<style type="text/css">
   #login{ width:600px; padding:30px 0px 10px 20px;}
   #login h1{ font-size:16px; border-bottom:1px #CCCCCC solid; line-height:30px;}
   #login .gene_line{ height:40px; line-height:40px; padding-left:10px;}
   #login .gene_line label{ width:100px; display:block; float:left;}
   .forgotpwd{ line-height: 30px; color:#000000;text-decoration:none;}
   .forgotpwd:hover{color:#CC0000;}
</style>
</head>

<body>
<div id="login">
   <form action="red/checkLogin" method="post">
   <h1>&nbsp;用户登陆</h1>
   <p class="gene_line">
	   <label>用户名/Email:</label>
	   <input type="text" name="userName" class="redInput" />
	   <span><font color="#00CC00">请用您常用的email注册</font></span>
   </p>
    <p class="gene_line">
	   <label>密码:</label>
	   <input type="password" name="password" class="redInput" />
	   <span><font color="#00CC00">至少6位数字和字母</font></span>
   </p>  
   <p class="gene_line">
	   <label>验证码:</label>
	   <input type="text" name="rand" class="redInput"  style="width:60px;"/>
	   <img src="mred/ajax/randImg"  id="rand_img" border="0" style="cursor: pointer;" onclick="this.src='mred/ajax/randImg?ran='+Math.random();"/>
	   <span><font color="#00CC00">如果看不清，请点击图片,换一张</font></span>
   </p>
   <input type="submit" style="margin:10px 10px 10px 20px; width:80px; height:25px; line-height:25px; text-align:center; cursor:pointer;" class="redButton" value="登陆"/>
    <a href="red/forgot_passwd" class="forgotpwd">如果忘了密码，请点击这里</a>
  <p style="line-height:30px; border-bottom:1px #CCCCCC solid; margin-left:10px;"></p>
  <p>
  <h3 style=" line-height:35px; font-size:14px;"> 如果您还不是本站会员吗？</h3>
  <a href="red/regist" class="redButton" style="text-decoration:none; width:60px; text-align:center; width:80px; text-align:center; line-height:25px; height:25px; display:block;">现在注册</a>
  </p>
   </form>
</div>
</body>
</html>
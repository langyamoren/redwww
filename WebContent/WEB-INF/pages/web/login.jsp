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
<title>�û���½</title>
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
   <h1>&nbsp;�û���½</h1>
   <p class="gene_line">
	   <label>�û���/Email:</label>
	   <input type="text" name="userName" class="redInput" />
	   <span><font color="#00CC00">���������õ�emailע��</font></span>
   </p>
    <p class="gene_line">
	   <label>����:</label>
	   <input type="password" name="password" class="redInput" />
	   <span><font color="#00CC00">����6λ���ֺ���ĸ</font></span>
   </p>  
   <p class="gene_line">
	   <label>��֤��:</label>
	   <input type="text" name="rand" class="redInput"  style="width:60px;"/>
	   <img src="mred/ajax/randImg"  id="rand_img" border="0" style="cursor: pointer;" onclick="this.src='mred/ajax/randImg?ran='+Math.random();"/>
	   <span><font color="#00CC00">��������壬����ͼƬ,��һ��</font></span>
   </p>
   <input type="submit" style="margin:10px 10px 10px 20px; width:80px; height:25px; line-height:25px; text-align:center; cursor:pointer;" class="redButton" value="��½"/>
    <a href="red/forgot_passwd" class="forgotpwd">����������룬��������</a>
  <p style="line-height:30px; border-bottom:1px #CCCCCC solid; margin-left:10px;"></p>
  <p>
  <h3 style=" line-height:35px; font-size:14px;"> ����������Ǳ�վ��Ա��</h3>
  <a href="red/regist" class="redButton" style="text-decoration:none; width:60px; text-align:center; width:80px; text-align:center; line-height:25px; height:25px; display:block;">����ע��</a>
  </p>
   </form>
</div>
</body>
</html>
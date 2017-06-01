<%@page language="java" import="com.red.util.HtmlRegexpUtil" contentType="text/html; charset=GB18030" pageEncoding="GB18030"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>"/>
<title>’“ªÿ√‹¬Î</title>
<link href="res/css/global.css" rel="stylesheet" type="text/css"/>
<style type="text/css">
#container{
width:780px;
margin:5 auto;
}
#tit_top #redBlock{ width:15px; height:30px; float:left; background-color:#CC0000;}
#tit_top h1{ float:left; width:150px; height:30px; line-height:30px; font-size:16px; margin-left:5px;}
#tit_top #membr_info{ height:30px; }
#tit_top #member_info p{ float:left; margin:0 10px; line-height:30px;}
#space_nav{ margin:10px auto; height:18px;}
#space_nav ul{list-style:none;}
#space_nav ul li{ float:left;}
#space_nav ul li a{ display:block; width:100px; height:16px; border-right:6px #CC0000 solid; color:#333333; text-decoration:none; font-size:14px; font-weight:bold; line-height:16px; text-align:center;}
#space_nav ul li a:hover{text-decoration:underline; color:#CC0000;}


#passwd_container table{ border-collapse:collapse;}
#passwd_container table th{ background-color:#CC0000; font-weight:bold; font-size:14px; color:#FFFFFF; line-height:30px;}
#passwd_container table td{ line-height:24px; border:1px #CCCCCC solid; padding: 6px;}
</style>
</head>
<body>
<div id="container">
	<div id="passwd_container">
	<s:form method="post" action="reset_passwd" namespace="/red">
	<table width="571" border="0" align="center" cellpadding="0" cellspacing="0">
	   <tr>
		 <th colspan="2" align="left" valign="middle">’“ªÿ√‹¬Î£∫</th>
	   </tr>
	   <tr>
		 <td width="144" align="right" valign="middle">◊¢≤·E-mail£∫</td>
		 <td width="427">
		 <s:token name="member_forgot_password_token"></s:token>
		 <s:textfield name="member.email"  cssClass="redInput"/></td>
	   </tr>
	   <tr>
		 <td align="right" valign="middle">–’√˚£∫</td>
		 <td><s:textfield name="member.name"  cssClass="redInput"/></td>
	   </tr>
	   <tr>
		 <td align="right" valign="middle">QQ£∫</td>
		 <td><s:textfield name="member.qq"  cssClass="redInput"/></td>
	   </tr>
	   <tr>
		 <td align="right" valign="middle"> ÷ª˙£∫</td>
		 <td><s:textfield name="member.cellphone" cssClass="redInput"/></td>
	   </tr>
	   <tr>
		 <td colspan="2" align="center" valign="middle"><s:submit value="’“ªÿ√‹¬Î" cssClass="redButton"/></td>
		</tr>
	 </table>
	 </s:form>
	</div>
</div>

</body>
</html>
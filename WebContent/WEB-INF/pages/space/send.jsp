<%@ page contentType="text/html; charset=GB18030" language="java"%>
<%@taglib prefix="s" uri="/struts-tags" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>">
<title>使用快钱支付</title>
<meta http-equiv="content-type" content="text/html; charset=GB18030" >
<link href="res/css/global.css" rel="stylesheet" type="text/css">
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

</style>
</head>
	
<BODY>
<div id="container">
    <%@include file="top.jsp" %>
	<div align="pay_center">
		<table style="margin:20px; font-size:14px;" width="384" border="0" align="center" cellpadding="5" cellspacing="1" bgcolor="#CCCCCC">
			<tr bgcolor="#FFFFFF">
				<td width="108" height="30" align="right">支付方式:</td>
				<td width="261" height="30" align="left" >快钱[99bill]</td>
			</tr>
			<tr>
				<td height="30" align="right" bgcolor="#FFFFFF" >订单编号:</td>
				<td height="30" align="left" bgcolor="#FFFFFF" ><s:property value="orderId"/></td>
			</tr>
			<tr>
				<td height="30" align="right" bgcolor="#FFFFFF">订单金额:</td>
				<td height="30" align="left" bgcolor="#FFFFFF"><s:property value="orderAmount/100"/>元</td>
			</tr>
			<tr>
				<td height="30" align="right" bgcolor="#FFFFFF">支付人Email:</td>
				<td height="30" align="left" bgcolor="#FFFFFF"><s:property value="payerName"/></td>
			</tr>
			<tr>
				<td height="30" align="right" bgcolor="#FFFFFF">支付人:</td>
				<td height="30" align="left" bgcolor="#FFFFFF"><s:property value="ext2"/></td>
			</tr>
	  </table>
	</div>

	<div align="center">
		<form name="kqPay" action="https://www.99bill.com/gateway/recvMerchantInfoAction.htm" method="post">
			<s:hidden  name="inputCharset" ></s:hidden>
			<s:hidden  name="bgUrl" ></s:hidden>
			<s:hidden  name="version" ></s:hidden>
			<s:hidden  name="language" ></s:hidden>
			<s:hidden  name="signType" ></s:hidden>
			<s:hidden  name="signMsg" ></s:hidden>
			<s:hidden  name="merchantAcctId" ></s:hidden>
			<s:hidden  name="payerName" ></s:hidden>
			<s:hidden  name="payerContactType" ></s:hidden>
			<s:hidden  name="payerContact" ></s:hidden>
			<s:hidden  name="orderId" ></s:hidden>
			<s:hidden  name="orderAmount" ></s:hidden>
			<s:hidden  name="orderTime" ></s:hidden>
			<s:hidden  name="productName" ></s:hidden>
			<s:hidden  name="productNum" ></s:hidden>
			<s:hidden  name="productId" ></s:hidden>
			<s:hidden  name="productDesc" ></s:hidden>
			<s:hidden  name="ext1" ></s:hidden>
			<s:hidden  name="ext2" ></s:hidden>
			<s:hidden  name="payType" ></s:hidden>
			<s:hidden  name="redoFlag" ></s:hidden>
			<s:hidden  name="pid" ></s:hidden>
			<input type="image" src="res/images/web/paybill.jpg"/>
		</form>		
	</div>
</div>
</BODY>
</HTML>
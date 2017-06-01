<%@page language="java" import="com.red.util.HtmlRegexpUtil" contentType="text/html; charset=GB18030" pageEncoding="GB18030"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@taglib uri="http://jsptags.com/tags/navigation/pager" prefix="pg" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>"/>
<title>在线充值</title>
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

#container #bill_container{margin:10px auto; width:300px;}
#container #bill_container ul  {list-style:none;}
#container #bill_container ul li{height:24px;line-height:24px;}
</style>
<script type="text/javascript">
//$(function(){
	
	/*
	$("#99bill").click(function(){
		var amount=$("#amount_money").val();
		if(""==amount)
			{
			alert("充值金额不能为空");
			}else
			{
			window.location='<%=path%>/red/send_bill?orderAmount='+amount;
			}
	});
	*/
	/*
	$("#alipay").click(function(){
		var payt=$("input:radio:checked").val();
		if(payt==1)
			{
			     //支付宝
					var amount=$("#amount_money").val();
					var re = /^[\d]+$/ 
					   if(re.test(amount))
						{ 
					     window.location='<%=path%>/red/topay_alipay?orderAmount='+amount;
						}else
							{
							alert("金额一定为整数！");
							}
			}else if(0==payt)
				{
				//快钱
				var amount=$("#amount_money").val();
					var re = /^[\d]+$/ 
					   if(re.test(amount))
						{
						   alert("快钱不稳定，暂时不可用，请选择支付宝支付");
						   //window.location='<%=path%>/red/send_bill?orderAmount='+amount;
						}else
							{
							alert("金额一定为整数！");
							}
				
				}else
					{
					 alert("请选择支付方式");
					}
	});

	*/
//});

</script>
</head>
<body>
<div id="container">
    <%@include file="top.jsp" %>
	<div id="bill_container">
		<h1><img src="res/image/onlinepay.jpg"/></h1>
	      <form action="red/topay_alipay" method="post">
		  <ul>
		      <li><font color="red"><b>注意：</b>只能是整数,如:120，不能为小数</font></li>
			  <li >充值金额：<input type="text" id="amount_money"  name="orderAmount" class="redInput"/>元</li>
			 <!-- 
			 <li><img id="99bill" src="res/image/99bill.jpg" style="cursor:pointer;"/></li>
			  <li style=" height:80px;"><input type="radio"  value="0"  name="ptype" style="margin:10px;" /><img src="res/image/99bill.jpg"/></li>
			 -->
			  <li style=" height:80px;"><input type="radio"  value="1"  name="ptype"  style="margin:10px;" checked="checked"/><img src="res/image/alipay.jpg"/></li>
			 <li><input type="image"  id="alipay"  src="res/image/99bill_next.jpg" style="cursor:pointer;"/></li>  
			  
		  </ul>
		  </form>
	</div>
</div>
</body>
</html>
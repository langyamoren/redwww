<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
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
<meta http-equiv="Content-Type" content="text/html; charset=GB18030"/>
<title>兑现管理</title>
<style type="text/css">
#mem_conatinaer{ margin-top:30px;}
#mem_conatinaer table{ border-collapse:collapse;}
#mem_conatinaer table th{ background-color:#CC0000; color:#FFFFFF; font-size:12px; line-height:30px;}
#mem_conatinaer table td{ line-height:30px; border:1px #CCCCCC dashed;}
#mem_conatinaer table td.tit{ background-color:#F5F5F5; font-weight:bold;}
#mem_conatinaer table td ul{ list-style:none; float:right;  margin:0; padding:0; border:0;}
#mem_conatinaer table td ul li{ float:left;}
#mem_conatinaer table td ul li a{ display:block; width:60px; height:24px; background-color:#CC0000; color:#FFFFFF; font-weight:bold; margin-left:10px; text-align:center; line-height:24px; text-decoration:none;}
.bg1{background-color:#EDEFEF;}
</style>
</head>
<body>
<div id="mem_conatinaer">
  <table width="750" border="0" align="center" cellpadding="0" cellspacing="0">
    <tr>
      <th width="47" align="center" valign="middle">序号</th>
      <th width="75" align="center" valign="middle">会员名</th>
      <th width="168" align="center" valign="middle">Email</th>
      <th width="68" align="center" valign="middle">提现金额</th>
      <th width="62" align="center" valign="middle">余额</th>
      <th width="183" align="center" valign="middle">日期</th>
      <th width="60" align="center" valign="middle">积分：</th>
      <th width="87" align="center" valign="middle">管理</th>
    </tr>
    <s:iterator value="list" status="stat">
    <s:form action="update_duixian" namespace="/mred" method="post">
    <tr
     <s:if test="#stat.odd">
      class="bg1"
      </s:if>
    >
      <td align="center" valign="middle"><s:property value="#stat.index+1"/></td>
      <td align="center" valign="middle"><s:property value="member.name"/></td>
      <td align="center" valign="middle"><s:property value="member.Email"/></td>
      <td align="center" valign="middle"><s:property value="money"/></td>
      <td align="center" valign="middle"><s:property value="member.balance"/></td>
      <td align="center" valign="middle"><s:date name="dates" format="yyyy-MM-dd HH:mm:ss"></s:date></td>
	  <td align="center" valign="middle"><s:property value="member.integal"/></td>
      <td align="center" valign="middle">
      <s:hidden name="finance.id" value="%{id}"></s:hidden>
      <s:submit value="批准兑现" cssClass="redButton"/></td>
     
    </tr>
    </s:form>
    </s:iterator>
</table>
</div>
</body>
</html>
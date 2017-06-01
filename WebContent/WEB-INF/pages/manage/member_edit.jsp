<%@ page language="java" contentType="text/html; charset=GB18030" pageEncoding="GB18030"%>
<%@taglib prefix="s" uri="/struts-tags" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>"/> 
<meta http-equiv="Content-Type" content="text/html; charset=GB18030"/>
<title>会员管理</title>
<link href="res/css/global.css" rel="stylesheet" type="text/css" />
<link href="res/dialog/dialog.css" rel="stylesheet" type="text/css" />
<script language="javascript" src="res/js/jquery-1.5.1.min.js"></script>
<script type="text/javascript" src="res/dialog/dialog.js"></script>
<style type="text/css">
#mem_conatinaer{ margin-top:30px;}
#mem_conatinaer table{ border-collapse:collapse;}
#mem_conatinaer table th{ background-color:#CC0000; color:#FFFFFF; font-size:12px; line-height:30px;}
#mem_conatinaer table td{ line-height:30px; border:1px #CCCCCC dashed;}
#mem_conatinaer table td.tit{ background-color:#F5F5F5; font-weight:bold;}
#mem_conatinaer table td ul{ list-style:none; float:right;  margin:0; padding:0; border:0;}
#mem_conatinaer table td ul li{ float:left;}
#mem_conatinaer table td ul li a{ display:block; width:60px; height:24px; background-color:#CC0000; color:#FFFFFF; font-weight:bold; margin-left:10px; text-align:center; line-height:24px; text-decoration:none;}
</style>
</head>
<body>
<div id="mem_conatinaer">
<s:form namespace="/mred/member" action="update_member" method="post">
  <table width="750" border="0" align="center" cellpadding="0" cellspacing="0">
    <tr>
      <td width="81" align="right" valign="middle" class="tit">会员名：</td>
      <td width="166"><s:textfield name="member.name" cssClass="redInput" cssStyle="width:100px;" disabled="true"></s:textfield></td>
      <td width="67" align="right" valign="middle"  class="tit">Email：</td>
      <td width="121"><s:textfield name="member.email" cssClass="redInput" cssStyle="width:100px;" disabled="true"></s:textfield></td>
      <td width="70" align="right" valign="middle"  class="tit">QQ：</td>
      <td width="90"><s:textfield name="member.qq" cssClass="redInput" cssStyle="width:100px;" disabled="true"></s:textfield></td>
      <td width="73" align="right" valign="middle"  class="tit">积分：</td>
      <td width="82"><s:textfield name="member.integal" cssClass="redInput" cssStyle="width:100px;"></s:textfield></td>
    </tr>
    <tr>
      <td align="right" valign="middle"  class="tit">级别：</td>
      <td>
        <s:select list="levelList" name="member.memberlevel.id" listKey="id" listValue="levelName"  cssClass="redInput"></s:select>      </td>
      <td align="right" valign="middle"  class="tit">日期：</td>
      <td><s:date name="member.dates" format="yyyy-MM-dd HH:mm:ss"></s:date></td>
      <td align="right" valign="middle"  class="tit" >手机：</td>
      <td><s:textfield name="member.cellphone" cssClass="redInput" cssStyle="width:100px;" disabled="true"></s:textfield></td>
      <td align="right" valign="middle"  class="tit">余额：</td>
      <td><s:textfield name="member.balance" cssClass="redInput" cssStyle="width:100px;"></s:textfield></td>
    </tr>
    <tr>
      <td align="right" valign="middle"  class="tit">怅号类型：</td>
      <td><s:if test="member.acountType==0">快钱</s:if><s:else>支付宝</s:else></td>
      <td align="right" valign="middle"  class="tit">帐号：</td>
      <td><s:textfield name="member.acount" cssClass="redInput" cssStyle="width:100px;" disabled="true"></s:textfield></td>
      <td align="right" valign="middle"  class="tit">推荐人：</td>
      <td><s:property value="member.member.name"/></td>
      <td align="right" valign="middle"  class="tit">推荐码：</td>
      <td><s:property value="@com.red.util.RcomeRandCode@parseToString(member.id)"/></td>
    </tr>
    <tr>
     <td align="right" valign="middle"  class="tit">密码：</td>
      <td><s:textfield name="member.password" value="" cssClass="redInput"></s:textfield></td>
	  <td align="right" valign="middle"  class="tit">锁定:</td>
	  <td><s:select name="member.islock" list="#{0:'不锁',1:'锁定'}"  cssClass="redInput"></s:select></td>
      <td align="right" valign="middle"  class="tit">权限：</td>
      <td align="right" valign="middle"  class="tit"><s:textfield name="member.privileges" cssClass="redInput"  cssStyle="width:80px;"></s:textfield></td>
      <td colspan="3">
       <s:hidden name="member.id"></s:hidden>
	   <s:submit value="返回" action="view_member" cssClass="redButton"></s:submit>&nbsp;&nbsp;
	   <s:submit value="修改" action="update_member" cssClass="redButton"></s:submit>
      </td>
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

</div>
</body>
</html>
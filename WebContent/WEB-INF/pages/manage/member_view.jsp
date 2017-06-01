<%@ page language="java" contentType="text/html; charset=GB18030" pageEncoding="GB18030"%>
<%@page import="com.red.util.RcomeRandCode" %>
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
<title>��Ա����</title>
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
  <table width="750" border="0" align="center" cellpadding="0" cellspacing="0">
    <tr>
      <td width="79" align="right" valign="middle" class="tit">��Ա����</td>
      <td width="168"><s:property value="member.name"/></td>
      <td width="63" align="right" valign="middle"  class="tit">Email��</td>
      <td width="126"><s:property value="member.Email"/></td>
      <td width="63" align="right" valign="middle"  class="tit">QQ��</td>
      <td width="104"><s:property value="member.qq"/></td>
      <td width="60" align="right" valign="middle"  class="tit">���֣�</td>
      <td width="87"><s:property value="member.integal"/></td>
    </tr>
    <tr>
      <td align="right" valign="middle"  class="tit">����</td>
      <td><s:property value="member.memberlevel.levelName"/></td>
      <td align="right" valign="middle"  class="tit">���ڣ�</td>
      <td><s:date name="member.dates" format="yyyy-MM-dd HH:mm:ss"></s:date></td>
      <td align="right" valign="middle"  class="tit">�ֻ���</td>
      <td><s:property value="member.cellphone"/></td>
      <td align="right" valign="middle"  class="tit">��</td>
      <td><s:property value="member.balance"/></td>
    </tr>
    <tr>
      <td align="right" valign="middle"  class="tit">������ͣ�</td>
      <td><s:if test="member.acountType==0">��Ǯ</s:if><s:else>֧����</s:else></td>
      <td align="right" valign="middle"  class="tit">�ʺţ�</td>
      <td><s:property value="member.acount"/></td>
      <td align="right" valign="middle"  class="tit">�Ƽ��ˣ�</td>
      <td><s:property value="member.member.name"/></td>
      <td align="right" valign="middle"  class="tit">�Ƽ��룺</td>
      <td><s:property value="@com.red.util.RcomeRandCode@parseToString(member.id)"/></td>
    </tr>
    <tr>
      <td align="right" valign="middle"  class="tit">Ȩ�ޣ�</td>
      <td><s:property value="member.privileges"/></td>
      <td align="right" valign="middle" colspan="6">
      <ul>
	    <li><a href="mred/member/browseAll_member">����</a></li>
		<li><a href="mred/member/edit_member?member.id=<s:property value="member.id"/>">�޸�</a></li>
		<li><a href="mred/member/recome_member?member.id=<s:property value="member.id"/>"  target="_blank">�Ƽ�</a></li>
		<li><a href="mred/member/finance_member?member.id=<s:property value="member.id"/>"  target="_blank">����</a></li>
	  </ul>
      </td>

    </tr>
    
  </table>
</div>
<!-- ������Ϣ���� -->
<div id="dialogID" style="display:none;">
   <font color="green"><s:actionmessage/></font>
  <font color="red"><s:actionerror/> <s:fielderror/></font>
</div>
  
<s:if test="hasActionMessages()||hasActionErrors()||hasFieldErrors()">
	<script language="javascript">
	dialog("��ܰ��ʾ","id:dialogID","300px","auto","id"); 
	</script>	 
</s:if>
</body>
</html>
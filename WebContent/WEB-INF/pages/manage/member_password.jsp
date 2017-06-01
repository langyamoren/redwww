<%@ page language="java" contentType="text/html; charset=GB18030" pageEncoding="GB18030"%>
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
<title>��Ա�������</title>
<link href="res/css/global.css" rel="stylesheet" type="text/css" />
<link href="res/dialog/dialog.css" rel="stylesheet" type="text/css" />
<script language="javascript" src="res/js/jquery-1.5.1.min.js"></script>
<script type="text/javascript" src="res/dialog/dialog.js"></script>
<style type="text/css">
#mem_conatinaer table{ border-collapse:collapse;}
#mem_conatinaer table th{ background-color:#CC0000; color:#FFFFFF; font-size:12px; line-height:24px;}
#mem_conatinaer table td{ line-height:24px; border:1px #CCCCCC dashed;}
#mem_conatinaer table td a{ color:#333333; text-decoration:none;}
#mem_conatinaer table td a:hover{text-decoration:underline;}
</style>
</head>
<body>
<h2>��Ա�������</h2>
<div id="mem_conatinaer">
<h3 align="center">���»�Ա��������...</h3>
<table width="760" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <th width="45" align="center" valign="middle">���</th>
    <th width="78" align="center" valign="middle">��Ա��</th>
    <th width="140" align="center" valign="middle">Email</th>
    <th width="118" align="center" valign="middle">������</th>
    <th width="101" align="center" valign="middle">����</th>
    <th width="101" align="center" valign="middle">����</th>
    <th width="56" align="center" valign="middle">������</th>
  </tr>
  <s:iterator status="stat" value="passwordList">
  <s:form namespace="/mred/member" method="post" action="sets_password">
  <tr <s:if test="#stat.odd == true"> bgcolor="#EEEEEE"</s:if>>
    <td width="45" align="center" valign="middle"><s:property value="#stat.index+1"/><s:hidden name="password.id" value="%{id}"></s:hidden></td>
    <td width="78" align="center" valign="middle">
    <a href="mred/member/view_member?member.id=<s:property value="member.id"/>">
    <s:property value="member.name"/>
    </a>
    </td>
    <td width="140" align="left" valign="middle"><s:property value="member.Email"/><br/>
    <s:property value="pwdType"/>
    </td>
    <td width="118" align="center" valign="middle"><s:property value="comCode"/></td>
    <td width="101" align="center" valign="middle"><s:textfield name="password.passwd" cssClass="redInput"></s:textfield></td>
    <td width="101" align="center" valign="middle"><s:date name="dates" format="yyyy-MM-dd HH:mm:ss"></s:date></td>
	<td width="56" align="center" valign="middle"><s:submit value="����" cssClass="redButton"/></td>
  </tr>
  </s:form>
  </s:iterator>
  <tr>
    <td colspan="10" align="center" valign="middle">
     <pg:pager
    url="mred/member/browseAll_password"
    items="${totalCount}"
    index="center"
    maxPageItems="30"
    maxIndexPages="10"
    isOffset="<%=true%>"
    export="offset,currentPageNumber=pageNumber"
    scope="page">
			<pg:first>
			  <a href="<%= pageUrl %>">��ҳ</a>			</pg:first>
			
			<pg:prev>
			  <a href="<%= pageUrl %>">��һҳ</a>			</pg:prev>
			<pg:pages>
			   <a href="<%= pageUrl %>"><%= pageNumber %></a>			</pg:pages>
			<pg:next>
			  <a href="<%= pageUrl %>">��һҳ</a>			</pg:next>
			
			<pg:last>
			  <a href="<%= pageUrl %>">���һҳ</a>			</pg:last>
	</pg:pager>
	&nbsp;&nbsp;
	�ܹ�
	<font color="#FF0000">
	<s:property value="pager.offset/pageSize+1"/>
	</font>
	/
	<s:property value="totalCount%pageSize==0?totalCount/pageSize:totalCount/pageSize+1"/>ҳ
	&nbsp;&nbsp;�ܹ�${totalCount}��    </td>
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
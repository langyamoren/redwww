<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@taglib uri="http://jsptags.com/tags/navigation/pager" prefix="pg" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html;charset=GB18030">
<title>������-�γ̹���</title>
<link href="res/css/global.css" rel="stylesheet" type="text/css" />
<link href="res/dialog/dialog.css" rel="stylesheet" type="text/css" />
<script language="javascript" src="res/js/jquery-1.5.1.min.js"></script>
<script type="text/javascript" src="res/dialog/dialog.js"></script>
<style type="text/css">
#courseList{border-collapse:collapse;}
#courseList th{ background-color:#CC0000; color:#FFFFFF;}
#courseList td{border:1px #CCCCCC solid;}
#couseTitle a{font-size:12px; text-decoration:none; color:#333333;}
#couseTitle a:hover{ text-decoration:underline; color:#FF0000;}
.bg1{background-color:#EDEFEF;}
#pageIndex a{ font-size:12px; text-decoration:none; color:#333333; font-weight:bold;}
#pageIndex a:hover{ text-decoration:underline; color:#FF0000;}
#pageIndex a:active{ color:#FF0000; text-decoration:underline;}
</style>
</head>
<body>
<table width="800" height="30" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td width="6">&nbsp;</td>
    <td width="582" align="left" valign="middle"  style="font-size:16px; font-weight:bold;">�γ̹���</td>
    <td width="212" align="left" valign="middle"  style="font-size:16px; font-weight:bold;">
          <s:a action="add_course" namespace="/mred/course" cssClass="redButton">����¿γ�</s:a>
           <s:a action="coursesHtml" namespace="/mred" cssClass="redButton">����</s:a>
    </td>
  </tr>
</table>
<table width="800" border="0" align="center" cellpadding="0" cellspacing="0" id="courseList">
  <tr>
    <th width="50" height="30" align="center" valign="middle">���</th>
    <th width="203" align="center" valign="middle">�γ̱���</th>
    <th width="120" align="center" valign="middle">���</th>
    <th width="50" align="center" valign="middle">�Ƽ�</th>
    <th width="50" align="center" valign="middle">����</th>
    <th width="50" align="center" valign="middle">����</th>
    <th width="112" align="center" valign="middle">����</th>
    <th width="65" align="center" valign="middle">���</th>
    <th width="50" align="center" valign="middle">�޸�</th>
    <th width="50" align="center" valign="middle">ɾ��</th>
  </tr>
<s:iterator value="courseList" status="state">
<s:form namespace="/mred/course" >
  <tr
         <s:if test="#state.odd">
      class="bg1"
      </s:if>
      >
    <td height="30" align="center" valign="middle">
         <s:property value="#state.index+1"/>    </td>
    <td align="left" valign="middle" id="couseTitle">
      <a href="mred/course/list_course?course.id=<s:property value="id"/>"><s:property value="title"/></a>
      <s:hidden value="%{id}" name="course.id"></s:hidden>
    </td>
    <td align="left" valign="middle"><s:property value="courseType.name"/></td>
    <td align="center" valign="middle"><s:property value="isrecom"/></td>
    <td align="center" valign="middle"><s:property value="sorts"/></td>
    <td align="center" valign="middle"><s:property value="islock"/></td>
    <td align="left" valign="middle"><s:date name="dates" format="yyyy-MM-dd"/></td>
    <td align="center" valign="middle"><s:property value="counts"/></td>
    <td align="center" valign="middle"><s:submit action="update_course" value="�޸�" cssClass="redButton"/></td>
    <td align="center" valign="middle"><s:submit action="delete_course" value="ɾ��"  cssClass="redButton"/></td>
  </tr>
</s:form> 
</s:iterator>
  <tr>
    <td height="30" colspan="10" align="center" valign="middle" id="pageIndex">
	<pg:pager
    url="mred/course/browse_course"
    items="${totalCount}"
    index="center"
    maxPageItems="20"
    maxIndexPages="10"
    isOffset="<%=true%>"
    export="offset,currentPageNumber=pageNumber"
    scope="page">
    <pg:param name="course.courseType.id" value="${course.courseType.id}"/>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<pg:first>
			  <a href="<%= pageUrl %>"><nobr>��ҳ</nobr></a>			</pg:first>
			
			<pg:prev>
			  <a href="<%= pageUrl %>"><nobr>��һҳ</nobr></a>			</pg:prev>
			<pg:pages>
			   <a href="<%= pageUrl %>"><%= pageNumber %></a>			</pg:pages>
			<pg:next>
			  <a href="<%= pageUrl %>"><nobr>��һҳ</nobr></a>			</pg:next>
			
			<pg:last>
			  <a href="<%= pageUrl %>"><nobr>���һҳ</nobr></a>			</pg:last>
	</pg:pager>
	&nbsp;&nbsp;
	�ܹ�
	<font color="#FF0000">
	<s:property value="pager.offset/pageSize+1"/>
	</font>
	/
	<s:property value="totalCount%pageSize==0?totalCount/pageSize:totalCount/pageSize+1"/>ҳ
	&nbsp;&nbsp;�ܹ�${totalCount}��	
	</td>
  </tr>
</table>
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
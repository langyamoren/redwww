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
<base href="<%=basePath%>"/>
<s:head/>
<meta http-equiv="Content-Type" content="text/html;charset=GB18030"/>
<title>������-�γ��б�</title>
<link href="res/css/global.css" rel="stylesheet" type="text/css" />
<link href="res/dialog/dialog.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="res/dialog/dialog.js"></script>
<script language="javascript" src="res/js/jquery-1.5.1.min.js"></script>
<style type="text/css"> 
#clist{ border-collapse:collapse;}
#clist td{ line-height:26px; height:26px; border:1px #CCCCCC solid;}
.bg1{background-color:#EDEFEF;}
</style>
<script type="text/javascript">
$(function(){
	
	//ȫѡ
	  $('#selectAllBox').toggle(function(){ 
        $(".checkboxfor").each(function(){ 
            $(this).attr('checked',true); 
        }); 
        $(this).attr('value','ȡ��'); 
     
    },function(){ 
        $(".checkboxfor").each(function(){ 
            $(this).attr('checked',false); 
        }); 
        $(this).attr('value','ȫѡ');   
    } 
 ); 
	
	//��������html
	  $("#pubsAll").click(function(){
		  puballchap.submit();
	    });
	
});
</script>
</head>

<body>
<form action="mred/chapterHtml" method="post" name="puballchap">
<table width="800"  border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td width="10" height="100">&nbsp;</td>
    <td width="160" align="left" valign="middle"><table border="0" align="center" cellpadding="10" cellspacing="0">
      <tr>
        <td width="140"><img src="res/upres/course_pic/<s:property value="course.picture"/>" alt="<s:property value="course.title"/>"  width="140" height="80"  /></td>
      </tr>
    </table></td>
    <td width="630" align="left" valign="bottom"><table width="600" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td height="30" colspan="2" style="font-size:16px; font-weight:bold;"><s:property value="course.title"/></td>
      </tr>
      <tr>
        <td height="30" colspan="2">������𣺡�<s:property value="course.courseType.name"/>��&nbsp;&nbsp; 
                                                                �������ڣ�<s:date name="course.dates" format="yyyy-MM-dd HH:mm:ss"/>&nbsp;&nbsp; 
                                                                �Ƿ��Ƽ���<s:if test="course.isrecom">��</s:if><s:else>��</s:else>&nbsp;&nbsp;&nbsp; 
                                                                �Ƿ�������<s:if test="course.islock">��</s:if><s:else>��</s:else> </td>
      </tr>
      <tr>
        <td width="370" height="30">
        <a href="mred/chapter/add_chapter?chapter.course.id=<s:property value="course.id"/>"  class="redButton"  style="text-decoration:none; height:30px; line-height:30px; width:120px; text-align:center; display:block;">�����¿γ�</a>        </td>
        <td width="230" align="left" valign="middle"><a href="mred/courseListHtml?course.id=<s:property value="course.id"/>" class="redButton" style="display:block; text-decoration:none; height:30px; line-height:30px; width:120px; text-align:center; ">����</a></td>
      </tr>
    </table></td>
  </tr>
</table>
<table width="800" height="30" border="0" align="center" cellpadding="0" cellspacing="0" id="clist">
  <s:iterator value="chapterList" status="state">
   <tr
      <s:if test="#state.odd">
      class="bg1"
      </s:if>
      >
    <td width="66" align="center" valign="middle">
	<input type="checkbox" class="checkboxfor" name="chapterParam" value="<s:property value="id"/>||<s:property value="course.id"/>||<s:property value="%{chapterNo-#state.index}"/>"/>
	
	</td>
    <td width="61" align="center" valign="middle">
	��<s:property value="%{chapterNo-#state.index}"/>��
	</td>
    <td width="337" align="left" valign="middle">
    <s:hidden name="chapter.id" value="%{id}"></s:hidden>
    <s:property value="title"/>    </td>
    <td width="65" align="center"><s:if test="isFree">����</s:if><s:else>����</s:else></td>
    <td width="151"><s:date name="dates" format="yyyy-MM-dd HH:mm:ss"/></td>
    <td width="60" align="center" valign="middle">
     <a href="mred/chapter/update_chapter?chapter.id=<s:property value="id"/>">�޸�</a>
    <td width="60" align="center" valign="middle">
    <a href="mred/chapter/delete_chapter?chapter.id=<s:property value="id"/>">ɾ��</a>    </td>
  </tr>
    </s:iterator>
    <tr>
    <td><input type="button" value="ȫѡ" id="selectAllBox"/>&nbsp;<input type="button" id="pubsAll" value="����"/></td>
    <td colspan="6">
    
    <pg:pager
    url="mred/course/list_course"
    items="${totalCount}"
    index="center"
    maxPageItems="20"
    maxIndexPages="10"
    isOffset="<%=true%>"
    export="offset,currentPageNumber=pageNumber"
    scope="page">
   <pg:param name="course.id" value="${course.id}"/>
   
			<pg:first>
			  <a href="<%= pageUrl %>">��ҳ</a></pg:first>
			
			<pg:prev>
			  <a href="<%= pageUrl %>">��һҳ</a></pg:prev>
			<pg:pages>
			   <a href="<%= pageUrl %>"><%= pageNumber %></a></pg:pages>
			<pg:next>
			  <a href="<%= pageUrl %>">��һҳ</a></pg:next>
			
			<pg:last>
			  <a href="<%= pageUrl %>">���һҳ</a></pg:last>
	</pg:pager>
	&nbsp;&nbsp;
	�ܹ�
	<font color="#FF0000">
	<s:property value="pager.offset/pageSize+1"/>
	</font>
	/
	<s:property value="totalCount%pageSize==0?totalCount/pageSize:totalCount/pageSize+1"/>ҳ
	&nbsp;&nbsp;�ܹ�${totalCount}��	
				 
    </td></tr>
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
</form>
</body>
</html>

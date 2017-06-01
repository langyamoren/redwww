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
<title>红萌网-课程列表</title>
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
	
	//全选
	  $('#selectAllBox').toggle(function(){ 
        $(".checkboxfor").each(function(){ 
            $(this).attr('checked',true); 
        }); 
        $(this).attr('value','取消'); 
     
    },function(){ 
        $(".checkboxfor").each(function(){ 
            $(this).attr('checked',false); 
        }); 
        $(this).attr('value','全选');   
    } 
 ); 
	
	//批量生成html
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
        <td height="30" colspan="2">所属类别：【<s:property value="course.courseType.name"/>】&nbsp;&nbsp; 
                                                                发布日期：<s:date name="course.dates" format="yyyy-MM-dd HH:mm:ss"/>&nbsp;&nbsp; 
                                                                是否推荐：<s:if test="course.isrecom">是</s:if><s:else>否</s:else>&nbsp;&nbsp;&nbsp; 
                                                                是否锁定：<s:if test="course.islock">是</s:if><s:else>否</s:else> </td>
      </tr>
      <tr>
        <td width="370" height="30">
        <a href="mred/chapter/add_chapter?chapter.course.id=<s:property value="course.id"/>"  class="redButton"  style="text-decoration:none; height:30px; line-height:30px; width:120px; text-align:center; display:block;">增加新课程</a>        </td>
        <td width="230" align="left" valign="middle"><a href="mred/courseListHtml?course.id=<s:property value="course.id"/>" class="redButton" style="display:block; text-decoration:none; height:30px; line-height:30px; width:120px; text-align:center; ">发布</a></td>
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
	第<s:property value="%{chapterNo-#state.index}"/>节
	</td>
    <td width="337" align="left" valign="middle">
    <s:hidden name="chapter.id" value="%{id}"></s:hidden>
    <s:property value="title"/>    </td>
    <td width="65" align="center"><s:if test="isFree">试听</s:if><s:else>加密</s:else></td>
    <td width="151"><s:date name="dates" format="yyyy-MM-dd HH:mm:ss"/></td>
    <td width="60" align="center" valign="middle">
     <a href="mred/chapter/update_chapter?chapter.id=<s:property value="id"/>">修改</a>
    <td width="60" align="center" valign="middle">
    <a href="mred/chapter/delete_chapter?chapter.id=<s:property value="id"/>">删除</a>    </td>
  </tr>
    </s:iterator>
    <tr>
    <td><input type="button" value="全选" id="selectAllBox"/>&nbsp;<input type="button" id="pubsAll" value="发布"/></td>
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
			  <a href="<%= pageUrl %>">首页</a></pg:first>
			
			<pg:prev>
			  <a href="<%= pageUrl %>">上一页</a></pg:prev>
			<pg:pages>
			   <a href="<%= pageUrl %>"><%= pageNumber %></a></pg:pages>
			<pg:next>
			  <a href="<%= pageUrl %>">下一页</a></pg:next>
			
			<pg:last>
			  <a href="<%= pageUrl %>">最后一页</a></pg:last>
	</pg:pager>
	&nbsp;&nbsp;
	总共
	<font color="#FF0000">
	<s:property value="pager.offset/pageSize+1"/>
	</font>
	/
	<s:property value="totalCount%pageSize==0?totalCount/pageSize:totalCount/pageSize+1"/>页
	&nbsp;&nbsp;总共${totalCount}条	
				 
    </td></tr>
</table>
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
</form>
</body>
</html>

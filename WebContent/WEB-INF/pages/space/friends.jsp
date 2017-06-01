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
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>推荐的好友</title>
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

#friend_container{ width:760px; margin:10px auto;}
#friend_container table{ border-collapse:collapse;}
#friend_container table th{ background-color:#CC0000; color:#FFFFFF; line-height:26px;}
#friend_container table td{ border:1px #CCCCCC dashed; line-height:24px;}
#friend_container table td a{ color:#333333; text-decoration:none;}
#friend_container table td a:hover{text-decoration:underline;}
</style>
</head>
<body>
<div id="container">
    <%@include file="top.jsp" %>
	<div id="friend_container">
      <table width="645" border="0"  cellpadding="0" cellspacing="0">
        <tr>
          <th width="76">序号</th>
          <th width="118">姓名</th>
          <th width="327">Email</th>
          <th width="124">积分</th>
        </tr>
        <s:iterator status="stat" value="recomeMembers">
        <tr <s:if test="#stat.odd == true"> bgcolor="#EEEEEE"</s:if>>
          <td align="center" valign="middle"><s:property value="#stat.index+1"/></td>
          <td align="center" valign="middle"><s:property value="name"/></td>
          <td><s:property value="email"/></td>
          <td align="center" valign="middle"><s:property value="integal"/></td>
        </tr>
        </s:iterator>
        <tr>
          <td>&nbsp;</td>
          <td colspan="4" align="left" valign="middle">
            <pg:pager
    url="red/recomeFriends_space"
    items="${totalCount}"
    index="center"
    maxPageItems="30"
    maxIndexPages="10"
    isOffset="<%=true%>"
    export="offset,currentPageNumber=pageNumber"
    scope="page">
			<pg:first>
			  <a href="<%= pageUrl %>"><nobr>首页</nobr></a>
			</pg:first>
			
			<pg:prev>
			  <a href="<%= pageUrl %>"><nobr>上一页</nobr></a>
			</pg:prev>
			<pg:pages>
			   <a href="<%= pageUrl %>"><%= pageNumber %></a> 
			</pg:pages>
			<pg:next>
			  <a href="<%= pageUrl %>"><nobr>下一页</nobr></a>
			</pg:next>
			
			<pg:last>
			  <a href="<%= pageUrl %>"><nobr>最后一页</nobr></a>
			</pg:last>

	</pg:pager>
	&nbsp;&nbsp;
	总共
	<font color="#FF0000">
	<s:property value="pager.offset/pageSize+1"/>
	</font>
	/
	<s:property value="totalCount%pageSize==0?totalCount/pageSize:totalCount/pageSize+1"/>页
	&nbsp;&nbsp;总共${totalCount}条 
          </td>
        </tr>
      </table>
	</div>
</div>
</body>
</html>
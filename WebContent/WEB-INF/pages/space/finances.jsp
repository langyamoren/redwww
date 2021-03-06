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
<title>推荐的好友</title>
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

#friend_container{ width:660px; margin:10px auto;}
#friend_container table{ border-collapse:collapse;}
#friend_container table th{ background-color:#CC0000; color:#FFFFFF; line-height:26px;}
#friend_container table td{ border:1px #CCCCCC dashed; line-height:24px; padding-left:6px;}
#friend_container table td a{ color:#333333; text-decoration:none;}
#friend_container table td a:hover{text-decoration:underline;}
</style>
</head>
<body>
<div id="container">
    <%@include file="top.jsp" %>
	<div id="friend_container">
      <table width="660" border="0" align="center"  cellpadding="0" cellspacing="0">
        <tr>
          <th width="56">序号</th>
          <th width="124">类别</th>
          <th width="218">描述</th>
          <th width="262">日期</th>
        </tr>
        <s:iterator status="stat" value="financeList">
        <tr  <s:if test="#stat.odd == true"> bgcolor="#EEEEEE"</s:if>>
          <td align="center" valign="middle"><s:property value="#stat.index+1"/></td>
          <td align="center" valign="middle">
           <s:if test="payType==0">购买</s:if>
           <s:if test="payType==1">兑现</s:if>
           <s:if test="payType==2">充值</s:if>
           <s:if test="payType==3">奖励</s:if>
           <s:if test="payType==4">收入</s:if>
            <s:if test="payType==5">申请兑现</s:if>
          </td>
          <td><s:property value="descs" escape="false"/><b><s:property value="money"/></b>金币
          </td>
          <td align="center" valign="middle"><s:date name="dates" format="yyyy-MM-dd HH:mm:ss"></s:date></td>
        </tr>
        </s:iterator>
        <tr>
          <td>&nbsp;</td>
          <td colspan="4" align="left" valign="middle">
            <pg:pager
    url="red/finance_space"
    items="${totalCount}"
    index="center"
    maxPageItems="30"
    maxIndexPages="10"
    isOffset="<%=true%>"
    export="offset,currentPageNumber=pageNumber"
    scope="page">
			<pg:first>
			  <a href="<%= pageUrl %>">首页</a>
			</pg:first>
			
			<pg:prev>
			  <a href="<%= pageUrl %>">上一页</a>
			</pg:prev>
			<pg:pages>
			   <a href="<%= pageUrl %>"><%= pageNumber %></a> 
			</pg:pages>
			<pg:next>
			  <a href="<%= pageUrl %>">下一页</a>
			</pg:next>
			
			<pg:last>
			  <a href="<%= pageUrl %>">最后一页</a>
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
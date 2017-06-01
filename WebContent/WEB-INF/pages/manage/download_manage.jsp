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
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>红萌网-下载管理</title>
<link href="res/css/global.css" rel="stylesheet" type="text/css" />
<link href="res/dialog/dialog.css" rel="stylesheet" type="text/css" />
<script language="javascript" src="res/js/jquery-1.5.1.min.js"></script>
<script type="text/javascript" src="res/dialog/dialog.js"></script>
<style type="text/css">
	#artList{ border-collapse:collapse; font-size:12px;}
	#artList tr td{ height:25px; border:1px #CCCCCC solid; line-height:25px; padding-left:3px;}
	#artList tr th{ background-color:#CC0000; color:#FFFFFF; height:25px; line-height:25px; padding:3px;}
	#artList tr td a{ color:#333333;text-decoration:none;}
	#artList tr td a:hover{text-decoration:underline;}
	.bg1{background-color:#EDEFEF;}
	
	#pageIndex a{ font-size:12px; text-decoration:none; color:#333333; font-weight:bold;}
	#pageIndex a:hover{ text-decoration:underline; color:#FF0000;}
	#pageIndex a:active{ color:#FF0000; text-decoration:underline;}
</style>
<script type="text/javascript">
$(function(){
	//选择类别跳转 
      $("#articleTypeSelect").change(function(){
	    var typeId=$(this).val();
	    window.location='<%=path%>/mred/download/browse_download?download.downType.id='+typeId;
	  });
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
	
	  //批量删除
	  $("#deleteAll").click(function(){
	    var ids=new Array(3);
	    var i=0;
	       $(".checkboxfor").each(function()
	       { 
              if($(this).attr('checked'))
              {
                ids[i]=$(this).val();
                i++; 
                }
            }); 
            var param="";
   
          for (x in ids)
				{
				  //param+="ids["+x+"]="+ids[x]+"&";
				  param+="ids="+ids[x]+"&";
				}
				 //alert(param);
	             window.location='<%=path%>/mred/download/deleteBatch_download?'+param;
	    });
	  
	  //批量审核
	  $("#auditAll").click(function(){
	    var ids=new Array(3);
	    var i=0;
	       $(".checkboxfor").each(function()
	       { 
              if($(this).attr('checked'))
              {
                ids[i]=$(this).val();
                i++; 
                }
            }); 
            var param="";
   
          for (x in ids)
				{
				  //param+="ids["+x+"]="+ids[x]+"&";
				  param+="ids="+ids[x]+"&";
				}
				 //alert(param);
	             window.location='<%=path%>/mred/download/auditBatch_download?'+param;
	    });
	  
	//批量生成html
	  $("#pubsAll").click(function(){
	    var ids=new Array(3);
	    var i=0;
	       $(".checkboxfor").each(function()
	       { 
              if($(this).attr('checked'))
              {
                ids[i]=$(this).val();
                i++; 
                }
            }); 
            var param="";
   
          for (x in ids)
				{
				  //param+="ids["+x+"]="+ids[x]+"&";
				  param+="ids="+ids[x]+"&";
				}
				 //alert(param);
	             window.location='<%=path%>/mred/download/pubBatch_download?'+param;
	    });
	  
});
</script>
</head>
<body>
<table width="800" height="30" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td width="103" align="right" valign="middle">请选择类别：</td>
    <td width="413" align="left" valign="middle"> 
    <s:select id="articleTypeSelect" cssClass="redInput" name="download.downType.id" list="downType" listKey="id" listValue="name" headerKey="0" headerValue="请选择类别"></s:select></td>
    <td width="284" align="left"></td>
  </tr>
</table>
<table width="800" border="0" align="center" cellpadding="0" cellspacing="0" id="artList">
  <tr>
    <th width="26" align="center" valign="middle">&nbsp;</th>
    <th width="46" align="center" valign="middle">序号</th>
    <th width="96" align="center" valign="middle">类别</th>
    <th width="368" align="center" valign="middle">标题</th>
    <th width="96" align="center" valign="middle">日期</th>
    <th width="56" align="center" valign="middle">发布</th>
    <th width="56" align="center" valign="middle">修改</th>
    <th width="56" align="center" valign="middle">删除</th>
  </tr>
	<s:iterator value="downloadList" status="state"> 
		<s:form method="post"  name="/mred/download">
	  <tr
      <s:if test="#state.odd">
      class="bg1"
      </s:if>
      >
		<td>
		 <s:token name="redmenagedownloadtoken"></s:token>
		 <input type="checkbox" class="checkboxfor"  value="<s:property value="id"/>"/>
         <input type="hidden"  name="download.id" value="<s:property value="id"/>"/>		</td>
		<td align="center" valign="middle"><s:property value="#state.index+1"/></td>
		<td align="left" valign="middle"><b>[ 
	    <s:property value="downType.name"/>]</b></td>
		<td align="left" valign="middle">
			<a target="_blank" href="res/download/d<s:property value="downType.id"/><s:property value="id"/>.html">
	        <s:property value="%{@com.red.util.HtmlRegexpUtil@getDesc(title,24)}"/>
	        </a>
        </td>
		<td align="center" valign="middle">
		<s:date name="dates" format="yyyy-MM-dd"/></td>
		<td>
		<s:if test="%{ispass}">已审核</s:if>
		<s:else>
		<s:submit value="审核" action="audit_download" cssClass="redButton"/>
		</s:else>
		</td>
		<td><s:submit value="修改" action="update_download" cssClass="redButton"/></td>
		<td><s:submit value="删除" action="delete_download" cssClass="redButton"/></td>
	  </tr>
	  </s:form>
	</s:iterator>
  <tr>
    <td align="center"><input type="button" id="selectAllBox"  value="全选"/></td>
    <td colspan="7" align="left" valign="middle"> 
	  <input type="button" id="deleteAll" value="删除"/>
	  <input type="button" id="auditAll" value="审核"/>
	  <input type="button" id="pubsAll" value="发布"/>
	    <%//int totalCount= (int)request.getAttribute("totalCount"); 
	    //System.out.println(request.getAttribute("totalCount"));--%>
    <pg:pager
    url="mred/download/browse_download"
    items="${totalCount}"
    index="center"
    maxPageItems="20"
    maxIndexPages="10"
    isOffset="<%=true%>"
    export="offset,currentPageNumber=pageNumber"
    scope="page">
    <pg:param name="download.downType.id" value="${download.downType.id}"/>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<pg:first>
			  <a href="<%= pageUrl %>"><nobr>首页</nobr></a>			</pg:first>
			
			<pg:prev>
			  <a href="<%= pageUrl %>"><nobr>上一页</nobr></a>			</pg:prev>
			<pg:pages>
			   <a href="<%= pageUrl %>"><%= pageNumber %></a>			</pg:pages>
			<pg:next>
			  <a href="<%= pageUrl %>"><nobr>下一页</nobr></a>			</pg:next>
			
			<pg:last>
			  <a href="<%= pageUrl %>"><nobr>最后一页</nobr></a>			</pg:last>
	</pg:pager>
	&nbsp;&nbsp;
	总共
	<font color="#FF0000">
	<s:property value="pager.offset/pageSize+1"/>
	</font>
	/
	<s:property value="totalCount%pageSize==0?totalCount/pageSize:totalCount/pageSize+1"/>页
	&nbsp;&nbsp;总共${totalCount}条	</td>
  </tr>
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
</body>
</html>
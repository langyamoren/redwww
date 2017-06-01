<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@taglib uri="http://jsptags.com/tags/navigation/pager" prefix="pg" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>红萌网-管理问题</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
    <link href="res/css/global.css" rel="stylesheet" type="text/css" />
    <link href="res/dialog/dialog.css" rel="stylesheet" type="text/css" />
<script language="javascript" src="res/js/jquery-1.5.1.min.js"></script>
<script type="text/javascript" src="res/dialog/dialog.js"></script>
    <style type="text/css">
    #artTit{ font-size:14px; font-weight:bold; color:#FF0000; margin-bottom:6px;}
	#artList{ border-collapse:collapse; font-size:12px;}
	#artList tr td{ height:25px; border:1px #CCCCCC solid; line-height:25px; padding-left:3px;}
	#artList tr th{ background-color:#CC0000; color:#FFFFFF; height:25px; padding:3px;}
	.bg1{background-color:#EDEFEF;}
	
	#pageIndex a{ font-size:12px; text-decoration:none; color:#333333; font-weight:bold;}
	#pageIndex a:hover{ text-decoration:underline; color:#FF0000;}
	#pageIndex a:active{ color:#FF0000; text-decoration:underline;}
	h2 br{display:none;}
	</style>
	<%-- 
	<script src="res/js/jquery-1.4.2.min.js"></script>
	--%>
	<script type="text/javascript">
	$(function(){
	  $("#column2").change(function(){
	    var typeId=$(this).val();
	    window.location='<%=path%>/mred/question/browse_question?question.questionType.id='+typeId;
	  });
	  
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
	             window.location='<%=path%>/mred/question/deleteBatch_question?'+param;
	    });
	    

	});
	</script>
  </head>
  
  <body>
  <br>
   <table width="744" border="0" align="center" cellpadding="0" cellspacing="0" id="artTit">
    <tr>
      <td width="24">&nbsp;</td>
      <td width="720" align="left" valign="middle">
	   <h2>
	       <s:form>
	                         请选择问题分类：
			 <s:doubleselect 
			    list="doubleSelectNodes" 
			    listKey="value" 
			    listValue="name"
			    doubleList="subNodes"
				doubleListKey="value"
				doubleListValue="name"
				doubleName="question.questionType.id"
				doubleId="column2"
				name="column1"
				id="column1"
				value="column1"
				doubleValue="column2" cssClass="redInpu"/>
			</s:form>	
	  </h2>
         </td>
     </tr>
  </table>
  <table border="0" align="center" cellpadding="0" cellspacing="0" id="artList" style="margin-left:20px;">
    <tr>
      <th width="23" valign="middle">&nbsp;</th>
      <th width="30" valign="middle">序号</th>
      <th width="400" align="left" valign="middle">标题</th>
      <th width="80" align="center" valign="middle">作者</th>
      <th width="100" align="center" valign="middle">时间</th>
      <th colspan="3" align="center" valign="middle">操作</th>
    </tr>


    <s:iterator value="questionList" status="state">
      
	<s:form method="post"  name="/mred/question">
    <tr
      <s:if test="#state.odd">
      class="bg1"
      </s:if>
    >
      <td width="23">
         <input type="checkbox" class="checkboxfor"  value="<s:property value="id"/>"/>
         <input type="hidden"  name="question.id" value="<s:property value="id"/>"/>
     </td>
      <td width="30"><s:property value="#state.index+1"/></td>
      <td width="400" align="left" valign="middle">
      <a href="mred/question/browseAnsewer_question?question.id=<s:property value="id"/>">
      <s:property value="title"/>
      </a>
      </td>
      <td width="80" align="left" valign="middle"><s:property value="member.name"/></td>
      <td width="100" align="left" valign="middle"><s:date name="dates" format="yyyy-MM-dd"/></td>
      <td width="55" align="center" valign="middle">
      <s:property value="questionType.title"/>
      </td>
      <td width="50" align="center" valign="middle"><s:submit value="修改" action="update_question"/></td>
      <td width="50" align="center" valign="middle"><s:submit value="删除"  action="delete_question"/></td>
    </tr>
    </s:form>
   
    </s:iterator>

    
    <tr>
	 <td colspan="8"  id="pageIndex">
	  <input type="button" id="selectAllBox" style="margin-left:3px;" value="全选"/>
	  <input type="button" id="deleteAll" value="删除"/>
	  <input type="button" id="pubAll" value="发布"/>
	    <%//int totalCount= (int)request.getAttribute("totalCount"); 
	    //System.out.println(request.getAttribute("totalCount"));--%>
    <pg:pager
    url="mred/question/browse_question"
    items="${totalCount}"
    index="center"
    maxPageItems="10"
    maxIndexPages="10"
    isOffset="<%=true%>"
    export="offset,currentPageNumber=pageNumber"
    scope="page">
    <pg:param name="question.questionType.id" value="${question.questionType.id}"/>

    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
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
	&nbsp;&nbsp;总共${totalCount}条 </td>
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

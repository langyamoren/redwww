<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>"/>
<s:head/>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030"/>
<title>红萌网-修改新课程</title>

<link href="res/css/global.css" rel="stylesheet" type="text/css" />
<link href="res/dialog/dialog.css" rel="stylesheet" type="text/css" />
<script language="javascript" src="res/js/jquery-1.5.1.min.js"></script>
<script type="text/javascript" src="res/dialog/dialog.js"></script>
<script type="text/javascript" src="res/uploadify/swfobject.js"></script>
<script type="text/javascript" src="res/uploadify/jquery.uploadify.v2.1.0.min.js"></script>
<script type="text/javascript" charset="utf-8" src="res/editor/kindeditor.js"></script>
<script type="text/javascript">
KE.show({
	id : 'contents',
	resizeMode : 1,
	allowPreviewEmoticons : false,
	allowUpload : false,
	items : [
	'fontname', 'fontsize', '|', 'textcolor', 'bgcolor', 'bold', 'italic', 'underline',
	'removeformat', '|', 'justifyleft', 'justifycenter', 'justifyright', 'insertorderedlist',
	'insertunorderedlist', '|', 'emoticons', 'image', 'link']
});

$(function(){
	//文件上传 首页图片
	$("#pic").uploadify({
	'uploader': 'res/uploadify/uploadify.swf',  
	'script':'../ajax/uploadCourseIndexPic',
	'cancelImg': 'res/uploadify/cancel.png',                  
	//　'queueID' : 'fileQueue', //和存放队列的DIV的id一致  
	'fileDataName': 'pic', //必须，和以下input的name属性一致                   
	'auto'  : true, //是否自动开始  
	'multi': true, //是否支持多文件上传  
	'buttonText': 'BROWSE', //按钮上的文字  
	'simUploadLimit' : 1, //一次同步上传的文件数目  
	'sizeLimit': 2097152, //设置单个文件大小限制，单位为byte  
	'queueSizeLimit' : 10, //队列中同时存在的文件个数限制  
	'fileDesc': '支持格式:jpg/gif/jpeg/png/bmp.', //如果配置了以下的'fileExt'属性，那么这个属性是必须的  
	'fileExt': '*.jpg;*.gif;*.jpeg;*.png;*.bmp',//允许的格式
	onComplete: function (event, queueID, fileObj, response, data) {  
	     alert("文件:" + fileObj.name + "上传成功");
	     var json=eval("("+response+")");
	   $("#new_pic").val(json.upFileName);
	   $("#show_pic").append("<img src='res/upres/course_pic/"+json.upFileName+"'/>");
	},  
	onError: function(event, queueID, fileObj) {  
	alert("文件:" + fileObj.name + "上传失败");  
	},  
	onCancel: function(event, queueID, fileObj){  
	alert("取消了" + fileObj.name);  
	} 
	});
});
 </script>
</head>

<body>
<table width="800"  border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td width="20" height="30">&nbsp;</td>
    <td width="780" align="left" valign="middle" style="font-size:16px; font-weight:bold;">修改新课程</td>
  </tr>
</table>
<s:form namespace="/mred/course" action="updateSave_course">
<table width="800" border="0" align="center" cellpadding="0" cellspacing="0" id="addCourseType">
  <tr>
    <td width="64" height="30" align="right" valign="middle">标题：</td>
    <td width="294">
    <s:hidden name="course.id"></s:hidden>
    <s:textfield name="course.title" cssClass="redInput" cssStyle="width:260px;"/></td>
    <td width="57" align="right" valign="middle">类别：</td>
    <td width="140" align="left" valign="middle">
    <s:select name="course.courseType.id" list="courseType" headerKey="0" headerValue="请选择分类" listKey="id" listValue="name" cssClass="redInput"></s:select>    </td>
    <td width="53" align="right">推荐：</td>
    <td width="192"><s:select list="%{#{0:'不推荐',1:'推荐'}}"  cssClass="redInput" name="course.isrecom"></s:select></td>
  </tr>
  <tr>
    <td height="30" align="right" valign="middle">关键字：</td>
    <td><s:textfield name="course.keyword" cssClass="redInput"/>多个关键字用空格隔开</td>
    <td align="right" valign="middle">排序：</td>
    <td align="left" valign="middle"> 
    <s:select list="%{{9,8,7,6,5,4,3,2,1,0}}" name="course.sorts"  cssClass="redInput"></s:select>    </td>
    <td align="right">锁定：</td>
    <td><s:select list="%{#{0:'不锁',1:'锁定'}}"  cssClass="redInput" name="course.islock"></s:select></td>
  </tr>
  <tr>
    <td height="30" align="right" valign="bottom">描述：</td>
    <td>
     <div id="show_pic"></div>
    </td>
    <td align="right" valign="middle">首图：</td>
    <td colspan="3" align="left" valign="middle"><s:file id="pic"/><s:hidden name="course.picture" id="new_pic" /></td>
    </tr>
  <tr>
    <td height="30" colspan="6" align="left" valign="middle" style="padding:3px;">
    <s:textarea id="contents" name="course.descs" style="width:700px;height:300px;" cssClass="redInput"/></td>
  </tr>
  <tr>
    <td height="30" align="right" valign="middle">&nbsp;</td>
    <td colspan="5" align="left" valign="middle"><s:submit value="修改课程" cssClass="redButton"/></td>
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

</body>
</html>

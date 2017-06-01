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

<title>红萌网-修改课程内容</title>
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
    imageUploadJson : '../../../../mred/ajax/chapterEditorUploadFile',
    allowFileManager : false
});
/*
KE.show({
	id : 'abstracts',
	resizeMode : 1,
	allowPreviewEmoticons : false,
	allowUpload : false,
	items : [
	'fontname', 'fontsize', '|', 'textcolor', 'bgcolor', 'bold', 'italic', 'underline',
	'removeformat', '|', 'justifyleft', 'justifycenter', 'justifyright', 'insertorderedlist',
	'insertunorderedlist', '|', 'emoticons', 'image', 'link']
});
*/
$(function(){
	//文件上传 软件上传
	$("#soft").uploadify({
	'uploader': 'res/uploadify/uploadify.swf',  
	'script':'../ajax/uploadVodFile',
	'cancelImg': 'res/uploadify/cancel.png',                  
	//　'queueID' : 'fileQueue', //和存放队列的DIV的id一致  
	'fileDataName': 'soft', //必须，和以下input的name属性一致                   
	'auto'  : true, //是否自动开始  
	'multi': true, //是否支持多文件上传  
	'buttonText': 'BROWSE', //按钮上的文字  
	'simUploadLimit' : 1, //一次同步上传的文件数目  
	'sizeLimit': 209715200, //设置单个文件大小限制，单位为byte  
	'queueSizeLimit' : 10, //队列中同时存在的文件个数限制  
	'fileDesc': '支持格式:rar/zip/tar/gz.', //如果配置了以下的'fileExt'属性，那么这个属性是必须的  
	'fileExt': '*.rar;*.zip;*.tar;*.gz',//允许的格式
	onComplete: function (event, queueID, fileObj, response, data) {  
	     alert("文件:" + fileObj.name + "上传成功");
	     var json=eval("("+response+")");
	     $("#showVod").append("<input type='button' alt='"+json.upFileName+"' onClick=\"deleteTemFile(this,'"+json.upFileName+"');\" value='"+fileObj.name+"'/>&nbsp;");
	    var oldValue=$("#vod_new_name").val();
	    if(oldValue==null||oldValue=="")
	    	 $("#vod_new_name").val(json.upFileName+"||");
	    else
	    	 $("#vod_new_name").val(oldValue+json.upFileName+"||");
	},  
	onError: function(event, queueID, fileObj) {  
	alert("文件:" + fileObj.name + "上传失败");  
	},  
	onCancel: function(event, queueID, fileObj){  
	alert("取消了" + fileObj.name);  
	} 
	});
	
	
});

function deleteTemFile(domNod,fileName)
{
	$.get("mred/ajax/deleteTemFile?fileName="+fileName, function(data)
			{
		          $("input[alt='"+fileName+"']").remove();
		    });
	
}
 </script>
</head>

<body>
<table width="800"  border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td width="16" height="30">&nbsp;</td>
    <td width="784" align="left" valign="middle"  style="font-size:16px; font-weight:bold;">IT高手蜕变课程</td>
  </tr>
</table>
<s:form namespace="/mred/chapter" action="updateSave_chapter" method="post">
<table width="800" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td width="75" height="30" align="right" valign="middle">标题：</td>
    <td width="383">
    <s:hidden name="chapter.course.id"></s:hidden>
    <s:hidden name="chapter.id"></s:hidden>
    <s:textfield name="chapter.title" cssClass="redInput" cssStyle="width:320px;"/>    </td>
    <td width="82" align="right" valign="middle">是否试听：</td>
    <td width="260">
    <s:select list="%{{'加密','试听'}}"  cssClass="redInput" name="chapter.isFree"></s:select>    </td>
  </tr>
  <tr>
    <td height="30" align="right" valign="middle">关键字：</td>
    <td><s:textfield name="chapter.keywords" cssClass="redInput"/>多个关键字用空格隔开</td>
    <td align="right" valign="middle">上传视频：</td>
    <td><s:file id="soft" name="soft"/><s:hidden id="vod_new_name" name="chapter.vodPath"/></td>
  </tr>
  <tr>
    <td height="30" align="right" valign="middle">内容摘要：</td>
    <td colspan="3"><div id="showVod" style="text-align:center; margin-left:30px;"></div></td>
    </tr>
  <tr>
    <td height="60" colspan="4" align="center" valign="top" >
     <s:textarea id="abstracts" name="chapter.abstracts" cssStyle="width:760px; height:60px;" cssClass="redInput"></s:textarea>    </td>
  </tr>
  <tr>
    <td height="30" align="right" valign="middle">课程内容：</td>
    <td>&nbsp;</td>
    <td align="right" valign="middle">&nbsp;</td>
    <td></td>
  </tr>
  <tr>
    <td height="200" colspan="4" align="center" valign="top" >
    <s:textarea id="contents" name="chapter.content" cssStyle="width:760px; height:200px;"></s:textarea>   </td>
  </tr>
  <tr>
    <td height="40" align="right" valign="middle">&nbsp;</td>
    <td height="40" colspan="3" align="left" valign="middle"><s:submit value="修改新内容" cssClass="redButton" cssStyle="height:30px; line-height:30px;" /></td>
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

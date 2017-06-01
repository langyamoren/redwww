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
<title>红萌网-增加下载</title>
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
	'script':'../ajax/uploadDownloadIndexPic',
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
	   //$("#news_pic").val(response);
	     var json=eval("("+response+")");
	   $("#new_pic").val(json.upFileName);
	},  
	onError: function(event, queueID, fileObj) {  
	alert("文件:" + fileObj.name + "上传失败");  
	},  
	onCancel: function(event, queueID, fileObj){  
	alert("取消了" + fileObj.name);  
	} 
	});
	
	//文件上传 软件上传
	$("#soft").uploadify({
	'uploader': 'res/uploadify/uploadify.swf',  
	'script':'../ajax/uploadSoftFile',
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
	    $("#softOldname").val(fileObj.name);
	    $("#softName").val(json.upFileName);
	    $("#contentType").val(json.softContentType);
	    $("#softSize").val(json.fileSize);
	   
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
    <td width="11" height="30">&nbsp;</td>
    <td width="789" style="font-size:16px; font-weight:bold;">添加下载</td>
  </tr>
</table>
<s:form namespace="/mred/download" method="post" action="addSave_download">
<table width="800" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td width="60" height="30" align="right">标题：</td>
    <td width="359" height="30" align="left" valign="middle">
	 <s:token name="download_token"></s:token>
    <s:textfield name="download.title" cssClass="redInput" cssStyle="with:140px;"/>
	</td>
    <td width="60" height="30" align="center" valign="middle">类别：</td>
    <td width="112" height="30" align="left" valign="middle">
	 <s:select name="download.downType.id" list="downType" headerKey="0" headerValue="请选择分类" listKey="id" listValue="name" cssClass="redInput"></s:select>
	</td>
    <td width="60" height="30" align="center" valign="middle">语言：</td>
    <td width="149" height="30" align="left" valign="middle">
    <s:select list="%{{'中文','英文'}}"  cssClass="redInput" name="download.language"></s:select>
    </td>
  </tr>
  <tr>
    <td height="30" align="right">关键字：</td>
    <td height="30" align="left" valign="middle">
    <s:textfield name="download.keyword" cssClass="redInput"/>多个关键字用空格隔开
    </td>
    <td height="30" align="center" valign="middle">推荐：</td>
    <td height="30" align="left" valign="middle"> 
	<s:select list="%{#{0:'不推荐',1:'推荐'}}"  cssClass="redInput" name="download.ispop"></s:select></td>
    <td height="30" align="center" valign="middle">平台：</td>
    <td height="30" align="left" valign="middle">
	<s:select list="%{{'windowsXp/windows7','unix/linux'}}"  cssClass="redInput" name="download.platform"></s:select></td>
  </tr>
  <tr>
    <td height="30" align="right">首图：</td>
    <td height="30" align="left" valign="middle">
    <input type="file" id="pic" name="pic"/>
    <input type="hidden" id="new_pic" name="download.picutre"/>
    </td>
    <td height="30" align="center" valign="middle">大小：</td>
    <td height="30" align="left" valign="middle">
	<s:textfield id="softSize" name="download.sizes" cssClass="redInput" cssStyle="width:60px;"/>M</td>
    <td height="30" align="center" valign="middle">授权：</td>
    <td height="30" align="left" valign="middle">
	<s:select list="%{{'免费','收费'}}"  cssClass="redInput" name="download.isfree"></s:select>
	</td>
  </tr>
  <tr>
    <td height="30" align="right" valign="middle">描述：</td>
    <td height="30">&nbsp;</td>
    <td height="30">上传：</td>
    <td height="30" colspan="3">
      <input type="file" id="soft" name="soft"/>
      <input type="hidden" id="softName" name="download.softFile"/> 
      <input type="hidden" id="contentType" name="download.contentType"/>
       <input type="hidden" id="softOldname" name="download.oldName"/>
       <!-- 默认以管理员身分发布软件 -->
       <input type="hidden" name="download.member.id" value="1"/>
    </td>
  </tr>
  <tr>
    <td height="200" colspan="6" align="left" valign="top">
	<s:textarea id="contents" name="download.descs" style="width:700px;height:200px;" cssClass="redInput"/></td>
  </tr>
  <tr>
    <td height="30">&nbsp;</td>
    <td height="30" colspan="5" align="left" valign="middle">
	<s:submit value="增加下载" cssClass="redButton"/>
	</td>
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
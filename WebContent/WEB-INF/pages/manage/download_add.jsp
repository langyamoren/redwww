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
<title>������-��������</title>
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
	//�ļ��ϴ� ��ҳͼƬ
	$("#pic").uploadify({
	'uploader': 'res/uploadify/uploadify.swf',  
	'script':'../ajax/uploadDownloadIndexPic',
	'cancelImg': 'res/uploadify/cancel.png',                  
	//��'queueID' : 'fileQueue', //�ʹ�Ŷ��е�DIV��idһ��  
	'fileDataName': 'pic', //���룬������input��name����һ��                   
	'auto'  : true, //�Ƿ��Զ���ʼ  
	'multi': true, //�Ƿ�֧�ֶ��ļ��ϴ�  
	'buttonText': 'BROWSE', //��ť�ϵ�����  
	'simUploadLimit' : 1, //һ��ͬ���ϴ����ļ���Ŀ  
	'sizeLimit': 2097152, //���õ����ļ���С���ƣ���λΪbyte  
	'queueSizeLimit' : 10, //������ͬʱ���ڵ��ļ���������  
	'fileDesc': '֧�ָ�ʽ:jpg/gif/jpeg/png/bmp.', //������������µ�'fileExt'���ԣ���ô��������Ǳ����  
	'fileExt': '*.jpg;*.gif;*.jpeg;*.png;*.bmp',//����ĸ�ʽ
	onComplete: function (event, queueID, fileObj, response, data) {  
	alert("�ļ�:" + fileObj.name + "�ϴ��ɹ�");
	   //$("#news_pic").val(response);
	     var json=eval("("+response+")");
	   $("#new_pic").val(json.upFileName);
	},  
	onError: function(event, queueID, fileObj) {  
	alert("�ļ�:" + fileObj.name + "�ϴ�ʧ��");  
	},  
	onCancel: function(event, queueID, fileObj){  
	alert("ȡ����" + fileObj.name);  
	} 
	});
	
	//�ļ��ϴ� ����ϴ�
	$("#soft").uploadify({
	'uploader': 'res/uploadify/uploadify.swf',  
	'script':'../ajax/uploadSoftFile',
	'cancelImg': 'res/uploadify/cancel.png',                  
	//��'queueID' : 'fileQueue', //�ʹ�Ŷ��е�DIV��idһ��  
	'fileDataName': 'soft', //���룬������input��name����һ��                   
	'auto'  : true, //�Ƿ��Զ���ʼ  
	'multi': true, //�Ƿ�֧�ֶ��ļ��ϴ�  
	'buttonText': 'BROWSE', //��ť�ϵ�����  
	'simUploadLimit' : 1, //һ��ͬ���ϴ����ļ���Ŀ  
	'sizeLimit': 209715200, //���õ����ļ���С���ƣ���λΪbyte  
	'queueSizeLimit' : 10, //������ͬʱ���ڵ��ļ���������  
	'fileDesc': '֧�ָ�ʽ:rar/zip/tar/gz.', //������������µ�'fileExt'���ԣ���ô��������Ǳ����  
	'fileExt': '*.rar;*.zip;*.tar;*.gz',//����ĸ�ʽ
	onComplete: function (event, queueID, fileObj, response, data) {  
	     alert("�ļ�:" + fileObj.name + "�ϴ��ɹ�");
	     var json=eval("("+response+")");
	    $("#softOldname").val(fileObj.name);
	    $("#softName").val(json.upFileName);
	    $("#contentType").val(json.softContentType);
	    $("#softSize").val(json.fileSize);
	   
	},  
	onError: function(event, queueID, fileObj) {  
	alert("�ļ�:" + fileObj.name + "�ϴ�ʧ��");  
	},  
	onCancel: function(event, queueID, fileObj){  
	alert("ȡ����" + fileObj.name);  
	} 
	});
	
	
});
 </script>
</head>
<body>
<table width="800"  border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td width="11" height="30">&nbsp;</td>
    <td width="789" style="font-size:16px; font-weight:bold;">�������</td>
  </tr>
</table>
<s:form namespace="/mred/download" method="post" action="addSave_download">
<table width="800" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td width="60" height="30" align="right">���⣺</td>
    <td width="359" height="30" align="left" valign="middle">
	 <s:token name="download_token"></s:token>
    <s:textfield name="download.title" cssClass="redInput" cssStyle="with:140px;"/>
	</td>
    <td width="60" height="30" align="center" valign="middle">���</td>
    <td width="112" height="30" align="left" valign="middle">
	 <s:select name="download.downType.id" list="downType" headerKey="0" headerValue="��ѡ�����" listKey="id" listValue="name" cssClass="redInput"></s:select>
	</td>
    <td width="60" height="30" align="center" valign="middle">���ԣ�</td>
    <td width="149" height="30" align="left" valign="middle">
    <s:select list="%{{'����','Ӣ��'}}"  cssClass="redInput" name="download.language"></s:select>
    </td>
  </tr>
  <tr>
    <td height="30" align="right">�ؼ��֣�</td>
    <td height="30" align="left" valign="middle">
    <s:textfield name="download.keyword" cssClass="redInput"/>����ؼ����ÿո����
    </td>
    <td height="30" align="center" valign="middle">�Ƽ���</td>
    <td height="30" align="left" valign="middle"> 
	<s:select list="%{#{0:'���Ƽ�',1:'�Ƽ�'}}"  cssClass="redInput" name="download.ispop"></s:select></td>
    <td height="30" align="center" valign="middle">ƽ̨��</td>
    <td height="30" align="left" valign="middle">
	<s:select list="%{{'windowsXp/windows7','unix/linux'}}"  cssClass="redInput" name="download.platform"></s:select></td>
  </tr>
  <tr>
    <td height="30" align="right">��ͼ��</td>
    <td height="30" align="left" valign="middle">
    <input type="file" id="pic" name="pic"/>
    <input type="hidden" id="new_pic" name="download.picutre"/>
    </td>
    <td height="30" align="center" valign="middle">��С��</td>
    <td height="30" align="left" valign="middle">
	<s:textfield id="softSize" name="download.sizes" cssClass="redInput" cssStyle="width:60px;"/>M</td>
    <td height="30" align="center" valign="middle">��Ȩ��</td>
    <td height="30" align="left" valign="middle">
	<s:select list="%{{'���','�շ�'}}"  cssClass="redInput" name="download.isfree"></s:select>
	</td>
  </tr>
  <tr>
    <td height="30" align="right" valign="middle">������</td>
    <td height="30">&nbsp;</td>
    <td height="30">�ϴ���</td>
    <td height="30" colspan="3">
      <input type="file" id="soft" name="soft"/>
      <input type="hidden" id="softName" name="download.softFile"/> 
      <input type="hidden" id="contentType" name="download.contentType"/>
       <input type="hidden" id="softOldname" name="download.oldName"/>
       <!-- Ĭ���Թ���Ա��ַ������ -->
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
	<s:submit value="��������" cssClass="redButton"/>
	</td>
  </tr>
</table>
</s:form>
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
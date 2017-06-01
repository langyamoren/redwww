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

<title>������-�޸Ŀγ�����</title>
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
	//�ļ��ϴ� ����ϴ�
	$("#soft").uploadify({
	'uploader': 'res/uploadify/uploadify.swf',  
	'script':'../ajax/uploadVodFile',
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
	     $("#showVod").append("<input type='button' alt='"+json.upFileName+"' onClick=\"deleteTemFile(this,'"+json.upFileName+"');\" value='"+fileObj.name+"'/>&nbsp;");
	    var oldValue=$("#vod_new_name").val();
	    if(oldValue==null||oldValue=="")
	    	 $("#vod_new_name").val(json.upFileName+"||");
	    else
	    	 $("#vod_new_name").val(oldValue+json.upFileName+"||");
	},  
	onError: function(event, queueID, fileObj) {  
	alert("�ļ�:" + fileObj.name + "�ϴ�ʧ��");  
	},  
	onCancel: function(event, queueID, fileObj){  
	alert("ȡ����" + fileObj.name);  
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
    <td width="784" align="left" valign="middle"  style="font-size:16px; font-weight:bold;">IT�����ɱ�γ�</td>
  </tr>
</table>
<s:form namespace="/mred/chapter" action="updateSave_chapter" method="post">
<table width="800" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td width="75" height="30" align="right" valign="middle">���⣺</td>
    <td width="383">
    <s:hidden name="chapter.course.id"></s:hidden>
    <s:hidden name="chapter.id"></s:hidden>
    <s:textfield name="chapter.title" cssClass="redInput" cssStyle="width:320px;"/>    </td>
    <td width="82" align="right" valign="middle">�Ƿ�������</td>
    <td width="260">
    <s:select list="%{{'����','����'}}"  cssClass="redInput" name="chapter.isFree"></s:select>    </td>
  </tr>
  <tr>
    <td height="30" align="right" valign="middle">�ؼ��֣�</td>
    <td><s:textfield name="chapter.keywords" cssClass="redInput"/>����ؼ����ÿո����</td>
    <td align="right" valign="middle">�ϴ���Ƶ��</td>
    <td><s:file id="soft" name="soft"/><s:hidden id="vod_new_name" name="chapter.vodPath"/></td>
  </tr>
  <tr>
    <td height="30" align="right" valign="middle">����ժҪ��</td>
    <td colspan="3"><div id="showVod" style="text-align:center; margin-left:30px;"></div></td>
    </tr>
  <tr>
    <td height="60" colspan="4" align="center" valign="top" >
     <s:textarea id="abstracts" name="chapter.abstracts" cssStyle="width:760px; height:60px;" cssClass="redInput"></s:textarea>    </td>
  </tr>
  <tr>
    <td height="30" align="right" valign="middle">�γ����ݣ�</td>
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
    <td height="40" colspan="3" align="left" valign="middle"><s:submit value="�޸�������" cssClass="redButton" cssStyle="height:30px; line-height:30px;" /></td>
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

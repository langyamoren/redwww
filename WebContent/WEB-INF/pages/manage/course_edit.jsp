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
<title>������-�޸��¿γ�</title>

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
	'script':'../ajax/uploadCourseIndexPic',
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
	     var json=eval("("+response+")");
	   $("#new_pic").val(json.upFileName);
	   $("#show_pic").append("<img src='res/upres/course_pic/"+json.upFileName+"'/>");
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
    <td width="20" height="30">&nbsp;</td>
    <td width="780" align="left" valign="middle" style="font-size:16px; font-weight:bold;">�޸��¿γ�</td>
  </tr>
</table>
<s:form namespace="/mred/course" action="updateSave_course">
<table width="800" border="0" align="center" cellpadding="0" cellspacing="0" id="addCourseType">
  <tr>
    <td width="64" height="30" align="right" valign="middle">���⣺</td>
    <td width="294">
    <s:hidden name="course.id"></s:hidden>
    <s:textfield name="course.title" cssClass="redInput" cssStyle="width:260px;"/></td>
    <td width="57" align="right" valign="middle">���</td>
    <td width="140" align="left" valign="middle">
    <s:select name="course.courseType.id" list="courseType" headerKey="0" headerValue="��ѡ�����" listKey="id" listValue="name" cssClass="redInput"></s:select>    </td>
    <td width="53" align="right">�Ƽ���</td>
    <td width="192"><s:select list="%{#{0:'���Ƽ�',1:'�Ƽ�'}}"  cssClass="redInput" name="course.isrecom"></s:select></td>
  </tr>
  <tr>
    <td height="30" align="right" valign="middle">�ؼ��֣�</td>
    <td><s:textfield name="course.keyword" cssClass="redInput"/>����ؼ����ÿո����</td>
    <td align="right" valign="middle">����</td>
    <td align="left" valign="middle"> 
    <s:select list="%{{9,8,7,6,5,4,3,2,1,0}}" name="course.sorts"  cssClass="redInput"></s:select>    </td>
    <td align="right">������</td>
    <td><s:select list="%{#{0:'����',1:'����'}}"  cssClass="redInput" name="course.islock"></s:select></td>
  </tr>
  <tr>
    <td height="30" align="right" valign="bottom">������</td>
    <td>
     <div id="show_pic"></div>
    </td>
    <td align="right" valign="middle">��ͼ��</td>
    <td colspan="3" align="left" valign="middle"><s:file id="pic"/><s:hidden name="course.picture" id="new_pic" /></td>
    </tr>
  <tr>
    <td height="30" colspan="6" align="left" valign="middle" style="padding:3px;">
    <s:textarea id="contents" name="course.descs" style="width:700px;height:300px;" cssClass="redInput"/></td>
  </tr>
  <tr>
    <td height="30" align="right" valign="middle">&nbsp;</td>
    <td colspan="5" align="left" valign="middle"><s:submit value="�޸Ŀγ�" cssClass="redButton"/></td>
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

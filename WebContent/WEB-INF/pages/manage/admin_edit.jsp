<%@ page language="java" contentType="text/html; charset=GB18030" pageEncoding="GB18030"%>
<%@taglib prefix="s" uri="/struts-tags" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>"/> 
<meta http-equiv="Content-Type" content="text/html; charset=GB18030"/>
<title>�޸Ĺ���Ա</title>
<link href="res/css/global.css" rel="stylesheet" type="text/css" />
<link href="res/dialog/dialog.css" rel="stylesheet" type="text/css" />
<script language="javascript" src="res/js/jquery-1.5.1.min.js"></script>
<script type="text/javascript" src="res/dialog/dialog.js"></script>
<script language="javascript">
	var teipprim ="";
	//����Ȩ���ַ���
	function checkPrim(){
		for (var i=1;i<19;i++){
			c = "0";
			tempid = "prim"+i;
			if (document.getElementById(tempid).checked == true)c = "1";
			teipprim = teipprim+c;
		}
		if (teipprim!='000000000000000000'){
			document.all.privileges.value = teipprim;		
		}else{
			document.all.privileges.value = "";
		}
	}
	//��ԭȨ���б�
	function recoverPrim(temp){
		if (teipprim=='000000000000000000'){
			document.all.privileges.value = "";	
			return;	
		}else{
			for (var i=0;i<18;i++){
				if (temp.substring(i,i+1)=="1")document.getElementById("prim"+(i+1)).checked = true;
			}			
		}	
	}
</script>
</head>
<body>
<center>
	<br/>
    <h2 align="left">�޸Ĺ���Ա</h2>
    <br/>
	<div class="formDiv">
	  <s:form action="admin_update" onsubmit="checkPrim()" namespace="/mred/admin">	
		<table width="500" align="center" border="0" cellpadding="0" cellspacing="0">
		  <tr>
		    <td align="right">����Ա��</td>
		    <td><s:textfield name="admin.adminName" size="22" cssClass="redInput"/></td>
		    <td align="right">���룺</td>
		    <td><s:textfield name="admin.adminPwd" size="22" value="" cssClass="redInput"/></td>		    	    
		  </tr>
		  <tr>
		    <td align="right" valign="top">Ȩ�ޣ�</td>
		    <td valign="top" colspan="3"><table width="420" cellspacing="0" cellpadding="0">
		         <tr>
		          <td width="20"><s:checkbox id="prim1" name="prim1"/></td>
		          <td width="131" align="left" valign="middle">1��ȫȨ</td>
		          <td width="13"><s:checkbox id="prim2" name="prim2"/></td>
		          <td width="130" align="left" valign="middle">2��ϵͳ�û�����</td>
		          <td width="14"><s:checkbox id="prim3" name="prim3"/></td>
		          <td width="197" align="left" valign="middle">3������������</td>		          
		        </tr>
		        <tr>
		          <td width="20"><s:checkbox id="prim4" name="prim4"/></td>
		          <td align="left" valign="middle">4�����¹���</td>
		          <td width="13"><s:checkbox id="prim5" name="prim5"/></td>
		          <td align="left" valign="middle">5�����������</td>
		          <td width="14"><s:checkbox id="prim6" name="prim6"/></td>
		          <td align="left" valign="middle">6����Ա����</td>		          
		        </tr>
		        <tr>
		          <td width="20"><s:checkbox id="prim7" name="prim7"/></td>
		          <td align="left" valign="middle">7�����ط������</td>
		          <td width="13"><s:checkbox id="prim8" name="prim8"/></td>
		          <td align="left" valign="middle">8�����ع���</td>
		          <td width="14"><s:checkbox id="prim9" name="prim9"/></td>
		          <td align="left" valign="middle">9�� ��Ա������� </td>		          
		        </tr>
		        <tr>
		          <td width="20"><s:checkbox id="prim10" name="prim10"/></td>
		          <td align="left" valign="middle">10���ʴ�������</td>
		          <td width="13"><s:checkbox id="prim11" name="prim11"/></td>
		          <td align="left" valign="middle">11���ʴ����</td>
		          <td width="14"><s:checkbox id="prim12" name="prim12"/></td>
		          <td align="left" valign="middle">12���γ̹���</td>		          
		        </tr>
		        <tr>
		          <td width="20"><s:checkbox id="prim13" name="prim13"/></td>
		          <td align="left" valign="middle">13���γ����ݹ���</td>
		          <td width="13"><s:checkbox id="prim14" name="prim14"/></td>
		          <td align="left" valign="middle">14����ӭҳ</td>
		          <td width="14"><s:checkbox id="prim15" name="prim15"/></td>
		          <td align="left" valign="middle">15����̬��</td>		          
		        </tr> 		
		        <tr>
		          <td width="20"><s:checkbox id="prim16" name="prim16"/></td>
		          <td align="left" valign="middle">16�����ֹ���</td>
		          <td width="13"><s:checkbox id="prim17" name="prim17"/></td>
		          <td align="left" valign="middle">17������һ</td>
		          <td width="14"><s:checkbox id="prim18" name="prim18"/></td>
		          <td align="left" valign="middle">18��������</td>		          
		        </tr>	        	        		        		        		        
		      </table></td>
		  </tr>
		</table>
		<br/>
		  <div align="center">
			<s:submit value="�޸�"/>&nbsp;
			<s:reset value="����"/>&nbsp;
			
		    <input type="button" name="btn_ret" value="����" onClick="window.location='mred/admin/admin_browse';">
		    <s:hidden id="privileges" name="admin.privileges"/>
		    <s:hidden name="admin.id"/>
		  </div>
		</s:form>	
	</div>
</center>
<s:if test="%{null!=admin.privileges and admin.privileges.length()>0}">
	<script language="javascript">
		recoverPrim('${admin.privileges}');
	</script>	
</s:if>
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
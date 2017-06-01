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
<title>查看管理员</title>
<link href="res/css/global.css" rel="stylesheet" type="text/css" />
<link href="res/dialog/dialog.css" rel="stylesheet" type="text/css" />
<script language="javascript" src="res/js/jquery-1.5.1.min.js"></script>
<script type="text/javascript" src="res/dialog/dialog.js"></script>
<script language="javascript">
	var teipprim ="";
	//还原权限列表
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
     <h2>查看管理员</h2>
     <br/>
	<div class="formDiv">
		<table width="579" align="center" border="0" cellpadding="0" cellspacing="0">
		  <tr>
		    <td align="right">用户名：</td>
		    <td><s:textfield name="admin.adminName" size="22" disabled="true"/></td>    	    
		  </tr>
		  <tr>
		    <td align="right" valign="top">权限：</td>
		    <td valign="top"><table width="420" cellspacing="0" cellpadding="0">
		        <tr>
		          <td width="20"><s:checkbox id="prim1" name="prim1" disabled="true"/></td>
		          <td width="131" align="left" valign="middle" disabled="true">1、全权</td>
		          <td width="13"><s:checkbox id="prim2" name="prim2" disabled="true"/></td>
		          <td width="130" align="left" valign="middle">2、系统用户管理</td>
		          <td width="14"><s:checkbox id="prim3" name="prim3" disabled="true"/></td>
		          <td width="197" align="left" valign="middle" >3、文章类别管理</td>		          
		        </tr>
		        <tr>
		          <td width="20"><s:checkbox id="prim4" name="prim4" disabled="true"/></td>
		          <td align="left" valign="middle" disabled="true">4、文章管理</td>
		          <td width="13"><s:checkbox id="prim5" name="prim5" disabled="true"/></td>
		          <td align="left" valign="middle" disabled="true">5、焦点广告管理</td>
		          <td width="14"><s:checkbox id="prim6" name="prim6" disabled="true"/></td>
		          <td align="left" valign="middle">6、会员管理</td>		          
		        </tr>
		        <tr>
		          <td width="20"><s:checkbox id="prim7" name="prim7" disabled="true"/></td>
		          <td align="left" valign="middle">7、下载分类管理</td>
		          <td width="13"><s:checkbox id="prim8" name="prim8" disabled="true"/></td>
		          <td align="left" valign="middle">8、下载管理</td>
		          <td width="14"><s:checkbox id="prim9" name="prim9" disabled="true"/></td>
		          <td align="left" valign="middle">9、 会员密码管理 </td>		          
		        </tr>
		        <tr>
		          <td width="20"><s:checkbox id="prim10" name="prim10" disabled="true"/></td>
		          <td align="left" valign="middle">10、问答类别管理</td>
		          <td width="13"><s:checkbox id="prim11" name="prim11" disabled="true"/></td>
		          <td align="left" valign="middle">11、问答管理</td>
		          <td width="14"><s:checkbox id="prim12" name="prim12" disabled="true"/></td>
		          <td align="left" valign="middle">12、课程管理</td>		          
		        </tr>
		        <tr>
		          <td width="20"><s:checkbox id="prim13" name="prim13" disabled="true"/></td>
		          <td align="left" valign="middle">13、课程内容管理</td>
		          <td width="13"><s:checkbox id="prim14" name="prim14" disabled="true"/></td>
		          <td align="left" valign="middle">14、欢迎页</td>
		          <td width="14"><s:checkbox id="prim15" name="prim15" disabled="true"/></td>
		          <td align="left" valign="middle">15、静态化</td>		          
		        </tr> 	
		        		        <tr>
		          <td width="20"><s:checkbox id="prim16" name="prim16"/></td>
		          <td align="left" valign="middle">16、兑现管理</td>
		          <td width="13"><s:checkbox id="prim17" name="prim17"/></td>
		          <td align="left" valign="middle">17、其它一</td>
		          <td width="14"><s:checkbox id="prim18" name="prim18"/></td>
		          <td align="left" valign="middle">18、其它二</td>		          
		        </tr>	         		        		        		        		        
		      </table></td>
		  </tr>
		</table>
		<br/>
	  <div align="center">
	    <input type="button" name="btn_ret" value="返回" onClick="window.location='mred/admin/admin_browse';"/>
	  </div>
	</div>
</center>
<s:if test="%{null!=admin.privileges and admin.privileges.length()>0}">
	<script language="javascript">
		recoverPrim('${admin.privileges}');
	</script>	
</s:if>
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

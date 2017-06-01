<%@page language="java" import="com.red.util.HtmlRegexpUtil" contentType="text/html; charset=GB18030" pageEncoding="GB18030"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>">
<sj:head debug="true" compressed="false" jquerytheme="showcase" customBasepath="themes"/>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>�޸�����</title>
<link href="res/css/global.css" rel="stylesheet" type="text/css">
<style type="text/css">
#container{
width:780px;
margin:5 auto;
}
#tit_top #redBlock{ width:15px; height:30px; float:left; background-color:#CC0000;}
#tit_top h1{ float:left; width:150px; height:30px; line-height:30px; font-size:16px; margin-left:5px;}
#tit_top #membr_info{ height:30px; }
#tit_top #member_info p{ float:left; margin:0 10px; line-height:30px;}
#space_nav{ margin:10px auto; height:18px;}
#space_nav ul{list-style:none;}
#space_nav ul li{ float:left;}
#space_nav ul li a{ display:block; width:100px; height:16px; border-right:6px #CC0000 solid; color:#333333; text-decoration:none; font-size:14px; font-weight:bold; line-height:16px; text-align:center;}
#space_nav ul li a:hover{text-decoration:underline; color:#CC0000;}

#memberinfo_container{ width:750px; margin:30px auto;}
#memberinfo_container table{float:left; }
#memberinfo_container ul{padding:0 30px;float:left; margin-right: 70px; border-right:1px #333333 dashed; }
#memberinfo_container ul li{line-height:30px;}

</style>
</head>
<body>
<div id="container">
    <%@include file="top.jsp" %>
	<div id="memberinfo_container">
	 <h2>�޸ĸ�����Ϣ��</h2>
	  <ul>
			<li><b>Email:</b><s:property value="member.Email"/></li>
			<li><b>����:</b><s:property value="member.name"/></li>
			<li><b>�Ƽ���:</b><s:property value="member.member.name"/></li>
			<li><b>�û���:</b><s:property value="member.memberlevel.levelName"/></li>
			<li><b>qq:</b><s:property value="member.qq"/></li>
			<li><b>�ֻ�:</b><s:property value="member.cellphone"/></li>
			<li><b>����:</b><s:property value="member.integal"/></li>
			<li><b>�ʺ�����:</b><s:if test="member.acountType==0">��Ǯ</s:if><s:else>֧����</s:else></li>
			<li><b>�ʺ�:</b><s:property value="member.acount"/></li>
			<li><b>���:</b><s:property value="member.balance"/></li>
			<li><b>�Ƽ���:</b><s:property value="@com.red.util.RcomeRandCode@parseToString(member.id)"/></li>
            
      </ul>
	 <s:form theme="xhtml" method="post" namespace="/red" action="updateMemberInfo_space">
	     <s:hidden name="member.id"></s:hidden>
	     <s:token name="updateusertoken"></s:token>
	     <s:hidden name="updateuser" value="%{member.password}"></s:hidden>
	     <s:textfield name="member.Email" label="Email" disabled="true"  cssClass="redInput"></s:textfield>
         <s:password name="member.password" label="����"  cssClass="redInput"></s:password>
         <s:password name="rew" label="�ظ�����"  cssClass="redInput"></s:password>
         <s:textfield name="member.name" label="����" disabled="true" cssClass="redInput"></s:textfield>
         <s:textfield name="member.qq" label="qq"  cssClass="redInput"></s:textfield>
         <s:textfield name="member.cellphone" label="�ֻ�"  cssClass="redInput"></s:textfield>
         <s:select  name="member.acountType" list="#{0:'��Ǯ',1:'֧����'}" label="�ʺ�����"  cssClass="redInput"></s:select>
         <s:textfield name="member.acount" label="�ʺ�"  cssClass="redInput" ></s:textfield>
         <s:textfield name="reacount" label="�ظ��ʺ�"  cssClass="redInput"></s:textfield>        
         <s:submit value="�޸�����" cssClass="redButton"></s:submit>
	  </s:form>

	</div>
</div>
<div>
        <s:if test="hasActionMessages()">
         <sj:dialog id="mydialog" title="��ܰ��ʾ" modal="true">
            <s:actionmessage/>       
         </sj:dialog>
        </s:if>
       <s:if test="hasFieldErrors()">
         <sj:dialog id="mydialog" title="��ܰ��ʾ" modal="true">
            <s:fielderror></s:fielderror>     
         </sj:dialog>
        </s:if>
        
        <s:if test="hasActionErrors()">
         <sj:dialog id="mydialog" title="��ܰ��ʾ" modal="true">
            <font color=red><s:actionerror/></font>      
         </sj:dialog>
        </s:if>
 </div>
</body>
</html>
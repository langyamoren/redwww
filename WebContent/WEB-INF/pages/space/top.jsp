<%@ page language="java" contentType="text/html; charset=GB18030" pageEncoding="GB18030"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<style type="text/css">

#tit_top #redBlock{ width:15px; height:30px; float:left; background-color:#CC0000;}
#tit_top h1{ float:left; width:200px; height:30px; line-height:30px; font-size:16px; margin-left:5px;}
#tit_top #membr_info{float:left; height:30px; background-color:#CCCCCC;width:300px;}
#tit_top #member_info span{  margin:0 5px; line-height:30px;}
#tit_top #member_info a{margin:0 5px;}
#space_nav{ margin:10px auto; height:18px;}
#space_nav ul{list-style:none;}
#space_nav ul li{ float:left;}
#space_nav ul li a{ display:block; width:90px; height:16px; border-right:6px #CC0000 solid; color:#333333; text-decoration:none; font-size:14px; font-weight:bold; line-height:16px; text-align:center;}
#space_nav ul li a:hover{
text-decoration:underline; color:#CC0000;}

</style>
 <div id="tit_top">
		  <div id="redBlock"></div>
		  <h1 style="width:200px;">��������</h1>
		  <div id="member_info">
		   <span>���,<s:property value="member.name"/> </span>
		   <span>�����Ƽ��룺<s:property value="@com.red.util.RcomeRandCode@parseToString(member.id)"/></span>
		   <span>�ʻ���<font color="#CC0000"><b><s:property value="member.balance"/></b></font>���</span> 
		   <a href="red/gopay_space"><img src="res/image/chunzhi.gif" border="0" title="���߳�ֵ" /></a>
		   <s:if test="member.balance>200">
		   <a href="red/duixian_space"><img src="res/image/duixian.gif" border="0" title="�һ��ֽ�" /></a>
		   </s:if>
		  </div>
		  <div class="clear"></div>
    </div>
	<div id="space_nav">
	  <ul>
	    <li><a href="red/myquestion_space">�ҵ�����</a></li>
	    <li><a href="red/question/ask_question">��������</a></li>
	    <li><a href="red/recomeFriends_space">�Ƽ��ĺ���</a></li>
	    <li><a href="red/finance_space">������ϸ</a></li>
	    <li><a href="red/askPassword_space">��Ƶ����</a></li>
		<li><a href="red/editMemberInfo_space">�޸�����</a></li>
	
		<li><a href="red/logout">��ȫ�˳�</a></li>
	  </ul>
	</div>
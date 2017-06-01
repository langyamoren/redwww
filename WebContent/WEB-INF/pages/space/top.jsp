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
		  <h1 style="width:200px;">管理中心</h1>
		  <div id="member_info">
		   <span>你好,<s:property value="member.name"/> </span>
		   <span>您的推荐码：<s:property value="@com.red.util.RcomeRandCode@parseToString(member.id)"/></span>
		   <span>帐户余额：<font color="#CC0000"><b><s:property value="member.balance"/></b></font>金币</span> 
		   <a href="red/gopay_space"><img src="res/image/chunzhi.gif" border="0" title="在线充值" /></a>
		   <s:if test="member.balance>200">
		   <a href="red/duixian_space"><img src="res/image/duixian.gif" border="0" title="兑换现金" /></a>
		   </s:if>
		  </div>
		  <div class="clear"></div>
    </div>
	<div id="space_nav">
	  <ul>
	    <li><a href="red/myquestion_space">我的提问</a></li>
	    <li><a href="red/question/ask_question">提问问题</a></li>
	    <li><a href="red/recomeFriends_space">推荐的好友</a></li>
	    <li><a href="red/finance_space">财务明细</a></li>
	    <li><a href="red/askPassword_space">视频密码</a></li>
		<li><a href="red/editMemberInfo_space">修改资料</a></li>
	
		<li><a href="red/logout">安全退出</a></li>
	  </ul>
	</div>
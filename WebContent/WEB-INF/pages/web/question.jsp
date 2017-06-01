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
<title>�ʴ�-<s:property value="question.questionType.questionType.name"/></title>
<style type="text/css">
#answers{ width:665px; }
#answers #req_ques{ width:660px; border:1px #CCCCCC solid; padding:2px; margin:10px;}
#answers #req_ques h2{height:28px; line-height:28px; background:url(res/image/redbak.png) repeat-x 0px -39px; font-size:14px; padding-left:10px;}
#answers #req_ques div{ padding:10px 10px 3px 10px; width:560px; line-height:24px;}
#answers #req_ques  p{ text-align:right;}

#answers .anw_tit{ font-size:14px; height:28px; line-height:28px; width:660px; margin-left:10px;background:url(res/image/redbak.png) repeat-x 0px -39px; padding-left:5px; }

#answers ul li .anw_des{ line-height:28px; border-bottom:1px #CCCCCC dashed; width:660px; margin-left:10px;}
#answers ul li .anw_info{ line-height:24px; font-size:12px; text-align:right;width:660px; margin-left:10px; border-bottom:1px #CCCCCC solid; background-color:#F6F6F6;}

#answers #answing{ width:660px; margin-left:10px; border:1px #CCCCCC solid; margin-top:10px;}
#answers #answing h2{height:28px; line-height:28px; background:url(res/image/redbak.png) repeat-x 0px -39px; font-size:14px;}
#answers #answing textarea{ width:600px; border:1px #CCCCCC solid; margin:6px; height:80px;}
#answers #answing input{ width:80px; height:25px; line-height:25px; font-size:14px; color:#FFFFFF; background-color:#CC0000; font-weight:bold; margin:5px;}
</style>
</head>

<body>
<div id="answers">
      <div id="req_ques">
           <h2><s:property value="question.title" escape="false"/></h2>
		   <div>
		      <s:property value="question.descs" escape="false"/>
			
		   </div>
		    <p>�����ߣ�<s:property value="question.member.name"/> &nbsp;&nbsp;ʱ��:<s:date name="question.dates" format="yyyy-MM-dd HH:mm:ss" /></p>
	   </div>
      <h2 class="anw_tit">�ش�<s:property value="answerList.size"/>��</h2>
       <ul>
       <s:iterator value="answerList">
	      <li>
		    <p class="anw_des"><s:property value="descs" escape="false"/></p>
			<p class="anw_info">ʱ��:<s:date name="dates" format="yyyy-MM-dd HH:mm:ss" />&nbsp;&nbsp;�ش��ߣ�<s:property value="member.name"/>&nbsp;&nbsp;</p>
		  </li>
		</s:iterator>
		<!-- 
		 <li>
		    <p class="anw_des">��������԰ٶ�һ�°����Ա߻�����������Ŷ</p>
			<p class="anw_info">ʱ��:2011-01-13 14:58:54  �ش��ߣ������</p>
		  </li>
		 -->
	   </ul>
	   <div id="answing">
           <h2>��Ҳ���ش�</h2>
		   <form action="red/question/questionAnswer" method="post">
		     <input type="hidden" name="question.id" value="<s:property value="question.id"/>"/>
		     <textarea name="answer.descs" cols="30" rows="15"></textarea>
			 <input type="submit" value="�ش�"/>
		   </form>	   
	   </div>
</div>
</body>
</html>

<%@ page language="java" contentType="text/html; charset=GB18030" pageEncoding="GB18030"%>
<%@taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030" />
<base href="<%=basePath%>"/>
<!-- 
<base target="_blank" />
 -->
<meta name="Keywords" content="红萌,java,视频学习,学习,IT,电脑,黑客技术,linux,服务器,编程" />
<meta name="Description" content="红萌网是一家专门从事IT技术培训类网站，我们拥有数十年经验，我们竭诚研发IT中、高端课程，并拥有完全自主的课程体系。我们的课程以真实项目为案例，系统地讲解了IT应用中的各种技术，包括（计算机基础、操作系统、网络、安全、软件开发、web开发、服务端架构、云计算）等。我们为广大IT爱好者，提供最系统的IT技能培训、真实项目训练及生产实习，使会员朋友们能真正掌握社会上的技术，同时也提供服务器安全维护、安全评估、软件开发、网站开发等服务项目。我们的目标是'为缩小社会和大学生间的技术瓶颈，做网络IT培训第一平台'而奋斗" />


<title>红萌网-<decorator:title/></title>
<link href="res/css/global.css" rel="stylesheet" type="text/css" />
<link href="res/dialog/dialog.css" rel="stylesheet" type="text/css" />
<script language="javascript" src="res/js/jquery-1.5.1.min.js"></script>
<script type="text/javascript" src="res/dialog/dialog.js"></script>

<decorator:head/>

<style type="text/css">
#top,#location,#main,#foot{ width:1000px; margin:0 auto;}
#top{ height:84px; background:url(res/image/redbak.gif) no-repeat 0 -72px; position:relative;}
/*欢迎信息*/
#top p{ position:absolute; left:240px; top:16px; }
#top p a{text-decoration: none; color: #CC0000; font-weight:bold; font-size:14px;}
#top p a:hover{text-decoration:underline;}
#toplink{list-style:none;position:absolute;left:512px;top:4px;width: 478px;}
#toplink li{ float:right;}
#toplink li a{ text-decoration:none; color:#333333; font-weight:bold; padding:0 10px;}
#toplink li a:hover{ text-decoration:underline;}
/*首页导航*/
#navlink{ height:32px; width:710px; list-style:none; position:absolute; left:290px; top:52px; background:url(res/image/redbak.png);}
#navlink li{ float:left; }
#navlink li a{ display:block; line-height:26px; margin-top:6px; padding:0 10px; text-decoration:none; color:#FFFFFF; font-weight:bold; font-size:14px;}
#navlink li a:hover,#navlink li a:active{ background-color: #F8F8F8; color:#CC0000;}

#navlink li a.cur_home{ background-color: #F8F8F8; color:#CC0000;}
/*当前位置*/
#location{height:25px;line-height:25px;color:#CC0000;font-weight:bold;background-color: #F8F8F8;}
#location p{ margin-left:10px; width:660px; float:left;}

/*网页主体部分-左右*/
#main #left{ width:725px; float:left;}
/* #main #right{width:265px; height:1060px; float:right;} */
#main #right{width:265px; float:right;} 
</style>
<script language="javascript">
$(function(){
   $("#navlink li a:gt(0)").hover(
  function () {
	$("#navlink li a:first").removeClass("cur_home");
  },
  function () {
   $("#navlink li a:first").addClass("cur_home");
  }
);
});
</script>
<script type="text/javascript">

  var _gaq = _gaq || [];
  _gaq.push(['_setAccount', 'UA-22551223-3']);
  _gaq.push(['_trackPageview']);

  (function() {
    var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
    ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
    var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
  })();

</script>
</head>
<body>
<div id="top">
<p>
<% 
if(null!=session.getAttribute("redwww_user")&&!"".equals(session.getAttribute("redwww_user")))
{
	  com.red.beans.Member member=(com.red.beans.Member)session.getAttribute("redwww_user");
	  out.println("欢迎您，"+member.getName()+"&nbsp;&nbsp;");
	  out.println("<a href ='red/myquestion_space'>我的管理中心</a>");
	}else
	{
		out.println("游客您好，你还没有登陆！");
	}
%>
</p>
<ul id="toplink">
   <li><a href="http://www.yy.com/go.html#54553966"><img src="http://www.yy.com/images/icon03.gif"/>YY课堂</a></li>
    <li><a href="http://list.qq.com/cgi-bin/qf_invite?id=a7b5ac53943c6bf685434baf41d28365f458c685c140967f">订阅邮件</a></li>
   <li><a href="red/regist">注册</a></li>
   <li><a href="red/login">登陆</a></li>
   <li><a href="html/help.html">帮助</a></li>
      <%
       if(null!=session.getAttribute("redwww_user")&&!"".equals(session.getAttribute("redwww_user")))
	   {
	   out.println("<li><a href='red/logout'>退出</a></li>");
	   }
   %>
</ul>
<ul id="navlink">
	<li><a href="html/main.html" style="margin-left:10px;" class="cur_home">首页</a></li>
	<li><a href="html/course/courses_1_.html">精品课程</a></li>
	<li><a href="html/articles.html">精彩文章</a></li>
	<li><a href="red/question/questions">答疑解惑</a></li>
	<li><a href="html/downloads.html">软件下载</a></li>
	<li><a href="html/joinus.html">加入会员</a></li>
	<li><a href="html/aboutus.html">关于我们</a></li>
</ul>
</div>
<div id="location">
  <p>您当关的位置：首页 - <decorator:title/></p>
</div>
<div id="main">
  <div id="left">
   <decorator:body></decorator:body>
  </div>
  <!--右边-->
  <div id="right">
         <s:include value="/html/right.html"></s:include>
  </div>
  <div style="clear:both;width:1000px;"></div>
</div>
<div id="foot" style="clear:both;">
<s:include value="/html/foot.html"></s:include>
 </div>
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
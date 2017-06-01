<%@ page language="java" contentType="text/html; charset=GB18030" pageEncoding="GB18030"%>
<%@taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
  String show_id=(null!=request.getParameter("show_id")&&!"".equals(request.getParameter("show_id")))?request.getParameter("show_id"):"system_control";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>"> 
<sj:head debug="true" compressed="false" jquerytheme="showcase" customBasepath="themes"/> 
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>红萌网后台管理-<decorator:title/></title>
<decorator:head/>
<link href="res/css/global.css" rel="stylesheet" type="text/css" />
<style type="text/css">
  #top{ width:1005px; height:80px; border-bottom:1px #CC0000 solid; margin:0px auto;
  background:url(res/images/admin/logo2.gif) no-repeat 10px 20px;
  position:relative;}
  #head{ position:absolute; left:297px; top:11px; width:600px;}
  #top #logout{ position:absolute; left:921px; top:47px;}
  #top #logout a{ display:block; width:80px; height:30px; line-height:30px; text-align:center; text-decoration:none; color:#FFFFFF; font-size:16px; font-weight:bold; background-color:#CC0000;}
  #top #logout a:hover{ background-color:#000000;}
  #head span { margin-left:40px;}
  #nav{ position:absolute; bottom:-1px; left:187px; border-left:1px #CC0000 solid; height:64px; width:816px;  }
  #nav ul{ width:100%; list-style:none; background-color:#CC0000;  height:30px;}
  #nav ul li{ float:left; height:30px; line-height:30px;}
  #nav ul li a{ color:#FFFFFF; font-size:14px; font-family:"黑体", "宋体"; display:block; margin:0px 10px; text-decoration:none;
  font-weight:bold;cursor:pointer;cursor:hand;}
  #nav ul li a:hover{ text-decoration:underline; color:#CCCCCC;}
  #nav p{ margin-top:10px; margin-left:10px;}
  /*------------------------------main------------------------------------------------*/
  #main{width:1005px; margin:0 auto; position:relative; height:700px; }
  #main #left{ width:180px;height:700px; float:left;}
  #main #left dl{ width:180px; margin:0px; padding:0px ; border:0px;}
  #main #left dl dt{ font-weight:bold; border-left:10px #000000 solid;font-size:14px; color:#FFFFFF; line-height:30px; background-color:#CC0000; cursor:pointer; margin-bottom:2px;}
  #main #left dl dd{ margin-left:15px; display:none;}
  #main #left dl dd a{line-height:25px; display:block; font-size:14px;  text-decoration:none; color:#333333;}
 
 
  #main #left dl dd .cur_sel,#main #left dl dd a:hover{ color:#CC0000; text-decoration:underline; background-color:#E7E7E7;}

  #main #right{ width:816px; height:700px; border-left:1px #CC0000 solid; float:left;}
  
/*---------------------------------------foot---------------------------------------*/
  #foot{ clear:both; width:1000px; margin:0px auto; height:143px; border-top:1px #CC0000 solid;}
</style>
<!-- 
<script src="res/js/jquery-1.4.2.min.js"></script>
 -->
<script language="javascript">
    var show_id="<%=show_id%>";
  $(function(){
	 
	 $("#"+show_id).nextUntil("dt").show();
     $("#main #left dl dt").click(function(){
    	 var flag=$(this).next("dd").is(":hidden");
    	 if(flag)
    		 {
    		   //显示
    		   $("#main #left dl dd").hide();
    		   $(this).nextUntil("dt").fadeIn("slow");
    		 }else
   			 {
    			 $(this).nextUntil("dt").fadeOut("slow");
   			 } 
     });
     
  });
</script>
</head>
<body>
 <!--网页头部-->
<div id="top">
<!--网页头部文字-->
   <div id="head">
     <span><b>欢迎光临：</b>admin</span>
	 <span><b>你的IP是：</b>202.134.12.11</span>
	 <span><b>登陆时间：</b>2010-7-02 11：20：11</span>
   </div>
   <div id="logout">
     <a href="mred/admin/admin_logout">退出</a>   </div>
</div>
<!--网页主体部分-->
<div id="main">
   <div id="left">
     <dl>
     <dt id="system_control">系统设置</dt>
	    <dd><a href="mred/index">欢迎信息</a></dd>
	    <dd><a href="mred/focus/focus_browse?show_id=system_control">焦点广告</a></dd>
	    <dd><a href="mred/admin/admin_browse">管理员管理</a></dd>
	    <dd><a href="mred/html/createHtml">静态化</a></dd>
		<dd><a href="#"  target="mainframe" >全局设置</a></dd>

	 <dt id="article_control">文章管理</dt> 
		
		<dd><a href="mred/article/article_add?show_id=article_control">发布文章</a></dd>
		<dd><a href="mred/article/article_browse?show_id=article_control">管理文章</a></dd>
		<dd><a href="mred/article_types/article_types_init?show_id=article_control">文章类别</a></dd>

	 <dt id="course_control">课程管理</dt>
		<dd><a href="mred/course/chapter_browse?show_id=course_control">内容管理</a></dd>
		<dd><a href="mred/course/course_browse?show_id=course_control">管理课程</a></dd>
		<dd><a href="mred/course/course_add?show_id=course_control">增加新课程</a></dd>

	 <dt id="download_control">下载管理</dt>
	    <dd><a href="mred/download/download_add?show_id=download_control">增加下载</a></dd>
		<dd><a href="mred/download/download_browse?show_id=download_control" >管理下载</a></dd>
		<dd><a href="mred/downType/down_type_init?show_id=download_control" >下载类别</a></dd>
	
	 <dt id="question_control">问答管理</dt>
	    <dd><a href="mred/question/question_browse?show_id=question_control">管理问答</a></dd>
		<dd><a href="mred/question_types/question_types_init?show_id=question_control">问答类别</a></dd>
	  <dt id="member_control">会员管理</dt>
	    <dd><a href="mred/member/password_browseAll?show_id=member_control">密码管理</a></dd>
		<dd><a href="mred/member/member_browseAll?show_id=member_control">会员管理</a></dd>
	
	 </dl>
	<div class="clear"></div>
   </div>
   <div id="right">
      <decorator:body></decorator:body>
   </div>
   <div class="clear"></div>
   
</div>
<!--foot-->
<div id="foot">foot</div>
</body>
</html>
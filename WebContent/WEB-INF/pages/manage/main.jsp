<%@ page language="java" contentType="text/html; charset=GB18030" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>"/>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030"/>
<title>��������̨��ҳ</title>
<link href="res/css/global.css" rel="stylesheet" type="text/css" />
<style type="text/css">
#top,#middle,#foot{ width:1005px; margin:0px auto;}
#top{ height:60px; background:url(res/image/bak_top.jpg) no-repeat;}
#top img{ margin:20px 20px 0px 20px;}
#middle #menu{ float:left; width:160px;}
#middle #menu dl dt{ height:26px; line-height:26px; background-color:#CC0000; color:#FFFFFF; font-size:16px; font-weight:bold; padding-left:10px; border-left:5px #000000 solid; margin-bottom:2px; cursor:pointer;}
#middle #menu dl dd a{ display:block; text-decoration:none; color:#333333; font-weight:bold; height:24px; line-height:24px; padding-left:20px;}
#middle #menu dl dd a:hover,#middle #menu dl dd a:active{ background-color:#F5F5F5; text-decoration:underline;}


#middle #main{ float:left; width:840px;border-left:1px #CC0000 solid;}
#foot{height:60px; background:url(res/image/bak_top.jpg) no-repeat;}

</style>
<script language="javascript" src="res/js/jquery-1.5.1.min.js"></script>
<script language="javascript">
  /*��ʼ��dt ��dd ����ʾ*/
  $(function(){ 
  //ҳ����غ���������dd
  $("#menu dl dt").nextUntil("dt").hide();
  //ֻ��ʾ��һ��dd
  $("#menu dl dt").first().nextUntil("dt").show();
  });
  /*��dt���е����¼��������ʾ����*/
  $(function(){
     $("#menu dl dt").click(function(){
    	 var flag=$(this).next("dd").is(":hidden");
    	 if(flag)
    		 {
    		   //��ʾ
    		   $("#menu dl dd").hide();
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
<div id="top">
  <img src="res/image/logo2.gif"/>
</div>
<div id="middle">
  <div id="menu">
     <dl>
	   <dt>���¹���</dt>
		   <dd><a href="mred/article/add_article" target="main_frame">��������</a></dd>
		   <dd><a href="mred/article/browse_article" target="main_frame">��������</a></dd>
		   <dd><a href="mred/article_type/browse_article_type" target="main_frame">�������</a></dd>
	    <dt>���ع���</dt>
		   <dd><a href="mred/download/add_download" target="main_frame">�������</a></dd>
		   <dd><a href="mred/download/browse_download" target="main_frame">��������</a></dd>
		   <dd><a href="mred/download_type/browse_download_type" target="main_frame">�������</a></dd>
	    <dt>�γ̹���</dt>
	       <dd><a href="mred/course/add_course" target="main_frame">���ӿγ�</a></dd>
		   <dd><a href="mred/course/browse_course" target="main_frame">�γ̹���</a></dd>
		   <dd><a href="mred/course_type/browse_course_type" target="main_frame">�γ����</a></dd>		
		<dt>�������</dt>
		   <dd><a href="mred/question/browse_question" target="main_frame">�������</a></dd>
		   <dd><a href="mred/question_types/init_question_types" target="main_frame">�������</a></dd>
		<dt>��Ա����</dt>
	  	   <dd><a href="mred/member/browseAll_member" target="main_frame">��Ա����</a></dd>
		   <dd><a href="mred/member/browseAll_password" target="main_frame">�������</a></dd>
		   <dd><a href="mred/browse_duixian" target="main_frame">���ֹ���</a></dd>
	    <dt>ϵͳ����</dt>
		   <dd><a href="mred/focus/focus_browse" target="main_frame">������</a></dd>
		   <dd><a href="mred/createHtml" target="main_frame">���ɾ�̬ҳ��</a></dd>
		   <dd><a href="mred/admin/admin_browse" target="main_frame">����Ա</a></dd>
           <dd><a href="mred/admin/admin_logout" target="main_frame">��ȫ�˳�</a></dd>
	 
	 </dl>
  </div>
  <div id="main">
  <iframe src="mred/welcome" name="main_frame" width="840" height="800" marginwidth="0" marginheight="0" align="top" scrolling="auto" frameborder="0" hspace="0" vspace="0">�Բ��������������֧��iframe���</iframe></div>
  <div class="clear"></div>
</div>
<div id="foot">

</div>

</body>
</html>

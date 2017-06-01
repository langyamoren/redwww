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
<meta name="Keywords" content="����,java,��Ƶѧϰ,ѧϰ,IT,����,�ڿͼ���,linux,������,���" />
<meta name="Description" content="��������һ��ר�Ŵ���IT������ѵ����վ������ӵ����ʮ�꾭�飬���ǽ߳��з�IT�С��߶˿γ̣���ӵ����ȫ�����Ŀγ���ϵ�����ǵĿγ�����ʵ��ĿΪ������ϵͳ�ؽ�����ITӦ���еĸ��ּ��������������������������ϵͳ�����硢��ȫ�����������web����������˼ܹ����Ƽ��㣩�ȡ�����Ϊ���IT�����ߣ��ṩ��ϵͳ��IT������ѵ����ʵ��Ŀѵ��������ʵϰ��ʹ��Ա��������������������ϵļ�����ͬʱҲ�ṩ��������ȫά������ȫ�����������������վ�����ȷ�����Ŀ�����ǵ�Ŀ����'Ϊ��С���ʹ�ѧ����ļ���ƿ����������IT��ѵ��һƽ̨'���ܶ�" />


<title>������-<decorator:title/></title>
<link href="res/css/global.css" rel="stylesheet" type="text/css" />
<link href="res/dialog/dialog.css" rel="stylesheet" type="text/css" />
<script language="javascript" src="res/js/jquery-1.5.1.min.js"></script>
<script type="text/javascript" src="res/dialog/dialog.js"></script>

<decorator:head/>

<style type="text/css">
#top,#location,#main,#foot{ width:1000px; margin:0 auto;}
#top{ height:84px; background:url(res/image/redbak.gif) no-repeat 0 -72px; position:relative;}
/*��ӭ��Ϣ*/
#top p{ position:absolute; left:240px; top:16px; }
#top p a{text-decoration: none; color: #CC0000; font-weight:bold; font-size:14px;}
#top p a:hover{text-decoration:underline;}
#toplink{list-style:none;position:absolute;left:512px;top:4px;width: 478px;}
#toplink li{ float:right;}
#toplink li a{ text-decoration:none; color:#333333; font-weight:bold; padding:0 10px;}
#toplink li a:hover{ text-decoration:underline;}
/*��ҳ����*/
#navlink{ height:32px; width:710px; list-style:none; position:absolute; left:290px; top:52px; background:url(res/image/redbak.png);}
#navlink li{ float:left; }
#navlink li a{ display:block; line-height:26px; margin-top:6px; padding:0 10px; text-decoration:none; color:#FFFFFF; font-weight:bold; font-size:14px;}
#navlink li a:hover,#navlink li a:active{ background-color: #F8F8F8; color:#CC0000;}

#navlink li a.cur_home{ background-color: #F8F8F8; color:#CC0000;}
/*��ǰλ��*/
#location{height:25px;line-height:25px;color:#CC0000;font-weight:bold;background-color: #F8F8F8;}
#location p{ margin-left:10px; width:660px; float:left;}

/*��ҳ���岿��-����*/
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
	  out.println("��ӭ����"+member.getName()+"&nbsp;&nbsp;");
	  out.println("<a href ='red/myquestion_space'>�ҵĹ�������</a>");
	}else
	{
		out.println("�ο����ã��㻹û�е�½��");
	}
%>
</p>
<ul id="toplink">
   <li><a href="http://www.yy.com/go.html#54553966"><img src="http://www.yy.com/images/icon03.gif"/>YY����</a></li>
    <li><a href="http://list.qq.com/cgi-bin/qf_invite?id=a7b5ac53943c6bf685434baf41d28365f458c685c140967f">�����ʼ�</a></li>
   <li><a href="red/regist">ע��</a></li>
   <li><a href="red/login">��½</a></li>
   <li><a href="html/help.html">����</a></li>
      <%
       if(null!=session.getAttribute("redwww_user")&&!"".equals(session.getAttribute("redwww_user")))
	   {
	   out.println("<li><a href='red/logout'>�˳�</a></li>");
	   }
   %>
</ul>
<ul id="navlink">
	<li><a href="html/main.html" style="margin-left:10px;" class="cur_home">��ҳ</a></li>
	<li><a href="html/course/courses_1_.html">��Ʒ�γ�</a></li>
	<li><a href="html/articles.html">��������</a></li>
	<li><a href="red/question/questions">���ɽ��</a></li>
	<li><a href="html/downloads.html">�������</a></li>
	<li><a href="html/joinus.html">�����Ա</a></li>
	<li><a href="html/aboutus.html">��������</a></li>
</ul>
</div>
<div id="location">
  <p>�����ص�λ�ã���ҳ - <decorator:title/></p>
</div>
<div id="main">
  <div id="left">
   <decorator:body></decorator:body>
  </div>
  <!--�ұ�-->
  <div id="right">
         <s:include value="/html/right.html"></s:include>
  </div>
  <div style="clear:both;width:1000px;"></div>
</div>
<div id="foot" style="clear:both;">
<s:include value="/html/foot.html"></s:include>
 </div>
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
<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@taglib prefix="red" uri="http://www.redwww.com/tld" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>"/>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title></title>
<style type="text/css">
/*�Ҳ�����*/
#right #notice_list{ border:1px #CCCCCC solid; width:260px; height:100px; margin-bottom:10px;}
#right #notice_list ul{ list-style:none;}
#right #notice_list ul li{ line-height:24px; padding-left:10px;}
#right #notice_list ul li a{ color:#000000; text-decoration:none;}
#right #notice_list ul li a:hover{ text-decoration:underline;}

#right #topcourse_list{ border:1px #CCCCCC solid; width:260px; height:400px;}
#right #topcourse_list ul{ list-style:none;}
#right #topcourse_list ul li{ line-height:24px; padding-left:10px;}
#right #topcourse_list ul li a{ color:#000000; text-decoration:none;}
#right #topcourse_list ul li a:hover{ text-decoration:underline;}
</style>
</head>
<body>
  <!--��վ����-->
  	    <div id="notice_list">
		   <div class="tit_list">
           <h2>��վ����</h2>
		   <a href="#">����&nbsp;&nbsp;</a>
		   </div>
		   <ul>
		   <s:iterator value="noticeList">
		      
				<li><a href="<s:text name="red.html.article.path"></s:text>a<s:property value="articleType.id"/><s:property value="id"/>.html"><s:property value="title"/></a></li>
		  </s:iterator>
		   </ul>
		</div>
		<!--�ͷ�-->
		<div id="support_staff">
		<img src="res/image/support.png" width="260" height="101" />
		<p>
			 <a href="tencent://message/?uin=1613839994&Site=����QQ&Menu=yes">
			 <img border="0" src="http://wpa.qq.com/pa?p=2:1613839994:41" alt="���������ҷ���Ϣ">
			 </a>
			 <a href="tencent://message/?uin=9703239&Site=����QQ&Menu=yes">
			 <img border="0" src="http://wpa.qq.com/pa?p=2:9703239:41" alt="���������ҷ���Ϣ">
			 </a>
			 <a href="tencent://message/?uin=9703239&Site=����QQ&Menu=yes">
			 <img border="0" src="http://wpa.qq.com/pa?p=2:9703239:41" alt="���������ҷ���Ϣ">
			 </a>
		</p>
		</div>
		<!--google sdsend-->
		<div style="margin:10px 0;">
		<script type="text/javascript"><!--
google_ad_client = "ca-pub-2147148573164130";
/* 234x60, ������ 11-4-5 */
google_ad_slot = "3370933483";
google_ad_width = 234;
google_ad_height = 60;
//-->
</script>
<script type="text/javascript"
src="http://pagead2.googlesyndication.com/pagead/show_ads.js">
</script>
		</div>
		<!--���¿γ�-->
		<div id="topcourse_list">
		   <div class="tit_list">
           <h2>���¿γ�</h2>
		   <a href="html/courses.html">����&gt;&gt;</a>
		   </div>
		   <ul>
		     <s:iterator value="chapterList">
				<li><a href="html/course/c<s:property value="course.id"/>c<s:property value="id"/>.html">
				<s:property value="%{@com.red.util.HtmlRegexpUtil@getDesc(title,16)}"/>
				</a></li>
			</s:iterator>
			<!--  
				<li><a href="#">���������������շ��أ���</a></li>
			-->
		   </ul>
		</div>
		<!--google sdsend-->
		<div style="margin:5px 0;">
		<script type="text/javascript"><!--
google_ad_client = "ca-pub-2147148573164130";
/* �������� */
google_ad_slot = "2873697423";
google_ad_width = 250;
google_ad_height = 250;
//-->
</script>
<script type="text/javascript"
src="http://pagead2.googlesyndication.com/pagead/show_ads.js">
</script>


       </div>
</body>
</html>
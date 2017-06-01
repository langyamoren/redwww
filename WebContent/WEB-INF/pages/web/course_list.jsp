<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@taglib uri="http://jsptags.com/tags/navigation/pager" prefix="pg" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030" />
<meta name="Keywords" content="红萌网,计算机教程,视频学习,黑客教程,linux,unix,<s:property value="course.keywords"/>" />
<title>精品课程-<s:property value="course.title"/></title>
<style type="text/css">
#course_top{ border-bottom:1px #CCCCCC dashed;width:665px; margin:10px 20px 10px 20px;}
#course_top img{border:1px #CCCCCC solid;padding:2px; float:left; margin:0 10px;}
#course_top #top_right{ float:left; width:480px;}
#course_top h1{ border-bottom:1px #CCCCCC dashed; font-size:16px; width:485px; height:30px; line-height:30px;}
#course_top span{ display:block; line-height:25px;}
#course_top p{width:480px;line-height:20px;}

#cour_title{ clear:both; width:660px;}
#cour_title .cour_tit{ float:left; width:200px; margin-top:10px; color:#CC0000; font-size:14px; font-weight:bold; }
#cour_title .jia_code{ float:right;}


#course_list{ width:665px; margin:10px 20px 10px 20px;}
#course_list ul{ list-style:none;}
#course_list .chap_no{ width:45px; height:35px; line-height:35px; text-align:center; font-size:16px; color:#FFFFFF; font-weight:bold; background:url(res/image/redbak.png) no-repeat 0 -248px; float:left;}
#course_list .chap_tit{ float:left; margin-left:10px; width:600px; border-bottom:1px #CCCCCC dashed; margin-bottom:5px;}
#course_list .chap_tit .chap_wrap_tit{ border-bottom:1px #CCCCCC dashed; font-size:16px; line-height:30px; }
#course_list .chap_tit .chap_wrap_tit h1{ width:480px; float:left;}
#course_list .chap_tit .chap_wrap_tit p{float:right; font-size:12px; font-weight:100; width:120px;}

#course_list .chap_tit .chap_abs{margin:10px 0px;}
#course_list .chap_tit h1 a{ font-size:16px; text-decoration:none; width:480px; color:#333333;}
#course_list .chap_tit h1 a:hover{ text-decoration:underline; color:#CC0000;}
#course_list .chap_tit p{ line-height:20px;}
#course_list .chap_tit p a{ text-decoration:none; color:#333333;}
#course_list .chap_tit p a:hover{ text-decoration:underline;}

#course_list li center a{ text-decoration:none; color:#666666; font-weight:bold; font-size:12px;}
#course_list li center a:hover{ text-decoration:underline;}
</style>
</head>

<body>
	<div id="course_top">
          <img  src="res/upres/course_pic/<s:property value="course.picture"/>" width="140" height="80" alt="<s:property value="course.title"/>" />
	   <div id="top_right">
		   <h1><s:property value="course.title"/></h1>
		   <span><b>发布时间：</b><s:date name="course.dates" format="yyyy-MM-dd HH:mm:ss"/></span>
		   <p>
			 <s:property  value="descs" escape="false"/>
			</p>
		</div>
		<div class="clear"></div>
		<div id="cour_title">
		   <div  class="cour_tit">课程内容列表：</div>
		   <div  class="jia_code">
				<!-- JiaThis Button BEGIN -->
				<div id="jiathis_style_32x32">
					<a class="jiathis_button_qzone"></a>
					<a class="jiathis_button_tsina"></a>
					<a class="jiathis_button_tqq"></a>
					<a class="jiathis_button_kaixin001"></a>
					<a class="jiathis_button_renren"></a>
					<a href="http://www.jiathis.com/share/?uid=894307" class="jiathis jiathis_txt jtico jtico_jiathis" target="_blank"></a>
				</div>
				<script type="text/javascript">var jiathis_config = {"data_track_clickback":true};</script>
				<script type="text/javascript" src="http://v1.jiathis.com/code/jia.js?uid=894307" charset="utf-8"></script>
				<!-- JiaThis Button END -->	   
		   </div>
		   <div class="clear"></div>
		</div>
	</div>
	
	<div id="course_list">
	  <div style="width:665px; overflow:hidden; margin:10px 0px;">
		   <script type="text/javascript"><!--
		google_ad_client = "pub-2147148573164130";
		/* 红萌链接广告 */
		google_ad_slot = "3782925101";
		google_ad_width = 700;
		google_ad_height = 15;
		//-->
		</script>
		<script type="text/javascript"
		src="http://pagead2.googlesyndication.com/pagead/show_ads.js">
		</script>
   </div>
	  <ul>
	    <s:iterator value="list" status="stat">
	     <li>
		    <div class="chap_no"><s:property value="%{chapterNo-#stat.index}"/></div>
			<div class="chap_tit">
			   <div class="chap_wrap_tit">
				   <h1>
				   <a  target="_blank" href="html/course/c<s:property value="course.id"/>c<s:property value="id"/>.html"><s:property value="title"/></a></h1>
				   <p><s:date name="dates" format="yyyy-MM-dd HH:mm:ss"/></p>
				   <div class="clear"></div>
			   </div>
			   <p class="chap_abs">
			   <a  target="_blank" href="html/course/c<s:property value="course.id"/>c<s:property value="id"/>.html">
			    <s:property  value="%{@com.red.util.HtmlRegexpUtil@getDesc(content,120)}"/><b>[详细信息]</b></a>
				</a>
			   </p>
			</div>	
			<div class="clear">
			
			</div>
			
		 </li>
		 </s:iterator>	
		  <li><center style="clear:both;">
	<pg:pager
    url="red/course/courseList"
    items="${totalCount}"
    index="center"
    maxPageItems="20"
    maxIndexPages="10"
    isOffset="<%=true%>"
    export="offset,currentPageNumber=pageNumber"
    scope="page">
   <pg:param name="course.id" value="${course.id}"/>
			<pg:first>
			  <a href="html/course/course<s:property value="course.id"/>_1_.html">首页</a></pg:first>
			
			
			<pg:pages>
			   <a href="html/course/course<s:property value="course.id"/>_<%= pageNumber%>_.html"><%= pageNumber %></a></pg:pages>
		
			
		   	<pg:last>
			  <a href="html/course/course<s:property value="course.id"/>_<s:property value="totalCount%pageSize==0?totalCount/pageSize:totalCount/pageSize+1"/>_.html">最后一页</a></pg:last>
	</pg:pager>
	&nbsp;&nbsp;
	总共
	<font color="#FF0000">
	<s:property value="pager.offset/pageSize+1"/>
	</font>
	/
	<s:property value="totalCount%pageSize==0?totalCount/pageSize:totalCount/pageSize+1"/>页
	&nbsp;&nbsp;总共${totalCount}条	
				 </center></li>
	  </ul>
	</div>
</body>
</html>

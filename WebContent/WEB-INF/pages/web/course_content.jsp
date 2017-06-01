<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030" />
<meta name="Keywords" content="红萌网,计算机教程,视频学习,黑客教程,linux,unix,<s:property value="chapter.keywords"/>" />

<title>精品课程- <s:property value="chapter.course.title"/> - <s:property value="chapter.title"/></title>
<style type="text/css">
#chap_tit{ width:665px; border-bottom:1px #CCCCCC dashed; height:80px; position:relative; margin:10px 20px;}
#chap_tit #jia_code{width:226px;text-align:right;position:absolute;left: 435px;top: 48px;}
#chap_tit .chap_no{width:45px;height:35px;line-height:35px;text-align:center;font-size:16px;color:#FFFFFF;font-weight:bold;background:url(res/image/redbak.png) no-repeat 0 -248px;position:absolute;left:13px;top:13px;}
#chap_tit h1{position:absolute;font-size:16px;left: 71px;top: 19px;}
#chap_tit label{position:absolute;left: 70px;top: 44px;}
#chap_abs { width:600px; padding:20px; background-color:#F3F3F3; margin:16px;}
#chap_des{ width:600px; padding:20px; line-height:23px; border-bottom:1px #CCCCCC dashed;}
#chap_vod{ height:40px; line-height:40px;}
#chap_vod label{ font-weight:bold; color:#CC0000; float:left; margin-left:10px;}
#chap_vod ul{ float:left; list-style:none;}
#chap_vod ul li{ float:left; margin-right:10px;}
#chap_vod ul li a{ color:#666666; font-weight:bold; text-decoration:none;}
#chap_vod ul li a:hover{ text-decoration:underline;}
</style>
</head>

<body>
 <h1 style="font-size:16px;margin-left: 10px;"><s:property value="chapter.course.title"/></h1>
<div id="chap_tit">
   
    <div class="chap_no"><s:property value="chapNo"/></div>
	 <h1><s:property value="chapter.title"/></h1>
	 <label>2010-12-10</label>
     <div id="jia_code">
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
<div id="chap_abs">
<s:property value="chapter.abstracts" escape="false"/>
</div>
<div id="adsends" style="margin-left:10px; width:720px; overflow:hidden;">
<script type="text/javascript"><!--
google_ad_client = "pub-2147148573164130";
/* 红萌中间 */
google_ad_slot = "3286583940";
google_ad_width = 728;
google_ad_height = 90;
//-->
</script>
<script type="text/javascript"
src="http://pagead2.googlesyndication.com/pagead/show_ads.js">
</script>
</div>

<div id="chap_des">
<s:property value="chapter.content" escape="false"/>
</div>
<div  id="chap_vod">
  <s:if test="vodlist.size>0">
   <label>视频下载：</label>
   <ul>
       <s:iterator value="vodlist" status="stat">
		<li><a href="red/course/downvod?vodName=<s:property/>&chapterId=<s:property value="chapter.id"/>&index=<s:property value="#stat.index+1"/>">视频<s:property value="#stat.index+1"/></a></li>
       </s:iterator>
   </ul>
  </s:if>
</div>
</body>
</html>

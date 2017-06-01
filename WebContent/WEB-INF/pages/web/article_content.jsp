<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta name="Keywords" content="红萌网,计算机教程,视频学习,黑客教程,linux,unix,<s:property value="article.keyword"/>" />
<title>文章内容-<s:property value="article.title"/></title>
<style type="text/css">
#article{ width:665px; padding:2px; margin:10px 20px 10px 20px;}
#article h1{ font-size:26px; line-height:40px; height:40px;}
#article .article_tit{ height:30px; border-bottom:1px #CCCCCC solid; line-height:30px;}
#article #article_abs{ width:600px; background-color:#F3F3F3; margin:10px auto; padding:10px; line-height:24px;}
#article #article_content{ line-height:24px; width:600px;}
</style>
</head>

<body>
<div id="article">
   <h1><s:property value="article.title"/></h1>
   <p class="article_tit"><span>发布时间：</span><s:date name="article.dates" format="yyyy-MM-dd HH:mm:ss"/> <span> 来源：</span><s:property value="article.fromdesc"/> </p>
    <!--
   <div id="article_abs">
   
    <sproperty  value="article.abstracts"/>
   </div>
    -->
   <div style="width:640px; overflow:hidden; margin:10px 0px;">
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
   <div id="article_content">
        <s:property value="article.content" escape="false"/>
   </div>
</div>
</body>
</html>

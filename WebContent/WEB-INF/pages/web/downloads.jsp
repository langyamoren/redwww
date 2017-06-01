<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@taglib prefix="red" uri="http://www.redwww.com/tld" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>资料下载</title>
<style type="text/css">
.ariticle_top{ width:660px; border:1px #CCCCCC solid; padding:2px; margin:10px 20px 10px 30px;}
.ariticle_top ul{ list-style:none;}
.ariticle_top ul li{ line-height:30px; padding-left:10px; border-bottom:1px #CCCCCC dashed;}
.ariticle_top ul li a{ text-decoration:none; color:#333333;}
.ariticle_top ul li a:hover{ text-decoration:underline;}
</style>
</head>

<body>
<div>
<style type="text/css">
@import url(//www.google.com/cse/api/branding.css);
</style>
<div class="cse-branding-right" style="background-color:#FFFFFF;color:#000000; margin-top:10px; margin-left:30px;">
  <div class="cse-branding-form">
    <form action="http://www.redwww.com/html/search.html" id="cse-search-box">
      <div>
        <input type="hidden" name="cx" value="partner-pub-2147148573164130:rgjrrm1tnzq"/>
        <input type="hidden" name="cof" value="FORID:11" />
        <input type="hidden" name="ie" value="GB2312" />
        <input type="text" name="q" size="40" style="border:1px #CCCCCC solid; height:26px; line-height:26px;" />
        <input type="submit" name="sa" value="&#x641c;&#x7d22;"  style="border:1px #CCCCCC solid; height:26px; line-height:26px;" />
      </div>
    </form>
  </div>
  <div class="cse-branding-logo">
    <img src="//www.google.com/images/poweredby_transparent/poweredby_FFFFFF.gif" 

alt="Google" />
  </div>
  <div class="cse-branding-text">
    &#33258;&#23450;&#20041;&#25628;&#32034;
  </div>
</div>


</div>
<red:getDownloads itermMaxLen="64" url="red/download/downloadList?typeId=1" typeId="1" topCount="8" title="系统工具"/>
<red:getDownloads itermMaxLen="64" url="red/download/downloadList?typeId=2" typeId="2" topCount="8" title="网络工具"/>
<red:getDownloads itermMaxLen="64" url="red/download/downloadList?typeId=3" typeId="3" topCount="8" title="编程开发"/>
<red:getDownloads itermMaxLen="64" url="red/download/downloadList?typeId=4" typeId="4" topCount="8" title="安全工具"/>
<red:getDownloads itermMaxLen="64" url="red/download/downloadList?typeId=7" typeId="7" topCount="8" title="学习资料"/>
<!-- 
<div class="ariticle_top">
       <div class="tit_list">
           <h2>数据库</h2>
		   <a href="#">更多>></a>
	   </div>
       <ul>
				<li><a href="#">要想成为高手，需要哪些方面的知识？</a></li>
				<li><a href="#">红萌网到底怎样收费呢？？</a></li>
				<li><a href="#">为什么选择红萌 ？</a></li>
				<li><a href="#">要想成为高手，需要哪些方面的知识？</a></li>
				<li><a href="#">红萌网到底怎样收费呢？？</a></li>
				<li><a href="#">为什么选择红萌 ？</a></li>
				<li><a href="#">要想成为高手，需要哪些方面的知识？</a></li>
				<li><a href="#">红萌网到底怎样收费呢？？</a></li>
		   </ul>
</div>
 -->

</body>
</html>
<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@taglib prefix="red" uri="http://www.redwww.com/tld" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>��������</title>
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
<red:getArticles itermMaxLen="64" showDate="true" url="red/article/articleList?typeId=2" typeId="2" topCount="8" className="ariticle_top" title="ҵ������"/>
<red:getArticles itermMaxLen="64" showDate="true" url="red/article/articleList?typeId=3" typeId="3" topCount="8" className="ariticle_top" title="��ȫ"/>
<red:getArticles itermMaxLen="64" showDate="true" url="red/article/articleList?typeId=4" typeId="4" topCount="8" className="ariticle_top" title="Unix/Linux"/>
<red:getArticles itermMaxLen="64" showDate="true" url="red/article/articleList?typeId=5" typeId="5" topCount="8" className="ariticle_top" title="���ݿ�"/>
<red:getArticles itermMaxLen="64" showDate="true" url="red/article/articleList?typeId=7" typeId="7" topCount="8" className="ariticle_top" title="Web����"/>
<!-- 
<div class="ariticle_top">
       <div class="tit_list">
           <h2>���ݿ�</h2>
		   <a href="#">����>></a>
	   </div>
       <ul>
				<li><a href="#">Ҫ���Ϊ���֣���Ҫ��Щ�����֪ʶ��</a></li>
				<li><a href="#">���������������շ��أ���</a></li>
				<li><a href="#">Ϊʲôѡ����� ��</a></li>
				<li><a href="#">Ҫ���Ϊ���֣���Ҫ��Щ�����֪ʶ��</a></li>
				<li><a href="#">���������������շ��أ���</a></li>
				<li><a href="#">Ϊʲôѡ����� ��</a></li>
				<li><a href="#">Ҫ���Ϊ���֣���Ҫ��Щ�����֪ʶ��</a></li>
				<li><a href="#">���������������շ��أ���</a></li>
		   </ul>
</div>
 -->

</body>
</html>

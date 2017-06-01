<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@taglib uri="http://jsptags.com/tags/navigation/pager" prefix="pg" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title><s:property value="type.name"/></title>
<style type="text/css">
.ariticle_top{ width:680px; border:1px #CCCCCC solid; padding:2px; margin:10px 20px 10px 20px;}
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
<div class="ariticle_top">
       <div class="tit_list">
           <h2><s:property value="type.name"/></h2>
		   
	   </div>
       <ul>
                <s:iterator value="list" status="stat">
				  <li>
				  <a target="_blank" href="<s:text name="red.html.article.path"></s:text>a<s:property value="articleType.id"/><s:property value="id"/>.html"><s:property value="#stat.index+1"/>&nbsp;<s:property value="title"/></a>
				  
				  <font color="#CC0000;" style="margin-left:20px;">
				  <s:date name="dates" format="yyyy-MM-dd HH:mm:ss" />
				  </font>
				  </li>
				 </s:iterator>
				 <li><center>
				     <pg:pager
    url="red/article/articleList"
    items="${totalCount}"
    index="center"
    maxPageItems="20"
    maxIndexPages="10"
    isOffset="<%=true%>"
    export="offset,currentPageNumber=pageNumber"
    scope="page">
    <pg:param name="typeId" value="${typeId}"/>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<pg:first>
			  <a href="<%= pageUrl %>">首页</a></pg:first>
			
			<pg:prev>
			  <a href="<%= pageUrl %>">上一页</a></pg:prev>
			<pg:pages>
			   <a href="<%= pageUrl %>"><%= pageNumber %></a></pg:pages>
			<pg:next>
			  <a href="<%= pageUrl %>">下一页</a></pg:next>
			
			<pg:last>
			  <a href="<%= pageUrl %>">最后一页</a></pg:last>
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
	  <div class="pagediv"></div>	  
</div>

</body>
</html>


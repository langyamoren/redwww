<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>�������-<s:property value="download.downType.name"/>-<s:property value="download.title"/></title>

<style type="text/css">
  #download{ width:665px; padding:10px;}
  #download h1{ height:30px; line-height:30px; background-color:#EFEFEF; font-size:16px; padding-left:10px; margin:10px;}
  .down_file{ color:#FFFFFF; font-weight:bold; display:block; width:80px; text-align:center; text-decoration:none; height:30px; line-height:30px; background-color:#CC0000;}
  .down_contents{line-height:24px; padding:10px; width:600px;}
</style>
</head>

<body>
<div id="download">
  <h1><s:property value="download.title"/></h1>
  <table width="660" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td width="241" rowspan="5" align="center" valign="middle">
<script type="text/javascript"><!--
google_ad_client = "pub-2147148573164130";
/* 200x200, ������ 11-4-6 */
google_ad_slot = "6632635618";
google_ad_width = 200;
google_ad_height = 200;
//-->
</script>
<script type="text/javascript"
src="http://pagead2.googlesyndication.com/pagead/show_ads.js">
</script>
      <!-- 
      <img src="res/upres/soft_pic/<sproperty value="download.picture"/>" width="200" height="140" alt="" />
       -->
      </td>
      <td width="86" height="30" align="right" valign="middle"><strong>������</strong></td>
      <td width="122" align="left" valign="middle"><s:property value="download.downType.name"/></td>
      <td width="80" align="right" valign="middle"><strong>������ԣ�</strong></td>
      <td width="131" align="left" valign="middle"><s:property value="download.language"/></td>
    </tr>
    <tr>
      <td height="30" align="right" valign="middle"><strong>��Ȩ��ʽ��</strong></td>
      <td align="left" valign="middle">
      <s:if test="download.isfree==false">
             ���
      </s:if>
      <s:else>
              �շ�
      </s:else>
      <td align="right" valign="middle"><strong>Ӧ��ƽ̨��</strong></td>
      <td align="left" valign="middle"><s:property value="platform"/></td>
    </tr>
    <tr>
      <td height="30" align="right" valign="middle"><strong>�Ƿ��Ƽ���</strong></td>
      <td align="left" valign="middle">
       <s:if test="download.ispop==false">
             ���Ƽ�
      </s:if>
      <s:else>
             �Ƽ�
      </s:else>
     </td>
      <td align="right" valign="middle"><strong>�����С��</strong></td>
      <td align="left" valign="middle"><s:property value="download.sizes"/>M</td>
    </tr>
    <tr>
      <td height="30" align="right" valign="middle"><strong>����ʱ�䣺</strong></td>
      <td align="left" valign="middle"><s:date name="download.dates" format="yyyy-MM-dd HH:mm:ss"/></td>
      <td align="right" valign="middle"><strong>�ļ����֣�</strong></td>
      <td align="left" valign="middle"><s:property value="download.oldName"/></td>
    </tr>
    <tr>
      <td height="30" align="left" valign="middle">
      <s:if test="download.softFile!=null and not download.softFile.equals('')">
      <a href="red/download/downloadFile?downId=<s:property value="download.id"/>" class="down_file">�������</a></td>
     </s:if>
      <td height="30" colspan="3" align="left" valign="middle">
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
	  </td>
    </tr>
  </table>
  <h1>�������</h1>
  <div class="down_contents"> 
    <s:property value="download.descs" escape="false"/>
  </div>
  <h1>�������˵��</h1>
  <div class="down_contents">
    <ul>
      <li>1���Ƽ�ʹ��Ѹ�׵����ع������ر�վ�����ʹ�� WinRAR v3.10 ���ϰ汾��ѹ��վ�����</li>
      <li>2�����������������أ������Ա������,лл������</li>
      <li>3�����ر�վ��Դʱ���������������æ�ݲ������ص���������һ��ʱ�����ԡ�</li>
      <li>4����������κ�������飬��ӭ���������ԣ����ǽ��ṩ���� �����õ���Դ��</li>
      <li>5����վ�ṩ��һЩ��ҵ����ǹ�ѧϰ�о�֮�ã���������ҵ��;���빺�����档</li>
    </ul>
  </div>
  
  
</div>

</body>
</html>

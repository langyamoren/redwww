<%
/* *
 ���ܣ���������ת��ҳ�棨ҳ����תͬ��֪ͨҳ�棩
 �汾��3.1
 ���ڣ�2010-11-01
 ˵����
 ���´���ֻ��Ϊ�˷����̻����Զ��ṩ���������룬�̻����Ը����Լ���վ����Ҫ�����ռ����ĵ���д,����һ��Ҫʹ�øô��롣
 �ô������ѧϰ���о�֧�����ӿ�ʹ�ã�ֻ���ṩһ���ο���

 //***********ҳ�湦��˵��***********
 ��ҳ����ڱ������Բ���
 ��ҳ�������ҳ����תͬ��֪ͨҳ�桱������֧����������ͬ�����ã��ɵ�����֧����ɺ����ʾ��Ϣҳ���硰����ĳĳĳ���������ٽ����֧���ɹ�����
 �ɷ���HTML������ҳ��Ĵ���Ͷ���������ɺ�����ݿ���³������
 TRADE_FINISHED(��ʾ�����Ѿ��ɹ�������Ϊ��ͨ��ʱ���ʵĽ���״̬�ɹ���ʶ);
 TRADE_SUCCESS(��ʾ�����Ѿ��ɹ�������Ϊ�߼���ʱ���ʵĽ���״̬�ɹ���ʶ);
 //********************************
 * */
%>
<%@ page language="java" contentType="text/html; charset=GB18030" pageEncoding="GB18030"%>
<%@ page import="java.util.*"%>
<%@ page import="java.util.Map"%>
<%@ page import="com.alipay.util.*"%>
<%@ page import="com.alipay.config.*"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
  <head>
   <base href="<%=basePath%>"> 
   <sj:head debug="true" compressed="false" jquerytheme="showcase" customBasepath="themes"/>
		<meta http-equiv="Content-Type" content="text/html; charset=GBK">
		<title>֧���ɹ��ͻ��˷���</title>
		<link href="res/css/global.css" rel="stylesheet" type="text/css">
<style type="text/css">
.font_content{
    font-family:"����";
    font-size:14px;
    color:#FF6600;
}
.font_title{
    font-family:"����";
    font-size:16px;
    color:#FF0000;
    font-weight:bold;
}
table{
    border: 1px solid #CCCCCC;
}
#container{
width:780px;
margin:5 auto;
}
#tit_top #redBlock{ width:15px; height:30px; float:left; background-color:#CC0000;}
#tit_top h1{ float:left; width:150px; height:30px; line-height:30px; font-size:16px; margin-left:5px;}
#tit_top #membr_info{ height:30px; }
#tit_top #member_info p{ float:left; margin:0 10px; line-height:30px;}
#space_nav{ margin:10px auto; height:18px;}
#space_nav ul{list-style:none;}
#space_nav ul li{ float:left;}
#space_nav ul li a{ display:block; width:100px; height:16px; border-right:6px #CC0000 solid; color:#333333; text-decoration:none; font-size:14px; font-weight:bold; line-height:16px; text-align:center;}
#space_nav ul li a:hover{text-decoration:underline; color:#CC0000;}
</style>
  </head>
  <body>
<%--
	String key = AlipayConfig.key;
	//��ȡ֧����GET����������Ϣ
	Map params = new HashMap();
	Map requestParams = request.getParameterMap();
	for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
		String name = (String) iter.next();
		String[] values = (String[]) requestParams.get(name);
		String valueStr = "";
		for (int i = 0; i < values.length; i++) {
			valueStr = (i == values.length - 1) ? valueStr + values[i]
					: valueStr + values[i] + ",";
		}
		//����������δ����ڳ�������ʱʹ�á����mysign��sign�����Ҳ����ʹ����δ���ת��
		valueStr = new String(valueStr.getBytes("ISO-8859-1"), "GBK");
		params.put(name, valueStr);
	}
	
	//�ж�responsetTxt�Ƿ�Ϊture�����ɵ�ǩ�����mysign���õ�ǩ�����sign�Ƿ�һ��
	//responsetTxt�Ľ������true����������������⡢���������ID��notify_idһ����ʧЧ�й�
	//mysign��sign���ȣ��밲ȫУ���롢����ʱ�Ĳ�����ʽ���磺���Զ�������ȣ��������ʽ�й�
	String mysign = AlipayNotify.GetMysign(params,key);
	String responseTxt = AlipayNotify.Verify(request.getParameter("notify_id"));
	String sign = request.getParameter("sign");
	
	//д��־��¼����Ҫ���ԣ���ȡ����������ע�ͣ�
	//String sWord = "responseTxt=" + responseTxt + "\n return_url_log:sign=" + sign + "&mysign=" + mysign + "\n return�����Ĳ�����" + AlipayFunction.CreateLinkString(params);
	//AlipayFunction.LogResult(sWord);

	//��ȡ֧������֪ͨ���ز������ɲο������ĵ���ҳ����תͬ��֪ͨ�����б�(���½����ο�)//
	String trade_no = request.getParameter("trade_no");				//֧�������׺�
	String order_no = request.getParameter("out_trade_no");	        //��ȡ������
	String total_fee = request.getParameter("total_fee");	        //��ȡ�ܽ��
	String subject = new String(request.getParameter("subject").getBytes("ISO-8859-1"),"GBK");//��Ʒ���ơ���������
	String body = "";
	if(request.getParameter("body") != null){
		body = new String(request.getParameter("body").getBytes("ISO-8859-1"), "GBK");//��Ʒ������������ע������
	}
	String buyer_email = request.getParameter("buyer_email");		//���֧�����˺�
	String trade_status = request.getParameter("trade_status");		//����״̬
	//��ȡ֧������֪ͨ���ز������ɲο������ĵ���ҳ����תͬ��֪ͨ�����б�(���Ͻ����ο�)//

	String verifyStatus = "";
	
	if(mysign.equals(sign) && responseTxt.equals("true")){
		//////////////////////////////////////////////////////////////////////////////////////////
		//������������̻���ҵ���߼��������

		//�������������ҵ���߼�����д�������´�������ο�������	
		if(trade_status.equals("TRADE_FINISHED") || trade_status.equals("TRADE_SUCCESS")){
			//�жϸñʶ����Ƿ����̻���վ���Ѿ����������ɲο������ɽ̡̳��С�3.4�������ݴ�����
				//���û�������������ݶ����ţ�out_trade_no�����̻���վ�Ķ���ϵͳ�в鵽�ñʶ�������ϸ����ִ���̻���ҵ�����
				//���������������ִ���̻���ҵ�����
		}
		System.out.println("-----------456---------------------------------");
		verifyStatus = "��֤�ɹ�";
		//�������������ҵ���߼�����д�������ϴ�������ο�������
		
		//////////////////////////////////////////////////////////////////////////////////////////
	}else{
		System.out.println("-----------789---------------------------------");
		verifyStatus = "��֤ʧ��";
	}
--%>
<div id="container">
    <%@include file="top.jsp" %>
<table align="center" width="350" cellpadding="5" cellspacing="0">
            <tr>
                <td align="center" class="font_title" colspan="2">
                    ��ֵ�ɹ�</td>
            </tr>
            <tr>
                <td class="font_content" align="right">
                    ֧�������׺ţ�</td>
                <td class="font_content" align="left"><s:property value="trade_no"/></td>
            </tr>
            <tr>
                <td class="font_content" align="right">
                    �����ţ�</td>
                <td class="font_content" align="left"><s:property value="order_no"/></td>
            </tr>
            <tr>
                <td class="font_content" align="right">
                    �����ܽ�</td>
                <td class="font_content" align="left"><s:property value="total_fee"/></td>
            </tr>
            <tr>
                <td class="font_content" align="right">
                    ��Ʒ���⣺</td>
                <td class="font_content" align="left"><s:property value="subject"/></td>
            </tr>
            <tr>
                <td class="font_content" align="right">
                    ��Ʒ������</td>
                <td class="font_content" align="left"><s:property value="body"/></td>
            </tr>
            <tr>
                <td class="font_content" align="right">
                    ����˺ţ�</td>
                <td class="font_content" align="left"><s:property value="buyer_email"/></td>
            </tr>
            <tr>
                <td class="font_content" align="right">
                    ����״̬��</td>
                <td class="font_content" align="left"><s:property value="trade_status"/></td>
            </tr>
            <tr>
                <td class="font_content" align="right">
                    ��֤״̬��</td>
                <td class="font_content" align="left"><s:property value="verifyStatus"/></td>
            </tr>
        </table>
 </div>
  </body>
</html>

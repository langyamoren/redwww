
<%
	/*
	���ܣ�������Ʒ�й���Ϣ�����ҳ��
	 *��ϸ����ҳ���ǽӿ����ҳ�棬����֧��ʱ��URL
	 *�汾��3.1
	 *���ڣ�2010-11-01
	 *˵����
	 *���´���ֻ��Ϊ�˷����̻����Զ��ṩ���������룬�̻����Ը����Լ���վ����Ҫ�����ռ����ĵ���д,����һ��Ҫʹ�øô��롣
	 *�ô������ѧϰ���о�֧�����ӿ�ʹ�ã�ֻ���ṩһ���ο���
	
	 *************************ע��*****************
	������ڽӿڼ��ɹ������������⣬
	�����Ե��̻��������ģ�https://b.alipay.com/support/helperApply.htm?action=consultationApply�����ύ���뼯��Э�������ǻ���רҵ�ļ�������ʦ������ϵ��Э�������
	��Ҳ���Ե�֧������̳��http://club.alipay.com/read-htm-tid-8681712.html��Ѱ����ؽ������
	Ҫ���ݵĲ���Ҫô������Ϊ�գ�Ҫô�Ͳ�Ҫ���������������ؿؼ���URL�����
	 **********************************************
	 */
%>
<%@ page language="java" contentType="text/html; charset=GBK"
	pageEncoding="GBK"%>
<%@ page import="com.alipay.config.*"%>
<%@ page import="com.alipay.util.*"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
	    <base href="<%=basePath%>"> 
		<meta http-equiv="Content-Type" content="text/html; charset=GBK">
		<title>֧������ʱ���ʸ���</title>
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
		</style>
	</head>
	<%
		//request.setCharacterEncoding("UTF-8");
			//AlipyConfig.java��������Ϣ���������޸ģ�
			String input_charset = AlipayConfig.input_charset;
			String sign_type = AlipayConfig.sign_type;
			String seller_email = AlipayConfig.seller_email;
			String partner = AlipayConfig.partner;
			String key = AlipayConfig.key;

			String show_url = AlipayConfig.show_url;
			String notify_url = AlipayConfig.notify_url;
			String return_url = AlipayConfig.return_url;
			
			///////////////////////////////////////////////////////////////////////////////////
			
			//���²�������Ҫͨ���µ�ʱ�Ķ������ݴ���������
			//�������
			UtilDate date = new UtilDate();//��ȡ֧�������������ɶ�����
	        String out_trade_no = date.getOrderNum();//�������վ����ϵͳ�е�Ψһ������ƥ��
	        //�������ƣ���ʾ��֧��������̨��ġ���Ʒ���ơ����ʾ��֧�����Ľ��׹���ġ���Ʒ���ơ����б��
	       // String subject = new String(request.getParameter("aliorder").getBytes("ISO-8859-1"),"GBK");
	        String subject = new String("��������ֵ");
	        //����������������ϸ��������ע����ʾ��֧��������̨��ġ���Ʒ��������
	        //String body = new String(request.getParameter("alibody").getBytes("ISO-8859-1"),"GBK");
	        String body = (String)request.getAttribute("memberName")+new String("��ֵ");
	        //�����ܽ���ʾ��֧��������̨��ġ�Ӧ���ܶ��
	        String total_fee = (String)request.getAttribute("alimoney");        
	        //��չ���ܲ�������Ĭ��֧����ʽ
	        //String pay_mode = request.getParameter("pay_bank");
	        String pay_mode="CMB";//Ĭ����������
	        String paymethod = "bankPay";		//Ĭ��֧����ʽ���ĸ�ֵ��ѡ��bankPay(����); cartoon(��ͨ); directPay(���); CASH(����֧��)
	        String defaultbank = "";	//Ĭ���������ţ������б��http://club.alipay.com/read.php?tid=8681379
	        if(pay_mode.equals("directPay")){
	        	paymethod = "directPay";
	        }
	        else{
	        	paymethod = "bankPay";
	        	defaultbank = pay_mode;
	        }
	        
	        //��չ���ܲ�������������
	        //������ѡ���Ƿ��������㹦��
			//exter_invoke_ip��anti_phishing_keyһ�������ù�����ô���Ǿͻ��Ϊ�������
			//���������㹦�ܺ󣬷��������������Ա���֧��Զ��XML�����������úøû�����
			//����ʹ��POST��ʽ��������
	        String anti_phishing_key  = "";					//������ʱ���
	        String exter_invoke_ip= request.getRemoteAddr();//��ȡ�ͻ��˵�IP��ַ�����飺��д��ȡ�ͻ���IP��ַ�ĳ���
	        //�磺
	        //anti_phishing_key = AlipayFunction.query_timestamp(partner);	//��ȡ������ʱ�������
	        //exter_invoke_ip = "202.1.1.1";					

	        
	        //��չ���ܲ�����������
	        String extra_common_param =(String)request.getAttribute("extra_common_param");//�Զ���������ɴ���κ����ݣ���=��&�������ַ��⣩��������ʾ��ҳ����
	        String buyer_email =(String)request.getAttribute("buyer_email");;					//Ĭ�����֧�����˺�
	        
	        //��չ���ܲ�����������(��Ҫʹ�ã��밴��ע��Ҫ��ĸ�ʽ��ֵ)
	        String royalty_type = "";					//������ͣ���ֵΪ�̶�ֵ��10������Ҫ�޸�
	        String royalty_parameters ="";
			//�����Ϣ��������Ҫ����̻���վ���������̬��ȡÿ�ʽ��׵ĸ������տ��˺š��������������˵�������ֻ������10��
			//����������ܺ���С�ڵ���total_fee
			//�����Ϣ����ʽΪ���տEmail_1^���1^��ע1|�տEmail_2^���2^��ע2
			//�磺
			//royalty_type = "10"
			//royalty_parameters	= "111@126.com^0.01^����עһ|222@126.com^0.01^����ע��"
			
	        /////////////////////////////////////////////////////////////////////////////////////////////////////
			
			//����Ҫ����Ĳ������飬����Ķ�
	        String sHtmlText = AlipayService.BuildForm(partner,seller_email,return_url,notify_url,show_url,out_trade_no,
			subject,body,total_fee,paymethod,defaultbank,anti_phishing_key,exter_invoke_ip,extra_common_param,buyer_email,
			royalty_type,royalty_parameters,input_charset,key,sign_type);
	%>

	<body>
        <table align="center" width="350" cellpadding="5" cellspacing="0">
            <tr>
                <td align="center" class="font_title" colspan="2">����ȷ��</td>
            </tr>
            <tr>
                <td class="font_content" align="right">�����ţ�</td>
                <td class="font_content" align="left"><%=out_trade_no%></td>
            </tr>
            <tr>
                <td class="font_content" align="right">�����ܽ�</td>
                <td class="font_content" align="left"><%=total_fee%></td>
            </tr>
            <tr>
                <td align="center" colspan="2"><%=sHtmlText%></td>
            </tr>
            
        </table>
	</body>
</html>

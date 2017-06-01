package com.red.action.web;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.alipay.config.AlipayConfig;
import com.alipay.util.AlipayNotify;
import com.opensymphony.xwork2.ActionContext;
import com.red.action.ActionBase;
import com.red.beans.Member;

public class AlipayAction extends ActionBase 
{
	public static final Logger log=Logger.getLogger(AlipayAction.class);
	private Member member;
	private static final long serialVersionUID = 6608672518221162066L;
    private Integer orderAmount ;  //zhunzhi.jsp��װ�Ĳ���
	private String alimoney;   //alipayto.jsp��Ҫ�Ĳ���
	private String extra_common_param;//�Զ���������ɴ���κ����ݣ���=��&�������ַ��⣩��������ʾ��ҳ���� ���û�id
	private String memberName;
	//-------------------------------------------------------
	private String trade_no;
	private String order_no ;
	private String total_fee ;//��ȡ�ܽ��
	private String subject ;//��Ʒ���ơ���������
	private String body;
	private String buyer_email ;
	private String trade_status;
	private String verifyStatus="";
	
	//-----------------------------
	private String sign;
	private String notify_id;
	public String topayAlipay()throws Exception
	{
		if(null!=orderAmount&&orderAmount>0)
		{
			HttpServletRequest request=ServletActionContext.getRequest();
			alimoney=orderAmount.toString();
			request.setAttribute("alimoney", alimoney);
			Member mm=(Member)ActionContext.getContext().getSession().get("redwww_user");
			if(null!=mm&&null!=mm.getId()&&mm.getId()>0)
			{
				memberName=mm.getName();
				request.setAttribute("memberName", memberName);
				buyer_email=mm.getEmail();
				request.setAttribute("buyer_email", buyer_email);
				extra_common_param=mm.getId().toString().trim();
				request.setAttribute("extra_common_param", extra_common_param);
			}
			
		}else
		{
			alimoney="0";
		}
		return "topay";
	}
	
	public String backpayAlipay()throws Exception
	{
		
		String key = AlipayConfig.key;
		HttpServletRequest request=ServletActionContext.getRequest();
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
		 trade_no = request.getParameter("trade_no");				//֧�������׺�
		 order_no = request.getParameter("out_trade_no");	        //��ȡ������
		total_fee = request.getParameter("total_fee");	        //��ȡ�ܽ��
		// subject = new String(request.getParameter("subject").getBytes("ISO-8859-1"),"GBK");//��Ʒ���ơ���������
		// body = "";
		//if(request.getParameter("body") != null){
		//	body = new String(request.getParameter("body").getBytes("ISO-8859-1"), "GBK");//��Ʒ������������ע������
		//}
		 buyer_email = request.getParameter("buyer_email");		//���֧�����˺�
		 trade_status = request.getParameter("trade_status");		//����״̬
		//��ȡ֧������֪ͨ���ز������ɲο������ĵ���ҳ����תͬ��֪ͨ�����б�(���Ͻ����ο�)//

		 verifyStatus = "";
		    //System.out.println("����*****mysing:"+mysign);
			//System.out.println("����*****singn:"+sign);
			//System.out.println("����*****redponseTxt:"+responseTxt);
			//System.out.println("trade_status:"+trade_status);
			//System.out.println("trade_status:"+trade_status);
			//System.out.println("extra_common_param:"+extra_common_param);
		if(mysign.equals(sign) && responseTxt.equals("true")){
			//////////////////////////////////////////////////////////////////////////////////////////
			//������������̻���ҵ���߼��������

			//�������������ҵ���߼�����д�������´�������ο�������	
			if(trade_status.equals("TRADE_FINISHED") || trade_status.equals("TRADE_SUCCESS"))
			{
				Integer memberId=Integer.parseInt(extra_common_param);
				if(null!=memberId&&memberId>0)
				{
					member =memberService.getMemberById(memberId);
					ActionContext.getContext().getSession().put("redwww_user",member);
					
				}
				
				
				//�жϸñʶ����Ƿ����̻���վ���Ѿ����������ɲο������ɽ̡̳��С�3.4�������ݴ�����
					//���û�������������ݶ����ţ�out_trade_no�����̻���վ�Ķ���ϵͳ�в鵽�ñʶ�������ϸ����ִ���̻���ҵ�����
					//���������������ִ���̻���ҵ�����
				this.addActionMessage("��ֵ�ɹ�");
			}
			//System.out.println("-----------456---------------------------------");
			verifyStatus = "��֤�ɹ�";
			//�������������ҵ���߼�����д�������ϴ�������ο�������
			
			//////////////////////////////////////////////////////////////////////////////////////////
		}else{
			//System.out.println("-----------789---------------------------------");
			verifyStatus = "��֤ʧ��";
			this.addActionMessage("��ֵʧ��");
		}
		return "backpay";
	}
/**************************notify*************************************/	
	public String notifyAlipay()throws Exception
	{
		String key = AlipayConfig.key;
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("text/html; charset=GBK");
		PrintWriter out=response.getWriter();
	
		//��ȡ֧����POST����������Ϣ
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
			//valueStr = new String(valueStr.getBytes("ISO-8859-1"), "GBK");
			params.put(name, valueStr);
		}
		
		//�ж�responsetTxt�Ƿ�Ϊture�����ɵ�ǩ�����mysign���õ�ǩ�����sign�Ƿ�һ��
		//responsetTxt�Ľ������true����������������⡢���������ID��notify_idһ����ʧЧ�й�
		//mysign��sign���ȣ��밲ȫУ���롢����ʱ�Ĳ�����ʽ���磺���Զ�������ȣ��������ʽ�й�
		String mysign = AlipayNotify.GetMysign(params,key);
		String responseTxt = AlipayNotify.Verify(request.getParameter("notify_id"));
		String sign = request.getParameter("sign");
		
		//д��־��¼����Ҫ���ԣ���ȡ����������ע�ͣ�
		//String sWord = "responseTxt=" + responseTxt + "\n notify_url_log:sign=" + sign + "&mysign=" + mysign + "\n notify�����Ĳ�����" + AlipayFunction.CreateLinkString(params);
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
		//System.out.println("notify*****mysing:"+mysign);
		//System.out.println("notify*****singn:"+sign);
		//System.out.println("notify*****redponseTxt:"+responseTxt);
		if(mysign.equals(sign) && responseTxt.equals("true")){//��֤�ɹ�
			
			//////////////////////////////////////////////////////////////////////////////////////////
			//������������̻���ҵ���߼��������

			//�������������ҵ���߼�����д�������´�������ο�������
			if(trade_status.equals("TRADE_FINISHED") || trade_status.equals("TRADE_SUCCESS"))
			{
				Integer memberId=Integer.parseInt(extra_common_param);
				if(null!=memberId&&memberId>0)
				{
					if(!spaceService.orderExsit(order_no))
					{		
					    int dotIndex=total_fee.indexOf(".");
						if(spaceService.chunZhi(memberId, trade_no, order_no,Integer.parseInt(total_fee.substring(0,dotIndex)), 1))
						{
			              log.info(memberId+"��ֵ�ɹ�");
						}
					}
				}
				//�жϸñʶ����Ƿ����̻���վ���Ѿ����������ɲο������ɽ̡̳��С�3.4�������ݴ�����
					//���û�������������ݶ����ţ�out_trade_no�����̻���վ�Ķ���ϵͳ�в鵽�ñʶ�������ϸ����ִ���̻���ҵ�����
					//���������������ִ���̻���ҵ�����
				
				out.println("success");	//�벻Ҫ�޸Ļ�ɾ��
			} else {
				out.println("success");	//�벻Ҫ�޸Ļ�ɾ��
			}
			//�������������ҵ���߼�����д�������ϴ�������ο�������

			//////////////////////////////////////////////////////////////////////////////////////////
		}else{//��֤ʧ��
			out.println("fail");
		}
		
		out.close();
		
		return null;
	}

	public Integer getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(Integer orderAmount) {
		this.orderAmount = orderAmount;
	}

	public String getAlimoney() {
		return alimoney;
	}

	public void setAlimoney(String alimoney) {
		this.alimoney = alimoney;
	}

	public String getTrade_no() {
		return trade_no;
	}

	public void setTrade_no(String trade_no) {
		this.trade_no = trade_no;
	}

	public String getOrder_no() {
		return order_no;
	}

	public void setOrder_no(String order_no) {
		this.order_no = order_no;
	}

	public String getTotal_fee() {
		return total_fee;
	}

	public void setTotal_fee(String total_fee) {
		this.total_fee = total_fee;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getBuyer_email() {
		return buyer_email;
	}

	public void setBuyer_email(String buyer_email) {
		this.buyer_email = buyer_email;
	}

	public String getTrade_status() {
		return trade_status;
	}

	public void setTrade_status(String trade_status) {
		this.trade_status = trade_status;
	}

	public String getVerifyStatus() {
		return verifyStatus;
	}

	public void setVerifyStatus(String verifyStatus) {
		this.verifyStatus = verifyStatus;
	}

	public String getExtra_common_param() {
		return extra_common_param;
	}

	public void setExtra_common_param(String extra_common_param) {
		this.extra_common_param = extra_common_param;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getNotify_id() {
		return notify_id;
	}

	public void setNotify_id(String notify_id) {
		this.notify_id = notify_id;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}


	
	
}

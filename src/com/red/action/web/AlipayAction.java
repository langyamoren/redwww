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
    private Integer orderAmount ;  //zhunzhi.jsp封装的参数
	private String alimoney;   //alipayto.jsp需要的参数
	private String extra_common_param;//自定义参数，可存放任何内容（除=、&等特殊字符外），不会显示在页面上 放用户id
	private String memberName;
	//-------------------------------------------------------
	private String trade_no;
	private String order_no ;
	private String total_fee ;//获取总金额
	private String subject ;//商品名称、订单名称
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
		//获取支付宝GET过来反馈信息
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
			//乱码解决，这段代码在出现乱码时使用。如果mysign和sign不相等也可以使用这段代码转化
			valueStr = new String(valueStr.getBytes("ISO-8859-1"), "GBK");
			params.put(name, valueStr);
		}
		
		//判断responsetTxt是否为ture，生成的签名结果mysign与获得的签名结果sign是否一致
		//responsetTxt的结果不是true，与服务器设置问题、合作身份者ID、notify_id一分钟失效有关
		//mysign与sign不等，与安全校验码、请求时的参数格式（如：带自定义参数等）、编码格式有关
		String mysign = AlipayNotify.GetMysign(params,key);
		String responseTxt = AlipayNotify.Verify(request.getParameter("notify_id"));
		String sign = request.getParameter("sign");
		
		//写日志记录（若要调试，请取消下面两行注释）
		//String sWord = "responseTxt=" + responseTxt + "\n return_url_log:sign=" + sign + "&mysign=" + mysign + "\n return回来的参数：" + AlipayFunction.CreateLinkString(params);
		//AlipayFunction.LogResult(sWord);

		//获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以下仅供参考)//
		 trade_no = request.getParameter("trade_no");				//支付宝交易号
		 order_no = request.getParameter("out_trade_no");	        //获取订单号
		total_fee = request.getParameter("total_fee");	        //获取总金额
		// subject = new String(request.getParameter("subject").getBytes("ISO-8859-1"),"GBK");//商品名称、订单名称
		// body = "";
		//if(request.getParameter("body") != null){
		//	body = new String(request.getParameter("body").getBytes("ISO-8859-1"), "GBK");//商品描述、订单备注、描述
		//}
		 buyer_email = request.getParameter("buyer_email");		//买家支付宝账号
		 trade_status = request.getParameter("trade_status");		//交易状态
		//获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以上仅供参考)//

		 verifyStatus = "";
		    //System.out.println("返回*****mysing:"+mysign);
			//System.out.println("返回*****singn:"+sign);
			//System.out.println("返回*****redponseTxt:"+responseTxt);
			//System.out.println("trade_status:"+trade_status);
			//System.out.println("trade_status:"+trade_status);
			//System.out.println("extra_common_param:"+extra_common_param);
		if(mysign.equals(sign) && responseTxt.equals("true")){
			//////////////////////////////////////////////////////////////////////////////////////////
			//请在这里加上商户的业务逻辑程序代码

			//——请根据您的业务逻辑来编写程序（以下代码仅作参考）——	
			if(trade_status.equals("TRADE_FINISHED") || trade_status.equals("TRADE_SUCCESS"))
			{
				Integer memberId=Integer.parseInt(extra_common_param);
				if(null!=memberId&&memberId>0)
				{
					member =memberService.getMemberById(memberId);
					ActionContext.getContext().getSession().put("redwww_user",member);
					
				}
				
				
				//判断该笔订单是否在商户网站中已经做过处理（可参考“集成教程”中“3.4返回数据处理”）
					//如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
					//如果有做过处理，不执行商户的业务程序
				this.addActionMessage("充值成功");
			}
			//System.out.println("-----------456---------------------------------");
			verifyStatus = "验证成功";
			//——请根据您的业务逻辑来编写程序（以上代码仅作参考）——
			
			//////////////////////////////////////////////////////////////////////////////////////////
		}else{
			//System.out.println("-----------789---------------------------------");
			verifyStatus = "验证失败";
			this.addActionMessage("充值失败");
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
	
		//获取支付宝POST过来反馈信息
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
			//乱码解决，这段代码在出现乱码时使用。如果mysign和sign不相等也可以使用这段代码转化
			//valueStr = new String(valueStr.getBytes("ISO-8859-1"), "GBK");
			params.put(name, valueStr);
		}
		
		//判断responsetTxt是否为ture，生成的签名结果mysign与获得的签名结果sign是否一致
		//responsetTxt的结果不是true，与服务器设置问题、合作身份者ID、notify_id一分钟失效有关
		//mysign与sign不等，与安全校验码、请求时的参数格式（如：带自定义参数等）、编码格式有关
		String mysign = AlipayNotify.GetMysign(params,key);
		String responseTxt = AlipayNotify.Verify(request.getParameter("notify_id"));
		String sign = request.getParameter("sign");
		
		//写日志记录（若要调试，请取消下面两行注释）
		//String sWord = "responseTxt=" + responseTxt + "\n notify_url_log:sign=" + sign + "&mysign=" + mysign + "\n notify回来的参数：" + AlipayFunction.CreateLinkString(params);
		//AlipayFunction.LogResult(sWord);
		
		//获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以下仅供参考)//
		String trade_no = request.getParameter("trade_no");				//支付宝交易号
		String order_no = request.getParameter("out_trade_no");	        //获取订单号
		String total_fee = request.getParameter("total_fee");	        //获取总金额
		String subject = new String(request.getParameter("subject").getBytes("ISO-8859-1"),"GBK");//商品名称、订单名称
		String body = "";
		if(request.getParameter("body") != null){
			body = new String(request.getParameter("body").getBytes("ISO-8859-1"), "GBK");//商品描述、订单备注、描述
		}
		String buyer_email = request.getParameter("buyer_email");		//买家支付宝账号
		String trade_status = request.getParameter("trade_status");		//交易状态
		//获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以上仅供参考)//
		//System.out.println("notify*****mysing:"+mysign);
		//System.out.println("notify*****singn:"+sign);
		//System.out.println("notify*****redponseTxt:"+responseTxt);
		if(mysign.equals(sign) && responseTxt.equals("true")){//验证成功
			
			//////////////////////////////////////////////////////////////////////////////////////////
			//请在这里加上商户的业务逻辑程序代码

			//——请根据您的业务逻辑来编写程序（以下代码仅作参考）——
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
			              log.info(memberId+"充值成功");
						}
					}
				}
				//判断该笔订单是否在商户网站中已经做过处理（可参考“集成教程”中“3.4返回数据处理”）
					//如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
					//如果有做过处理，不执行商户的业务程序
				
				out.println("success");	//请不要修改或删除
			} else {
				out.println("success");	//请不要修改或删除
			}
			//——请根据您的业务逻辑来编写程序（以上代码仅作参考）——

			//////////////////////////////////////////////////////////////////////////////////////////
		}else{//验证失败
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

package com.red.action.ajax;

import com.opensymphony.xwork2.Action;
import com.red.action.ActionBase;
import com.red.beans.Member;
import com.red.util.RcomeRandCode;


public class AjaxAction extends ActionBase 
{

	private static final long serialVersionUID = 6393440461573095013L;
	private String userEmail;
    private String msg;
    private String recomeCode;
	public String checkUserExsitAjax()throws Exception
	{
		if(null!=userEmail&&!"".equals(userEmail))
		{
			if(memberService.checkExist(userEmail))
			{
				msg="true";
			}else
			{
				msg="false";
			}
		}else
		{
			msg="noParam";
		}
		return Action.SUCCESS;	
	}
	
	public String checkRecomeCodeAjax()throws Exception
	{
		Member member=null;
		if(null!=recomeCode&&!"".equals(recomeCode))
		{
			int recomeId=RcomeRandCode.parseToInt(recomeCode);
			member=memberService.getMemberById(recomeId);
			if(null==member)
			{
				msg="false";
			}else if((RcomeRandCode.parseToString(member.getId()).trim()).equals(recomeCode.trim()))
			{
				msg="true";
			}else
			{
				msg="noParam";
			}
		}else
		{
			  msg="noParam";
		}
		return Action.SUCCESS;	
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getRecomeCode() {
		return recomeCode;
	}

	public void setRecomeCode(String recomeCode) {
		this.recomeCode = recomeCode;
	}
	

	
}

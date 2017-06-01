package com.red.action.web;

import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.red.action.ActionBase;
import com.red.beans.Member;
import com.red.util.RcomeRandCode;

public class RegistAction extends ActionBase 
{
	private static final long serialVersionUID = 3639603942722251238L;
	private Member member;
	private String repwd;
	private String recome;
	private String rand;
	@Override
	public String execute() throws Exception 
	{
	   
	   if(null==member)
	   {
		   this.addActionError("注册用户出错");
	   }else
	   {
		  if(memberService.registMemeber(member))
		  {
			  String [] mailParam=new String[]{member.getName(),member.getEmail(),repwd};
	    	  this.getRedMailUtil().sendMail(member.getEmail(), "红萌网用户注册确认信", "welcome_regist.html",mailParam);
			  this.addActionMessage("注册成功!");
		  }else
		  {
			  this.addActionError("注册失败!");
		  }
	   }
		return Action.SUCCESS;
	}

	@Override
	public void validate() 
	{
		if(null!=member)
		{ 	
		    Map<String,Object> session=ActionContext.getContext().getSession();
		    String sessionCode=(String)session.get("randomCode");
		   	if(!rand.equals(sessionCode))
		   	{
		   	    this.addActionError("验证码不正确！");	
		   	}
		   	
		    int id=RcomeRandCode.parseToInt(recome);
		    Member tem=new Member();
		    tem.setId(id);
		    member.setMember(tem);
		    if(null==memberService.getMemberById(id))
		    {
		    	this.addActionError("邀请码不正确!");
		    }
		   
		}else
		{
			this.addActionError("请填写完整数据!");
		}
	}




	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	public String getRepwd() {
		return repwd;
	}
	public void setRepwd(String repwd) {
		this.repwd = repwd;
	}
	public String getRecome() {
		return recome;
	}
	public void setRecome(String recome) {
		this.recome = recome;
	}

	public String getRand() {
		return rand;
	}

	public void setRand(String rand) {
		this.rand = rand;
	}
	

	
}

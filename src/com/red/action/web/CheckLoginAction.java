package com.red.action.web;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.red.action.ActionBase;
import com.red.beans.Member;

public class CheckLoginAction extends ActionBase {
	private static final long serialVersionUID = -5353763480145983450L;
	private String userName;
	private String password;
	private String rand;
	
	
	@Override
	public String execute() throws Exception 
	{
		String re=Action.INPUT;
		if(null==rand||"".equals(rand)){this.addActionError("验证码不能为空！");return "input";}
		if(null==userName||"".equals(userName)){this.addActionError("eamil不能为空！");return "input";}
		if(null==password||"".equals(password)){this.addActionError("password不能为空！");return "input";}
		String sessionCode=(String) ActionContext.getContext().getSession().get("randomCode");
		Member member=memberService.loginMember(userName, password);
		if(null!=sessionCode&&!"".equals(sessionCode)&&sessionCode.equals(rand)&&null!=member)
		{	
			ActionContext.getContext().getSession().put("redwww_user", member);
		    re=Action.SUCCESS;
		}else
		{
			this.addActionError("登陆失败!");
	
		}
		return re;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRand() {
		return rand;
	}
	public void setRand(String rand) {
		this.rand = rand;
	}
	
}

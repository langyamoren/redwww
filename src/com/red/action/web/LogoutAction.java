package com.red.action.web;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.red.action.ActionBase;

public class LogoutAction extends ActionBase {

	private static final long serialVersionUID = -6264268830578976776L;

	@Override
	public String execute() throws Exception {

       ServletActionContext.getRequest().getSession().invalidate();
		return Action.SUCCESS;
	}

}

package com.red.intercepter;


import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import com.red.action.web.SpaceAction;
import com.red.beans.Member;

public class CheckLoginInerceptor extends MethodFilterInterceptor {

	private static final long serialVersionUID = 2755473240021030508L;

	@Override
	protected String doIntercept(ActionInvocation arg0) throws Exception
	{
		String re=null;
		//ActionContext ac=arg0.getInvocationContext();
		ActionContext ac=ActionContext.getContext();
		Map<String,Object> session=ac.getSession();
		Member member=null;
		member=null!=session.get("redwww_user")?(Member)session.get("redwww_user"):null;
		if(null!=member)
		{
			re=arg0.invoke();
		}else
		{
			SpaceAction sa=(SpaceAction)arg0.getAction();
			sa.addActionError("您没有访问权限，请先登陆！");
			re="login";
		}
		return re;
	}

}

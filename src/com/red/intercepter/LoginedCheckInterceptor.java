package com.red.intercepter;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.red.beans.Admin;

/** session过期、登录有效性及操作的权限验证拦截器 */
public class LoginedCheckInterceptor extends AbstractInterceptor {

	private static final long serialVersionUID = -88049056621882087L;

	/** 拦截请求并进行登录有效性验证 */
	public String intercept(ActionInvocation ai) throws Exception {
		//取得请求的URL
		String url = ServletActionContext.getRequest().getRequestURL().toString();
		String prim = null;
		Admin admin = null;
		int index = 0;
		//验证Session是否过期
		if(!ServletActionContext.getRequest().isRequestedSessionIdValid()){
			//session过期,转向session过期提示页,最终跳转至登录页面
			//return "red_error";
			ServletActionContext.getResponse().sendRedirect("mred/mredlogin");
			return null;
		}else{
			//对登录与注销请求直接放行,不予拦截
			if (url.indexOf("mred/admin/admin_login")!=-1 || url.indexOf("mred/admin/admin_logout")!=-1){
				return ai.invoke();
			}else{
				admin = (Admin)ServletActionContext.getRequest().getSession().getAttribute("admin");
				//验证是否已经登录
				if (null==admin){
					//尚未登录,跳转至登录页面
					return "red_error";
				}else{
					//功能模块与权限位映射,部分可能与前台请求重名的请求加上命名空间"/admin"以示区别
					if (url.indexOf("mred/admin/admin_")!=-1){//系统用户管理
						index = 2; //权限位为2
					}else if (url.matches("mred/article_type/._article_type")){//文章类别
						index = 3; //权限位为3
					}else if (url.matches("mred/article/._article")){//文章
						index = 4; //权限位为4
					}else if (url.matches("mred/focus/focus_")){ //焦点广告
						index = 5; //权限位为5
					}else if (url.indexOf("mred/member/member_")!=-1){//会员级别管理
						index = 6; //权限位为6
					}else if (url.matches("/mred/download_type/._download_type")){//下载分类管理
						index = 7; //权限位为7
					}else if (url.matches("/mred/download/._download")){//下载管理
						index = 8; //权限位为8
					}else if (url.matches("mred/member/._password")){//密码管理
						index = 9; //权限位为9
					}else if (url.matches("mred/question_types/._question_types")){//问答类别
						index = 10; //权限位为10
					}else if(url.matches("mred/question/._question"))
					{
						index=11;//权限位为11   问答管理
					}else if(url.matches("mred/course/._course"))
					{
						index=12;//权限位为12   课程管理
					}else if(url.matches("mred/course/._course")||url.indexOf("mred/chapter/._chapter")!=-1)
					{
						index =13;//权限位为13   课程内容 部分等管理
					}else if(url.indexOf("mred/index")!=-1)
					{
						index=14;//欢迎页
					}else if(url.indexOf("mred/createHtml")!=-1)
					{
						index=15;//页面静态化
					}else if(url.matches("mred/._duixian"))
					{
						index=16;//页面静态化
					}
					//取得当前用户的操作权限
					prim = admin.getPrivileges().trim();
					//进行权限验证
					if (index>0){
						if (prim.substring(0,1).equals("1") || prim.substring(index-1,index).equals("1")){
							//验证通过,放行
							return ai.invoke();
						}else{
							//验证失败,转向权限验证失败提示页
							return "havenopr";
						}
					}else{
						//其它不需要权限验证的请求直接放行
						return ai.invoke();
					}					
				}				
			}			
		}
	}
}
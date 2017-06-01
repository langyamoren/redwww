package com.red.action.admin;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.red.action.ActionBase;
import com.red.beans.Admin;
import com.red.util.MD5;


/** 系统管理员处理控制器 */
public class AdminAction extends ActionBase {
	private static final long serialVersionUID = -1507718050888206279L;
	/** 通过依赖注入AdminService组件实例 */

	
	/** 系统用户管理所有请求中常用的参数值 */
	private String rand; 		//随机验证码
	private String actionMsg;	//Action间传递的消息参数
	private List<Admin> adminList;		//系统用户列表
	
	//采用模型驱动
	private Admin admin;

	
	/** 处理登录请求 */
	public String loginAdmin(){
		if(!rand.equalsIgnoreCase((String)ServletActionContext.getRequest().getSession().getAttribute("randomCode")))
		{
			this.addActionError("登陆不合法,验证码有误！");
			return "input";
		}else if(null==admin||null==admin.getAdminName()||"".equals(admin.getAdminName())||null==admin.getAdminPwd()||"".equals(admin.getAdminPwd()))
		{
			this.addActionError("登陆不合法,用户名和密码不能为空！");
			return "input";
		}else
		{
			Admin tempAdmin = adminService.loginAdmin(admin.getAdminName(), admin.getAdminPwd());
			if(null!=tempAdmin&&null!=tempAdmin.getAdminName()&&!"".equals(tempAdmin.getAdminName())&&null!=tempAdmin.getAdminPwd()&&!"".equals(tempAdmin.getAdminPwd()))
			{
				ServletActionContext.getRequest().getSession().setAttribute("admin",tempAdmin);
				return "index";
			}else{
				addActionError("登陆失败！");
				return "input";				
			}
		}
	}
	
	/** 处理注销请求 */
	public String logoutAdmin(){		
		ServletActionContext.getRequest().getSession().invalidate();
		return "login";
	}
	
	/** 处理浏览系统用户请求 */
	public String browseAdmin(){
		adminList = adminService.getAllAdmin();
		return SUCCESS;
	}
	
	/** 处理新增系统用户请求 */
	public String addAdmin(){
        if(null!=admin)
        {
        admin.setAdminPwd(MD5.EncoderByMd5(admin.getAdminPwd()));
		if (adminService.addAdmin(admin)){
			addActionMessage("添加管理员成功");
		}else{
			addActionMessage("添加管理员失败");
		}
        }
		return  browseAdmin();
	}
	
	/** 处理删除系统用户请求 */
	public String delAdmin(){
		
	   if(null!=admin&&null!=admin.getId()&&admin.getId()>0)
	   {
		   if(adminService.deleteAdminById(admin.getId()))
		   {
                this.addActionMessage("删 除管理员成功");
		   }else
		   {
			   this.addActionError("删除管员失败");
		   }
	   }

		return  browseAdmin();
	}
	
	/** 处理查看系统用户请求 */
	public String viewAdmin(){
		if (null!=admin&&null!=admin.getId()&&admin.getId()>0)
		{
			admin = adminService.getAdminById(admin.getId());
			if (null!=admin){
				return "toBrowseAdmin";
				
			}else{
				this.addActionError("查看管理员出错");
				return browseAdmin();
			}	
		}else{
			this.addActionError("查看管理员出错");
			return browseAdmin();
		}		
	}
	
	/** 处理装载系统用户请求 */
	public String editAdmin(){
		 if(null!=admin&&null!=admin.getId()&&admin.getId()>0)
		 {
			admin = adminService.getAdminById(admin.getId());
			if (null!=admin){
				return "toEditAdmin";
			}else{
			   this.addActionError("编辑管理员失败");
			   return browseAdmin();
			}	
		}else{
			this.addActionError("编辑管理员失败");
			return browseAdmin();
		}		
	}
	
	/** 处理更新系统用户请求 */
	public String updateAdmin()
	{		
		 if(null!=admin&&null!=admin.getId()&&admin.getId()>0)
		 {
			Admin  tem= adminService.getAdminById(admin.getId());
		    tem.setAdminName(admin.getAdminName());
		    if(null!=admin.getAdminPwd()&&admin.getAdminPwd().trim().length()>0)
		    {tem.setAdminPwd(MD5.EncoderByMd5(admin.getAdminPwd()));}
            tem.setPrivileges(admin.getPrivileges());
		
			if (adminService.updateAdmin(tem)){
				addActionMessage("修改管理员成功");
			}else{
				addActionMessage("修改管理员失败");
			}
		 }
		return  browseAdmin();		
	}	
	
	public String getRand() {
		return rand;
	}
	public void setRand(String rand) {
		this.rand = rand;
	}
	public String getActionMsg() {
		return actionMsg;
	}

	public void setActionMsg(String actionMsg) {
		this.actionMsg = actionMsg;
	}
	
	public List<Admin> getAdminList() {
		return adminList;
	}
	
	public void setAdminList(List<Admin> adminList) {
		this.adminList = adminList;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	
}

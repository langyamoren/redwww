package com.red.action.admin;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.red.action.ActionBase;
import com.red.beans.Admin;
import com.red.util.MD5;


/** ϵͳ����Ա��������� */
public class AdminAction extends ActionBase {
	private static final long serialVersionUID = -1507718050888206279L;
	/** ͨ������ע��AdminService���ʵ�� */

	
	/** ϵͳ�û��������������г��õĲ���ֵ */
	private String rand; 		//�����֤��
	private String actionMsg;	//Action�䴫�ݵ���Ϣ����
	private List<Admin> adminList;		//ϵͳ�û��б�
	
	//����ģ������
	private Admin admin;

	
	/** �����¼���� */
	public String loginAdmin(){
		if(!rand.equalsIgnoreCase((String)ServletActionContext.getRequest().getSession().getAttribute("randomCode")))
		{
			this.addActionError("��½���Ϸ�,��֤������");
			return "input";
		}else if(null==admin||null==admin.getAdminName()||"".equals(admin.getAdminName())||null==admin.getAdminPwd()||"".equals(admin.getAdminPwd()))
		{
			this.addActionError("��½���Ϸ�,�û��������벻��Ϊ�գ�");
			return "input";
		}else
		{
			Admin tempAdmin = adminService.loginAdmin(admin.getAdminName(), admin.getAdminPwd());
			if(null!=tempAdmin&&null!=tempAdmin.getAdminName()&&!"".equals(tempAdmin.getAdminName())&&null!=tempAdmin.getAdminPwd()&&!"".equals(tempAdmin.getAdminPwd()))
			{
				ServletActionContext.getRequest().getSession().setAttribute("admin",tempAdmin);
				return "index";
			}else{
				addActionError("��½ʧ�ܣ�");
				return "input";				
			}
		}
	}
	
	/** ����ע������ */
	public String logoutAdmin(){		
		ServletActionContext.getRequest().getSession().invalidate();
		return "login";
	}
	
	/** �������ϵͳ�û����� */
	public String browseAdmin(){
		adminList = adminService.getAllAdmin();
		return SUCCESS;
	}
	
	/** ��������ϵͳ�û����� */
	public String addAdmin(){
        if(null!=admin)
        {
        admin.setAdminPwd(MD5.EncoderByMd5(admin.getAdminPwd()));
		if (adminService.addAdmin(admin)){
			addActionMessage("��ӹ���Ա�ɹ�");
		}else{
			addActionMessage("��ӹ���Աʧ��");
		}
        }
		return  browseAdmin();
	}
	
	/** ����ɾ��ϵͳ�û����� */
	public String delAdmin(){
		
	   if(null!=admin&&null!=admin.getId()&&admin.getId()>0)
	   {
		   if(adminService.deleteAdminById(admin.getId()))
		   {
                this.addActionMessage("ɾ ������Ա�ɹ�");
		   }else
		   {
			   this.addActionError("ɾ����Աʧ��");
		   }
	   }

		return  browseAdmin();
	}
	
	/** ����鿴ϵͳ�û����� */
	public String viewAdmin(){
		if (null!=admin&&null!=admin.getId()&&admin.getId()>0)
		{
			admin = adminService.getAdminById(admin.getId());
			if (null!=admin){
				return "toBrowseAdmin";
				
			}else{
				this.addActionError("�鿴����Ա����");
				return browseAdmin();
			}	
		}else{
			this.addActionError("�鿴����Ա����");
			return browseAdmin();
		}		
	}
	
	/** ����װ��ϵͳ�û����� */
	public String editAdmin(){
		 if(null!=admin&&null!=admin.getId()&&admin.getId()>0)
		 {
			admin = adminService.getAdminById(admin.getId());
			if (null!=admin){
				return "toEditAdmin";
			}else{
			   this.addActionError("�༭����Աʧ��");
			   return browseAdmin();
			}	
		}else{
			this.addActionError("�༭����Աʧ��");
			return browseAdmin();
		}		
	}
	
	/** �������ϵͳ�û����� */
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
				addActionMessage("�޸Ĺ���Ա�ɹ�");
			}else{
				addActionMessage("�޸Ĺ���Աʧ��");
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

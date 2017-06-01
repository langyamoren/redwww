package com.red.service;

import java.util.List;

import com.red.beans.Admin;
import com.red.beans.Finance;
import com.red.beans.Focus;
import com.red.beans.Password;
import com.red.page.PageDiv;

public interface AdminService //extends ServiceBase
{
	/*******************Admin ����******************************/
		/**
		 * ���һ������Ա
		 * @param admin
		 * @return
		 */
	   public boolean addAdmin(Admin admin);
	   /**
	    * ָ��idɾ������Ա
	    * @param adminId
	    * @return
	    */
	   public boolean deleteAdminById(Integer adminId);
	   /**
	    * ָ��id���ع���Ա
	    * @param adminId
	    * @return
	    */
	   public Admin getAdminById(Integer adminId);
	   /**
	    * ���¹���Ա
	    * @param admin
	    * @return
	    */
	   public boolean updateAdmin(Admin admin);
		/**
		 * ����û����Ƿ��Ѿ����ڣ�
		 * @param adminName  
		 * @return  true����false ������
		 */
	   public boolean checkAdminExist(String adminName);

	   /**
	    * ��֤�û���½������ɹ��򷵻��û����󣬷���action��session��
	    * @param email
	    * @param pwd
	    * @return
	    */
	   public Admin loginAdmin(String adminName,String pwd);
	   /**
	    * �������й���Ա
	    * @return
	    */
	   public List<Admin> getAllAdmin();
	   
	 
	   
	   /****************************������*********************************/
	   /**
	    * ��ӽ�����
	    */
	   public boolean addFocus(Focus focus);
	   /**
	    * ���½�����
	    * @param focus
	    * @return
	    */
	   public boolean updateFocus(Focus focus);
	   /**
	    * ָ��idɾ��������
	    * @param id
	    * @return
	    */
	   public boolean deleteFocusById(Integer id);
	   /**
	    * ָ��id���ؽ�����
	    * @param id
	    * @return
	    */
	   public Focus   getFocusById(Integer id);
	   /**
	    * �������н�����
	    * @return
	    */
	   public List<Focus> getAllFocus();
	   /**
	    * �������еĽ�����
	    * @param count
	    * @return
	    */
	   public List<Focus> getFocusByTop(int count);
	   
	   /*********************��Ƶ�������****************************/
	   public List<Password> getPasswordByMember(Integer memberId);
	   public PageDiv<Password> getAllNotPassPassword(int offSet,int pageSize);
	   public boolean addPassword(Password pwd);
	   public boolean publishPassword(Password pwd);
	   /**
	    * �����б�
	    * @return
	    */
	   public List<Finance> getAskDuixian();
	   /**
	    * ����
	    * @param finance
	    * @return
	    */
	   public boolean duixian(Finance finance);
	   
}

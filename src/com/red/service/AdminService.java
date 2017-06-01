package com.red.service;

import java.util.List;

import com.red.beans.Admin;
import com.red.beans.Finance;
import com.red.beans.Focus;
import com.red.beans.Password;
import com.red.page.PageDiv;

public interface AdminService //extends ServiceBase
{
	/*******************Admin 管理******************************/
		/**
		 * 添加一个管理员
		 * @param admin
		 * @return
		 */
	   public boolean addAdmin(Admin admin);
	   /**
	    * 指定id删除管理员
	    * @param adminId
	    * @return
	    */
	   public boolean deleteAdminById(Integer adminId);
	   /**
	    * 指定id加载管理员
	    * @param adminId
	    * @return
	    */
	   public Admin getAdminById(Integer adminId);
	   /**
	    * 更新管理员
	    * @param admin
	    * @return
	    */
	   public boolean updateAdmin(Admin admin);
		/**
		 * 查检用户名是否已经存在，
		 * @param adminName  
		 * @return  true存在false 不存在
		 */
	   public boolean checkAdminExist(String adminName);

	   /**
	    * 验证用户登陆，如果成果则返回用户对象，放入action的session中
	    * @param email
	    * @param pwd
	    * @return
	    */
	   public Admin loginAdmin(String adminName,String pwd);
	   /**
	    * 查找所有管理员
	    * @return
	    */
	   public List<Admin> getAllAdmin();
	   
	 
	   
	   /****************************焦点广告*********************************/
	   /**
	    * 添加焦点广告
	    */
	   public boolean addFocus(Focus focus);
	   /**
	    * 更新焦点广告
	    * @param focus
	    * @return
	    */
	   public boolean updateFocus(Focus focus);
	   /**
	    * 指定id删除焦点广告
	    * @param id
	    * @return
	    */
	   public boolean deleteFocusById(Integer id);
	   /**
	    * 指定id加载焦点广告
	    * @param id
	    * @return
	    */
	   public Focus   getFocusById(Integer id);
	   /**
	    * 查找所有焦点广告
	    * @return
	    */
	   public List<Focus> getAllFocus();
	   /**
	    * 查找所有的焦点广告
	    * @param count
	    * @return
	    */
	   public List<Focus> getFocusByTop(int count);
	   
	   /*********************视频密码管理****************************/
	   public List<Password> getPasswordByMember(Integer memberId);
	   public PageDiv<Password> getAllNotPassPassword(int offSet,int pageSize);
	   public boolean addPassword(Password pwd);
	   public boolean publishPassword(Password pwd);
	   /**
	    * 兑现列表
	    * @return
	    */
	   public List<Finance> getAskDuixian();
	   /**
	    * 兑现
	    * @param finance
	    * @return
	    */
	   public boolean duixian(Finance finance);
	   
}

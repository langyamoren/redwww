package com.red.dao;

import java.util.List;

import com.red.beans.Admin;
import com.red.dao.base.RedCoreDao;

public interface AdminDao extends RedCoreDao<Admin>
{
    /**
     * 验证登陆合法性
     * @param userName
     * @param pwd
     * @return 成功返回admin对象，不成功则返回null
     */
    public Admin checkLogin(String userName,String pwd);  
	/**
	 * 查检用户名是否已经存在，
	 * @param adminName  
	 * @return  true存在false 不存在
	 */
   public boolean checkAdminExist(String adminName);
   /**
    * 获取所有管理员
    * @return
    */
   public List<Admin> getAllAdmin();
}

package com.red.dao;

import java.util.List;

import com.red.beans.Admin;
import com.red.dao.base.RedCoreDao;

public interface AdminDao extends RedCoreDao<Admin>
{
    /**
     * ��֤��½�Ϸ���
     * @param userName
     * @param pwd
     * @return �ɹ�����admin���󣬲��ɹ��򷵻�null
     */
    public Admin checkLogin(String userName,String pwd);  
	/**
	 * ����û����Ƿ��Ѿ����ڣ�
	 * @param adminName  
	 * @return  true����false ������
	 */
   public boolean checkAdminExist(String adminName);
   /**
    * ��ȡ���й���Ա
    * @return
    */
   public List<Admin> getAllAdmin();
}

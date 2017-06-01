package com.red.dao.imp;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import com.red.beans.Admin;
import com.red.dao.AdminDao;
import com.red.dao.base.RedCoreImp;
import com.red.util.MD5;


public class AdminDaoImp extends RedCoreImp<Admin> implements AdminDao {
	
    /**
     * ��֤��½�Ϸ��� �������Ѿ���md5�㷨
     * @param userName
     * @param pwd
     * @return �ɹ�true
     */
	@Override
	public Admin checkLogin(final String userName, final String pwd) 
	{
          Admin readmin= this.getHibernateTemplate().execute(new HibernateCallback<Admin>(){

			@SuppressWarnings("unchecked")
			@Override
			public Admin doInHibernate(Session session) throws HibernateException,
					SQLException {
				   Admin adminre=null;
				   //ͨ���û���Ϊ���������з��ϵ��û�
				    Query q=session.createQuery("from Admin as a where a.adminName=?");
				    q.setParameter(0, userName);
				    List<Admin> list=q.list();
				    if(null!=list&&list.size()>0)
				    {
				    	for(Admin tem:list)
				    	{
				    		//�Ա������Ƿ���ͬ
				    		String dbpwd=tem.getAdminPwd();
				    		if(null!=dbpwd&&!"".equals(dbpwd)&&dbpwd.equals(MD5.EncoderByMd5(pwd)))
				    		{
				    		  adminre=tem; 
				    		  break;
				    		}
				    		
				    	}

				    }
				return adminre;
			}
        	  
          });
        
		return readmin;
	}
	/**
	 * ����û����Ƿ��Ѿ����ڣ�
	 * @param adminName  
	 * @return  true����false ������
	 */
	@Override
	public boolean checkAdminExist(String adminName) {
		boolean re=false;
		if(null!=adminName&&!"".equals(adminName))
		{
		   Admin admin=this.getUnique("from Admin as a where a.adminName=?", new Object[]{adminName});
		   if(null!=admin&&null!=admin.getAdminName()&&!"".equals(admin.getAdminName()))
			   re=true;
		}
		return re;
	}
	   /**
	    * ��ȡ���й���Ա
	    * @return
	    */
	@Override
	public List<Admin> getAllAdmin() {
		// TODO Auto-generated method stub
		return this.getAll("from Admin as a order by a.id asc");
	}

}

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
     * 验证登陆合法性 对密码已经过md5算法
     * @param userName
     * @param pwd
     * @return 成功true
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
				   //通过用户名为条件找所有符合的用户
				    Query q=session.createQuery("from Admin as a where a.adminName=?");
				    q.setParameter(0, userName);
				    List<Admin> list=q.list();
				    if(null!=list&&list.size()>0)
				    {
				    	for(Admin tem:list)
				    	{
				    		//对比密码是否相同
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
	 * 查检用户名是否已经存在，
	 * @param adminName  
	 * @return  true存在false 不存在
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
	    * 获取所有管理员
	    * @return
	    */
	@Override
	public List<Admin> getAllAdmin() {
		// TODO Auto-generated method stub
		return this.getAll("from Admin as a order by a.id asc");
	}

}

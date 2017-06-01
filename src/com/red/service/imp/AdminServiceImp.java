package com.red.service.imp;
import java.util.List;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;
import org.springframework.util.Assert;
import com.red.beans.Admin;
import com.red.beans.Finance;
import com.red.beans.Focus;
import com.red.beans.Password;
import com.red.page.PageDiv;
import com.red.service.AdminService;
import com.red.service.base.ServiceTamlate;

public class AdminServiceImp extends ServiceTamlate implements AdminService 
{
	public static final Logger log=Logger.getLogger(AdminServiceImp.class);
	@Override
	public boolean addAdmin(Admin admin) 
	{
		boolean re=false;
		try {
			Assert.notNull(admin);
			this.getAdminDao().save(admin);
			re=true;
			log.info("[AdminServiceImp]:addAdmin:���ӹ���Ա�ɹ�!"+admin.getId()+"\t"+admin.getAdminName());
		} catch (Exception e) {
		    log.error("[AdminServiceImp]:addAdmin:���ӹ���Աʧ��!:"+admin.getId()+"\t"+admin.getAdminName()+"\t"+e.getMessage());
			//e.printStackTrace();
		}
		return re;
	}
	@Override
	public Admin getAdminById(Integer adminId)
	{
		Admin tem=null;
		if(null!=adminId&&adminId>0)
		{
		   tem=adminDao.get(Admin.class,adminId);
		}
		return tem;
	}

	@Override
	public boolean deleteAdminById(Integer adminId) {
		boolean re=false;
		try {
			if(null!=adminId&&adminId>0)
			{
				adminDao.deleteById(Admin.class, adminId);
				re=true;
				log.info("[AdminServiceImp]:deleteAdminById:ɾ������Ա�ɹ�");
			}

		} catch (Exception e) {
			   log.error("[AdminServiceImp]:deleteAdminById:ɾ������Աʧ��"+e.getMessage());
		}
		return re;
	}
	@Override
	public boolean updateAdmin(Admin admin) {
		boolean re=false;
		try {
			if(null!=admin&&null!=admin.getId()&&admin.getId()>0)
			{
				adminDao.update(admin);
				re=true;
				log.info("[AdminServiceImp]:updateAdmin:�޸Ĺ���Ա"+admin.getId()+"\t"+admin.getAdminName()+"�ɹ�");
			}

		} catch (Exception e) {
			log.error("[AdminServiceImp]:updateAdmin:�޸Ĺ���Ա"+admin.getId()+"\t"+admin.getAdminName()+"ʧ��"+e.getMessage());
		}
		return re;
	}


	@Override
	public boolean checkAdminExist(String adminName) 
	{
		return this.getAdminDao().checkAdminExist(adminName);
	}

	@Override
	public Admin loginAdmin(String adminName, String pwd) 
	{
		return adminDao.checkLogin(adminName, pwd);
	}
	@Override
	public List<Admin> getAllAdmin() 
	{
		return adminDao.getAllAdmin();
	}

	/****************************������*************************************/
	@Override
	public boolean addFocus(Focus focus) {
	    boolean re=false;
	    try {
			Assert.notNull(focus);
			focus.setSorts((byte)9);
			focusDao.save(focus);
			re=true;
			log.info("[AdminServiceImp]:addFocus:��ӽ�����"+focus.getTitle()+"�ɹ�");
		} catch (Exception e) {
			log.error("[AdminServiceImp]:addFocus:��ӽ�����"+focus.getTitle()+"ʧ��"+e.getMessage());
			e.printStackTrace();
		}
		return re;
	}

	@Override
	public boolean updateFocus(Focus focus) {
		 boolean re=false;
		    try {
				if(null!=focus&&null!=focus.getId()&&focus.getId()>0)
				{
					Focus tem=focusDao.get(Focus.class,focus.getId());
					
					try {
						BeanUtils.copyProperties(tem,focus);
					} catch (Exception e) {
						e.printStackTrace();
					}
					
					focusDao.update(tem);
					re=true;
					log.info("[AdminServiceImp]:updateFocus:�޸Ľ�����"+focus.getId()+"\t"+focus.getTitle()+"�ɹ�");
				}
				
			} catch (Exception e) {
				log.error("[AdminServiceImp]:updateFocus:�޸Ľ�����"+focus.getId()+"\t"+focus.getTitle()+"ʧ��"+e.getMessage());
				e.printStackTrace();
			}
		    
			return re;
	}

	@Override
	public boolean deleteFocusById(Integer id) {
		boolean re=false;
	    try {
	    	if(null!=id&&id>0)
	    	{
	    		focusDao.deleteById(Focus.class, id);
				re=true;
				log.info("[AdminServiceImp]:deleteFocusById:ɾ��������ɹ�"+id);	
	    	}
		} catch (Exception e) {
			log.error("[AdminServiceImp]:deleteFocusById:ɾ��������ʧ��"+id+"\t"+e.getMessage());
			e.printStackTrace();
		}
		return re;
	}

	@Override
	public Focus getFocusById(Integer id) {
		// TODO Auto-generated method stub
		return focusDao.get(Focus.class, id);
	}

	@Override
	public List<Focus> getAllFocus() {
		// TODO Auto-generated method stub
		return focusDao.getAllFocus();
	}

	@Override
	public List<Focus> getFocusByTop(int count) {
		// TODO Auto-generated method stub
		return focusDao.getFocusByTop(count);
	}
	@Override
	public List<Password> getPasswordByMember(Integer memberId) {
		// TODO Auto-generated method stub
		return passwordDao.getPasswordByMember(memberId);
	}
	@Override
	public PageDiv<Password> getAllNotPassPassword(int offSet, int pageSize) {
		// TODO Auto-generated method stub
		return passwordDao.getAllNotPassPassword(offSet, pageSize);
	}
	@Override
	public boolean addPassword(Password pwd) {
		boolean re=false;
	     try {
			passwordDao.save(pwd);
			re=true;
		} catch (Exception e) {
			re=false;
		}
		return re;
	}
	@Override
	public boolean publishPassword(Password pwd) {
		boolean re=false;
	     try {
	    	 if(null!=pwd&&pwd.getId()>0&&null!=pwd.getPasswd()&&!"".equals(pwd.getPasswd()))
	    	 {
	    		 Password old=passwordDao.get(Password.class, pwd.getId());
	    		 old.setPasswd(pwd.getPasswd());
	    		 passwordDao.update(old);
	    	 }
			
			re=true;
		} catch (Exception e) {
			re=false;
		}
		return re;
	}
	@Override
	public List<Finance> getAskDuixian() {
		// TODO Auto-generated method stub
		return financeDao.getAskDuixian();
	}
	@Override
	public boolean duixian(Finance finance) {
		boolean re=false;
		try {
			Finance fin=null;
			if(null!=finance&&finance.getId()>0)
			{
				fin=financeDao.get(Finance.class, finance.getId());
				fin.setPayType((byte)1);
				financeDao.update(fin);
			}
			re=true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return re;
	}	
}

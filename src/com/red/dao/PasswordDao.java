package com.red.dao;

import java.util.List;

import com.red.beans.Password;
import com.red.dao.base.RedCoreDao;
import com.red.page.PageDiv;

public interface PasswordDao extends RedCoreDao<Password>
{
	/**
	 * ͨ���û�id�����û���������
	 * @param memberId
	 * @return
	 */
    public List<Password> getPasswordByMember(Integer memberId);
    /**
     * �����������������
     * @param offSet
     * @param pageSize
     * @return
     */
    public PageDiv<Password> getAllNotPassPassword(int offSet,int pageSize);
    
}

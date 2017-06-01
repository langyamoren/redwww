package com.red.dao;

import java.util.List;

import com.red.beans.Password;
import com.red.dao.base.RedCoreDao;
import com.red.page.PageDiv;

public interface PasswordDao extends RedCoreDao<Password>
{
	/**
	 * 通过用户id查找用户的所密码
	 * @param memberId
	 * @return
	 */
    public List<Password> getPasswordByMember(Integer memberId);
    /**
     * 查找所有申请的密码
     * @param offSet
     * @param pageSize
     * @return
     */
    public PageDiv<Password> getAllNotPassPassword(int offSet,int pageSize);
    
}

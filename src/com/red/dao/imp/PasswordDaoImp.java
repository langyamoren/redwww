package com.red.dao.imp;

import java.util.List;

import com.red.beans.Password;
import com.red.dao.PasswordDao;
import com.red.dao.base.RedCoreImp;
import com.red.page.PageDiv;

public class PasswordDaoImp extends RedCoreImp<Password> implements PasswordDao {

	@Override
	public List<Password> getPasswordByMember(Integer memberId) {
		// TODO Auto-generated method stub
		return this.getAll("from Password as p where p.member.id=?", new Object[]{memberId});
	}

	@Override
	public PageDiv<Password> getAllNotPassPassword(int offSet, int pageSize) {
		// TODO Auto-generated method stub
		return this.getAll("from Password  as p where p.comCode is not null and p.passwd is null", offSet, pageSize);
	}

	
}

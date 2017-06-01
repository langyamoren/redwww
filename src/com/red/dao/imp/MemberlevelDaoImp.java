package com.red.dao.imp;

import java.util.List;

import com.red.beans.Memberlevel;
import com.red.dao.MemberlevelDao;
import com.red.dao.base.RedCoreImp;


public class MemberlevelDaoImp extends RedCoreImp<Memberlevel> implements MemberlevelDao
{

	@Override
	public List<Memberlevel> getAllLevel() {
		// TODO Auto-generated method stub
		return this.getAll("from Memberlevel as m order by m.id asc");
	}

	

}

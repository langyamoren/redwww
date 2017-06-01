package com.red.dao.imp;

import java.util.List;
import com.red.beans.DownType;
import com.red.dao.DownTypeDao;
import com.red.dao.base.RedCoreImp;

public class DownTypeDaoImp extends RedCoreImp<DownType> implements DownTypeDao {


	@Override
	public List<DownType> getAllDownType() {
     
		return this.getAll("from DownType as dt order by dt.sorts asc");
	}

	@Override
	public boolean hasDown(Integer typeId) 
	{
		int count=0;
		count=this.getCountQuery("from Download as d where d.downType.id=?",new Object[]{typeId});
		if(count>0)
	    return true;
		else
		return false;
	}

}

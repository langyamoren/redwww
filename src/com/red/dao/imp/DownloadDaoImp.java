package com.red.dao.imp;

import java.util.List;

import com.red.beans.Download;
import com.red.dao.DownloadDao;
import com.red.dao.base.RedCoreImp;
import com.red.page.PageDiv;

public class DownloadDaoImp extends RedCoreImp<Download> implements DownloadDao
{

	@Override
	public List<Download> getDownByType(Integer typeId, int count)
	{
		// TODO Auto-generated method stub
		return this.getAll("from Download as d where d.downType.id=? order by d.ispop desc, d.counts desc", new Object[]{count, typeId});
	}

	@Override
	public PageDiv<Download> getDownByType(Integer typeId, int offSet, int pageSize)
	{
		// TODO Auto-generated method stub
		return this.getAll("from Download as d where d.downType.id=? order by d.ispop desc, d.counts desc, d.id desc", 
				offSet, pageSize, new Object[]{typeId});
	}

	@Override
	public List<Download> getDownByPop(int topCount) 
	{
		// TODO Auto-generated method stub
		return this.getAll("from Download as d where d.ispop=true order by d.counts desc", topCount);
	}
	@Override
	public PageDiv<Download> getDownByPop(int offSet, int pageSize) {
		
		return this.getAll("from Download as d where d.ispop=true order by d.counts desc",offSet,pageSize);
	}


	@Override
	public List<Download> getDownByLast(int topCount)
	{
		// TODO Auto-generated method stub
		 return this.getAll("from Download as d  order by d.id desc",topCount);
	}
	@Override
	public PageDiv<Download> getDownByLast(int offSet, int pageSize)
	{
		// TODO Auto-generated method stub
		return this.getAll("from Download as d  order by d.id desc",offSet,pageSize);
	}
	@Override
	public List<Download> getDownByCount(int topCount) 
	{
		
		return this.getAll("from Download as d order by d.counts desc", topCount);
	}

	@Override
	public PageDiv<Download> getDownByCount(int offSet, int pageSize)
	{
		// TODO Auto-generated method stub
		return this.getAll("from Download as d order by d.counts desc",offSet,pageSize);
	}

	@Override
	public List<Download> getDownTopByType(Integer typeId, Integer topCount) {
		// TODO Auto-generated method stub
		return this.getAll("from Download as d where d.downType.id=? order by d.ispop desc, d.counts desc, d.id desc", topCount, new Object[]{typeId});
	}





}

package com.red.dao.imp;

import java.util.List;

import com.red.beans.Chapter;
import com.red.dao.ChapterDao;
import com.red.dao.base.RedCoreImp;
import com.red.page.PageDiv;

public class ChapterDaoImp extends RedCoreImp<Chapter> implements ChapterDao {

	@Override
	public List<Chapter> getChapterByCourseTopCount(Integer courseId,
			Integer topCount) {
		
		String hql="from Chapter as c where c.course.id=?  order by c.id desc";
		return this.getAll(hql, topCount, new Object[]{courseId});
		
	}

	@Override
	public List<Chapter> getLastChapter(int count) {
		return this.getAll("from Chapter as c order by c.id desc", count);
	}
	@Override
	public List<Chapter> getChapterByCourseId(Integer courseId) {
		// TODO Auto-generated method stub
		return this.getAll("from Chapter as c where c.course.id=?  order by c.id asc", new Object[]{courseId});
	}


	@Override
	public PageDiv<Chapter> getChapterByCourseId(Integer courseId,int offSet,int pageSize)
	{	
		return this.getAll("from Chapter as c where c.course.id=? order by c.id desc", offSet, pageSize, new Object[]{courseId});
	}

	@Override
	public boolean hasChapter(Integer courseId) 
	{
		boolean re=false;
		String hql="from Chapter as c where c.course.id=?";
		List<Chapter> list=this.getAll(hql, new Object[]{courseId});
		if(null!=list&&list.size()>0)re=true;
		return re;
	}





}

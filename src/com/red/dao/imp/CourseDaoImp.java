package com.red.dao.imp;

import java.util.List;
import com.red.beans.Course;
import com.red.dao.CourseDao;
import com.red.dao.base.RedCoreImp;
import com.red.page.PageDiv;

public class CourseDaoImp extends RedCoreImp<Course> implements CourseDao {


	@Override
	public List<Course> getCourseByTop(int count) 
	{
		
		return this.getAll("from Course as c  order by c.isrecom desc,c.sorts asc ,c.id desc", count);
	}

	@Override
	public PageDiv<Course> getCourseByPage(int offSet, int pageSize) 
	{
		return this.getAll("from Course as c order by c.isrecom desc,c.sorts asc ,c.id desc", offSet, pageSize);
	}


	@Override
	public PageDiv<Course> getCourseByType(int typeId, int offSet, int pageSize) 
	{
		// TODO Auto-generated method stub
		String hql="from Course as c where c.courseType.id=? order by c.isrecom desc,c.sorts asc ,c.id desc";
		return this.getAll(hql, offSet, pageSize, new Object[]{typeId});
	}

	@Override
	public List<Course> getCourseByRecom(int topCount) 
	{
		String hql="from Course as c where c.isrecom=1  order by c.sorts asc ,c.id desc";
		return this.getAll(hql, topCount);
	}

	@Override
	public List<Course> getCourseByKeyword(String keyword, int topCount) {
		      String hql="from Course as c where c.keyword like  '%"+keyword+"%' order by c.sorts asc ,c.id desc";
		return this.getAll(hql, topCount);
	}

}

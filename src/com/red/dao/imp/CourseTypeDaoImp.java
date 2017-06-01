package com.red.dao.imp;

import java.util.List;

import com.red.beans.CourseType;
import com.red.dao.CourseTypeDao;
import com.red.dao.base.RedCoreImp;


public class CourseTypeDaoImp extends RedCoreImp<CourseType> implements CourseTypeDao {

	@Override
	public List<CourseType> getAllCourseType() {
		// TODO Auto-generated method stub
		return this.getAll("from CourseType as c order by c.sorts asc, c.id desc");
	}

	@Override
	public boolean hasCourse(Integer courseTypeId) {
		int count=0;
		count=this.getCountQuery("from Course as c where c.courseType.id=?",new Object[]{courseTypeId});
		if(count>0)
	    return true;
		else
		return false;
	}

	
}

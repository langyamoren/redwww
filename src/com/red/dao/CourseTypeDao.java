package com.red.dao;

import java.util.List;

import com.red.beans.CourseType;
import com.red.dao.base.RedCoreDao;

public interface CourseTypeDao extends RedCoreDao<CourseType>
{
    public List<CourseType>  getAllCourseType();
    public boolean hasCourse(Integer courseTypeId);
}

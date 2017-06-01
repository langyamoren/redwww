package com.red.dao;

import java.util.List;

import com.red.beans.DownType;
import com.red.dao.base.RedCoreDao;

public interface DownTypeDao extends RedCoreDao<DownType>
{
	   /**
	    * 查找所有类别
	    * @return
	    */
	  List<DownType> getAllDownType();
	  /**
	   * 判断类别下是否有子类别
	   * @param typeId  类别id
	   * @return
	   */
	  boolean hasDown(Integer typeId);
}

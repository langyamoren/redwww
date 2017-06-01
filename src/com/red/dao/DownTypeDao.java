package com.red.dao;

import java.util.List;

import com.red.beans.DownType;
import com.red.dao.base.RedCoreDao;

public interface DownTypeDao extends RedCoreDao<DownType>
{
	   /**
	    * �����������
	    * @return
	    */
	  List<DownType> getAllDownType();
	  /**
	   * �ж�������Ƿ��������
	   * @param typeId  ���id
	   * @return
	   */
	  boolean hasDown(Integer typeId);
}

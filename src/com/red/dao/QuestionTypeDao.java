package com.red.dao;

import java.util.List;

import com.red.beans.QuestionType;
import com.red.dao.base.RedCoreDao;

public interface QuestionTypeDao extends RedCoreDao<QuestionType>{

	 
	   /**
	    * 查找一级问题类别
	    * 当fahterid=null时，为父类
	    * @return
	    */
	   public List<QuestionType> getParent();
	   /**
	    * 查找指定一级类别下的所有二级类别
	    * @param fatherid
	    * @return
	    */
	   public List<QuestionType> getSons(Integer fatherid);
	   /**
	    * 查找所有问题类别
	    * @return
	    */
	   public List<QuestionType> getAll();
	   /**
	    * 判断指定类别下有没有问题
	    * @param typeId  类别id
	    * @return
	    */
	   public boolean hashQuestion(Integer typeId);
}

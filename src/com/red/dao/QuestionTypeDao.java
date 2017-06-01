package com.red.dao;

import java.util.List;

import com.red.beans.QuestionType;
import com.red.dao.base.RedCoreDao;

public interface QuestionTypeDao extends RedCoreDao<QuestionType>{

	 
	   /**
	    * ����һ���������
	    * ��fahterid=nullʱ��Ϊ����
	    * @return
	    */
	   public List<QuestionType> getParent();
	   /**
	    * ����ָ��һ������µ����ж������
	    * @param fatherid
	    * @return
	    */
	   public List<QuestionType> getSons(Integer fatherid);
	   /**
	    * ���������������
	    * @return
	    */
	   public List<QuestionType> getAll();
	   /**
	    * �ж�ָ���������û������
	    * @param typeId  ���id
	    * @return
	    */
	   public boolean hashQuestion(Integer typeId);
}

package com.red.dao;

import java.util.List;

import com.red.beans.Question;
import com.red.dao.base.RedCoreDao;
import com.red.page.PageDiv;

public interface QuestionDao extends RedCoreDao<Question>
{
	  
	   /**
	    * �����������ʵ�����
	    * @param count
	    * @return
	    */
	   public List<Question> getQuestionByTop(int count);
	   /**
	    * ����ָ���Ƽ�����
	    * @param count ��ʾ����
	    * @return
	    */
	   public List<Question> getQuestionByPop(int count);
	   /**
	    * �����Ƽ����⣬��ҳ��ʾ
	    * @param offSet
	    * @param pageSize
	    * @return
	    */
	   public PageDiv<Question> getQuestionByPop(int offSet,int pageSize);
	   /**
	    * �Ҷ�������𣬲���ָ����������
	    * @param typeId  ���id
	    * @param count
	    * @return
	    */
	   public List<Question> getQuestionByType(Integer typeId,int count);
	   /**
	    * ����ָ���������������
	    * @param typeId ���id
	    * @param offSet
	    * @param pageSize
	    * @return
	    */
	   public PageDiv<Question> getQuestionByType(Integer typeId ,int offSet,int pageSize);
	   /**
	    * �������·���������
	    * @param count  Ҫ��ʾ������
	    * @return
	    */
	   public List<Question> getQuestionByLast(int count);
	   /**
	    * ���µ�����
	    * @param offSet
	    * @param pageSize
	    * @return
	    */
	   public PageDiv<Question> getQuestionByLast(int offSet,int pageSize);
	   /**
	    * ����ָ���û����ʵ�����
	    * @param memberId  ��Աid
	    * @param offSet
	    * @param pageSize
	    * @return
	    */
	   public PageDiv<Question> getQuestionByMemberId(Integer memberId,int offSet,int pageSize);
	   
}

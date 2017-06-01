package com.red.dao;

import java.util.List;

import com.red.beans.Question;
import com.red.dao.base.RedCoreDao;
import com.red.page.PageDiv;

public interface QuestionDao extends RedCoreDao<Question>
{
	  
	   /**
	    * 查找最新提问的问题
	    * @param count
	    * @return
	    */
	   public List<Question> getQuestionByTop(int count);
	   /**
	    * 查找指定推荐问题
	    * @param count 显示条数
	    * @return
	    */
	   public List<Question> getQuestionByPop(int count);
	   /**
	    * 查找推荐问题，分页显示
	    * @param offSet
	    * @param pageSize
	    * @return
	    */
	   public PageDiv<Question> getQuestionByPop(int offSet,int pageSize);
	   /**
	    * 找定问题类别，查找指定条数问题
	    * @param typeId  类别id
	    * @param count
	    * @return
	    */
	   public List<Question> getQuestionByType(Integer typeId,int count);
	   /**
	    * 查找指定类别下所有问题
	    * @param typeId 类别id
	    * @param offSet
	    * @param pageSize
	    * @return
	    */
	   public PageDiv<Question> getQuestionByType(Integer typeId ,int offSet,int pageSize);
	   /**
	    * 查找最新发布的问题
	    * @param count  要显示的条数
	    * @return
	    */
	   public List<Question> getQuestionByLast(int count);
	   /**
	    * 最新的提问
	    * @param offSet
	    * @param pageSize
	    * @return
	    */
	   public PageDiv<Question> getQuestionByLast(int offSet,int pageSize);
	   /**
	    * 查找指定用户提问的问题
	    * @param memberId  会员id
	    * @param offSet
	    * @param pageSize
	    * @return
	    */
	   public PageDiv<Question> getQuestionByMemberId(Integer memberId,int offSet,int pageSize);
	   
}

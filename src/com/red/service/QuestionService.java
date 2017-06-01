package com.red.service;

import java.util.List;

import com.red.beans.Answer;
import com.red.beans.Question;
import com.red.beans.QuestionType;
import com.red.page.PageDiv;

public interface QuestionService // extends ServiceBase
{
	
    /****************************类别相关方法**********************************/
	   public List<QuestionType> getParent();
	   public List<QuestionType> getTypesAll();
	   public boolean addQuestionTypes(QuestionType types);  //增加类别
	   public boolean deleteQuestionTypesById(Integer id);//删 除类别
	   public boolean updateQuestionTypes(QuestionType types);//更新类别
	   public QuestionType getQuestionTypes(Integer id);//加载一个类别实体
	   public boolean hasQuestion(Integer typeId);
	   public List<QuestionType> getSons(Integer id);
	     
	 /****************************问题相关方法**********************************/
	   public boolean addQuestion(Question question);
	   public boolean deleteQuestionById(Integer id);
	   public boolean updateQuestion(Question question);
	   public Question getQuestionById(Integer id);
	   /**
		 * 查询推荐问题 
		 * @param topCount
		 * @return
		 */
		public  List<Question> getPopsQuestion(int topCount);
		public  PageDiv<Question> getPopsQuestion(int offSet,int pageSize);
		/**
		 * 查询最新问题 
		 * @param topCount
		 * @return
		 */
		public List<Question> getLastQuestion(int topCount);
		public PageDiv<Question> getLastQuestion(int offSet,int pageSize);
		/**
		 * 根据示例对象查找问题
		 * @param example 示例对象
		 * @return
		 */
	    public List<Question> getSearchQuestion(Question example);
		public PageDiv<Question> getQuestionByTypes(Integer id, int offset,
				int pageSize);
		public boolean deleteBatchById(Integer[] ids);
/****************************答案相关方法**********************************/	
		public boolean addAnswer(Answer answer);
		public boolean deleteAnswerById(Integer id);
		public boolean updateAnswer(Answer answer);
		public Answer  getAnswerById(Integer id);
		public List<Answer> getAnswersByQuestionId(Integer id);

}

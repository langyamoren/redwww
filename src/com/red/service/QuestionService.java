package com.red.service;

import java.util.List;

import com.red.beans.Answer;
import com.red.beans.Question;
import com.red.beans.QuestionType;
import com.red.page.PageDiv;

public interface QuestionService // extends ServiceBase
{
	
    /****************************�����ط���**********************************/
	   public List<QuestionType> getParent();
	   public List<QuestionType> getTypesAll();
	   public boolean addQuestionTypes(QuestionType types);  //�������
	   public boolean deleteQuestionTypesById(Integer id);//ɾ �����
	   public boolean updateQuestionTypes(QuestionType types);//�������
	   public QuestionType getQuestionTypes(Integer id);//����һ�����ʵ��
	   public boolean hasQuestion(Integer typeId);
	   public List<QuestionType> getSons(Integer id);
	     
	 /****************************������ط���**********************************/
	   public boolean addQuestion(Question question);
	   public boolean deleteQuestionById(Integer id);
	   public boolean updateQuestion(Question question);
	   public Question getQuestionById(Integer id);
	   /**
		 * ��ѯ�Ƽ����� 
		 * @param topCount
		 * @return
		 */
		public  List<Question> getPopsQuestion(int topCount);
		public  PageDiv<Question> getPopsQuestion(int offSet,int pageSize);
		/**
		 * ��ѯ�������� 
		 * @param topCount
		 * @return
		 */
		public List<Question> getLastQuestion(int topCount);
		public PageDiv<Question> getLastQuestion(int offSet,int pageSize);
		/**
		 * ����ʾ�������������
		 * @param example ʾ������
		 * @return
		 */
	    public List<Question> getSearchQuestion(Question example);
		public PageDiv<Question> getQuestionByTypes(Integer id, int offset,
				int pageSize);
		public boolean deleteBatchById(Integer[] ids);
/****************************����ط���**********************************/	
		public boolean addAnswer(Answer answer);
		public boolean deleteAnswerById(Integer id);
		public boolean updateAnswer(Answer answer);
		public Answer  getAnswerById(Integer id);
		public List<Answer> getAnswersByQuestionId(Integer id);

}

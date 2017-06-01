package com.red.action.web;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.Action;
import com.red.action.ActionBase;
import com.red.beans.Answer;
import com.red.beans.Question;


public class QuestionDescAction extends ActionBase
{
	private static final long serialVersionUID = 8834675014557929520L;
	private Question question;
	private List<Answer> answerList=new ArrayList<Answer>();
	private Integer questionId;
	@Override
	public String execute() throws Exception 
	{
		if(null!=questionId&&questionId>0)
		{
	         question=questionService.getQuestionById(questionId);
	         answerList=questionService.getAnswersByQuestionId(questionId);
		}
		return Action.SUCCESS;
	}

	public List<Answer> getAnswerList() {
		return answerList;
	}
	public void setAnswerList(List<Answer> answerList) {
		this.answerList = answerList;
	}
	public Integer getQuestionId() {
		return questionId;
	}
	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}


	

}

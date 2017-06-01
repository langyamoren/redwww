package com.red.action.admin;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.Action;
import com.red.action.ActionBase;
import com.red.beans.Answer;
import com.red.beans.Question;


public class AnswerAction extends ActionBase
{
   
    /**
	 * 
	 */
	private static final long serialVersionUID = 1113087556454117127L;
	Answer answer;
	Question question;
    List<Answer> answerList;
    
    public String browseAnswer()throws Exception
    {
    	
    	
    	if(null!=answer&&null!=answer.getQuestion()&&null!=answer.getQuestion().getId()&&answer.getQuestion().getId()>0)
    	{
    		question=questionService.getQuestionById(answer.getQuestion().getId());
    		answerList=questionService.getAnswersByQuestionId(answer.getQuestion().getId());
    	}else
    	{
    		answerList=new ArrayList<Answer>();
    	}
      return Action.SUCCESS;	
    }
    
    public String deleteAnswer()throws Exception
    {
    	
    	if(null!=answer&&null!=answer.getId()&&answer.getId()>0)
    	{
    		question=questionService.getAnswerById(answer.getId()).getQuestion();
    		if(questionService.deleteAnswerById(answer.getId()))
    		{
    			this.addActionMessage("É¾³ý´ð°¸³É¹¦£¡");
    		}else
    		{
    			this.addActionError("É¾³ý´ð°¸Ê§°Ü£¡");
    		}
    	}
    	 return "toBrowse";
    }

	public Answer getAnswer() {
		return answer;
	}

	public void setAnswer(Answer answer) {
		this.answer = answer;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public List<Answer> getAnswerList() {
		return answerList;
	}

	public void setAnswerList(List<Answer> answerList) {
		this.answerList = answerList;
	}
    
    
    
}

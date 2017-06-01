package com.red.action.web;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.Action;
import com.red.action.ActionBase;
import com.red.beans.Question;

public class QuestionsAction extends ActionBase {

	private static final long serialVersionUID = -4630678522339615638L;
	 private List<Question> recomeList=new ArrayList<Question>();
	    private List<Question> lastList=new ArrayList<Question>();
		@Override
		public String execute() throws Exception
		{
			recomeList=questionService.getPopsQuestion(30);
			lastList=questionService.getLastQuestion(40);
			return Action.SUCCESS;
		}
		public List<Question> getRecomeList() {
			return recomeList;
		}
		public void setRecomeList(List<Question> recomeList) {
			this.recomeList = recomeList;
		}
		public List<Question> getLastList() {
			return lastList;
		}
		public void setLastList(List<Question> lastList) {
			this.lastList = lastList;
		}
		
}

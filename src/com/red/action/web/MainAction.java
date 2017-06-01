package com.red.action.web;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.Action;
import com.red.action.ActionBase;
import com.red.beans.Article;
import com.red.beans.Course;
import com.red.beans.Download;
import com.red.beans.Focus;
import com.red.beans.Question;

public class MainAction extends ActionBase 
{

	private static final long serialVersionUID = -4621443522150470339L;
    private List<Question> questionList=new ArrayList<Question>();
    private List<Course> courseList=new ArrayList<Course>();
    private List<Article> newsList=new ArrayList<Article>();
    private List<Focus> focusList=new ArrayList<Focus>();
    private List<Download> downList=new ArrayList<Download>();
	@Override
	public String execute() throws Exception 
	{
		//questionList=questionService.getLastQuestion(13);
		downList=downloadService.getLastDownload(13);
		courseList=courseService.getCourseByTop(6);
		newsList=articleService.getArticleByTop(2, 2);
		focusList=adminService.getFocusByTop(3);
		return Action.SUCCESS;
	}
	public List<Question> getQuestionList() {
		return questionList;
	}
	public void setQuestionList(List<Question> questionList) {
		this.questionList = questionList;
	}
	public List<Course> getCourseList() {
		return courseList;
	}
	public void setCourseList(List<Course> courseList) {
		this.courseList = courseList;
	}
	public List<Article> getNewsList() {
		return newsList;
	}
	public void setNewsList(List<Article> newsList) {
		this.newsList = newsList;
	}
	public List<Focus> getFocusList() {
		return focusList;
	}
	public void setFocusList(List<Focus> focusList) {
		this.focusList = focusList;
	}
	public List<Download> getDownList() {
		return downList;
	}
	public void setDownList(List<Download> downList) {
		this.downList = downList;
	} 
}

package com.red.action.web;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.red.action.ActionBase;
import com.red.beans.Article;
import com.red.beans.Chapter;
import com.red.util.HtmlGenerator;

public class RightAction extends ActionBase {

	private static final long serialVersionUID = -4924697076173680875L;
    private List<Article> noticeList=new ArrayList<Article>();
    private List<Chapter> chapterList=new ArrayList<Chapter>();
	@Override
	public String execute() throws Exception 
	{
		noticeList=articleService.getArticleByTop(1, 3);
		chapterList=courseService.getTopChapter(15);

		return Action.SUCCESS;
	}
	public List<Article> getNoticeList() {
		return noticeList;
	}
	public void setNoticeList(List<Article> noticeList) {
		this.noticeList = noticeList;
	}
	public List<Chapter> getChapterList() {
		return chapterList;
	}
	public void setChapterList(List<Chapter> chapterList) {
		this.chapterList = chapterList;
	}
    
    
}

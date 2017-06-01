package com.red.action.web;

import com.opensymphony.xwork2.Action;
import com.red.action.ActionBase;
import com.red.beans.Article;

public class ArticleContentAction extends ActionBase 
{
    private Article article;
	private static final long serialVersionUID = -6217519659588190678L;
	@Override
	public String execute() throws Exception 
	{
		if(null!=article&&article.getId()>0)
		{
			article=articleService.getArticleById(article.getId());
		}else
		{
			this.addActionError("您访问的页面不存在");
		}
		return Action.SUCCESS;
	}
	public Article getArticle() {
		return article;
	}
	public void setArticle(Article article) {
		this.article = article;
	}
   
}

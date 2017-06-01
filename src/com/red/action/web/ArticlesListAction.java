package com.red.action.web;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.Action;
import com.red.action.ActionBase;
import com.red.beans.Article;
import com.red.beans.ArticleType;
import com.red.page.PageDiv;
import com.red.page.Pager;

public class ArticlesListAction extends ActionBase 
{
   /**
	 * 
	 */
	private static final long serialVersionUID = -3953488556945269317L;
    private int typeId;
    private ArticleType type=null;
    private List<Article> list=new ArrayList<Article>();  
  
	private Pager pager;       //分页的page
	private int pageSize=20;    //每页大小
	private int totalCount=0;  //总记录数
	private int pageNo;        //当前页数
@Override
public String execute() throws Exception
{
	if(null==pager)pager=new Pager();
	if(typeId>0)
	{
		type=articleService.getArticleTypeById(typeId);
		 PageDiv<Article> pd=articleService.getArticleByType(typeId, pager.getOffset(), pageSize);
		  if(null!=pd)
		  {
			  list=pd.getList();
			  totalCount=pd.getTotalCount();
		  }
	}
	 return Action.SUCCESS;
}

public int getTypeId() {
	return typeId;
}
public void setTypeId(int typeId) {
	this.typeId = typeId;
}
public List<Article> getList() {
	return list;
}
public void setList(List<Article> list) {
	this.list = list;
}

public Pager getPager() {
	return pager;
}

public void setPager(Pager pager) {
	this.pager = pager;
}

public int getPageSize() {
	return pageSize;
}

public void setPageSize(int pageSize) {
	this.pageSize = pageSize;
}

public int getTotalCount() {
	return totalCount;
}

public void setTotalCount(int totalCount) {
	this.totalCount = totalCount;
}

public int getPageNo() {
	return pageNo;
}

public void setPageNo(int pageNo) {
	this.pageNo = pageNo;
}

public ArticleType getType() {
	return type;
}

public void setType(ArticleType type) {
	this.type = type;
}

  
}

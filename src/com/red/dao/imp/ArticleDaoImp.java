package com.red.dao.imp;

import java.util.ArrayList;
import java.util.List;
import com.red.beans.Article;
import com.red.dao.ArticleDao;
import com.red.dao.base.RedCoreImp;
import com.red.page.PageDiv;

public class ArticleDaoImp extends RedCoreImp<Article> implements ArticleDao {

	@Override
	public PageDiv<Article> getArticleByType(Integer typeId, int offSet, int pageSize) 
	{
		if(null!=typeId&&typeId>0&&offSet>=0&&pageSize>0)
		{
		String hql="from Article as a where a.articleType.id=? order by a.sorts asc ,a.id desc";
		return this.getAll(hql,offSet,pageSize,new Object[]{typeId});
		}else
		{
		return new PageDiv<Article>();
		}
	}

	

	@Override
	public List<Article> getArticleTop(int topCount)
	{
		if(topCount>0)
		return this.getAll("from Article as a  order by a.sorts  asc ,a.id desc", topCount);
		else
		return new ArrayList<Article>();	
	}

	@Override
	public List<Article> getArticleByType(Integer typeId, int topCount) 
	{	
        if(null!=typeId&&typeId>0&&topCount>0)
		return this.getAll("from Article as a where a.articleType.id=? order by a.sorts  asc ,a.id desc",topCount,new Object[]{typeId});
        else
        return new ArrayList<Article>();
	}
	/**
	 * 获取所有文章
	 * @param offSet  偏移量（在数据库开始找的条数）
	 * @param pageSize  每页显示多少条
	 * @return
	 */
	@Override
	public PageDiv<Article> getAllArticle(int offSet, int pageSize) {
		if(offSet>=0&&pageSize>0)
		return this.getAll("from Article as a order by a.sorts  asc,a.id desc",offSet,pageSize);
		else
	    return new PageDiv<Article>();
	}

	
	@Override
	public int[] deleteBatch(Integer ... params) {
		  int [][] par=new int[params.length][1];
		  for(int i=0;i<params.length;i++)
		  {
			  par[i]=new int[]{params[i]};
		  }
		  return this.executeBatch("delete from article where id=?", par);
	}

	@Override
	public List<Article> getArticleAbout(String des, int topCount)
	{
		String hql="from Article as a where a.keyword like '%"+des+"%' order by a.id desc";
		return this.getAll(hql, topCount);
	}



	@Override
	public int[] auditArticleBath(Integer... params) {
		 int [][] par=new int[params.length][1];
		  for(int i=0;i<params.length;i++)
		  {
			  par[i]=new int[]{params[i]};
		  }
		  return this.executeBatch("update article set ispass='1' where id=?", par);
	}	
}

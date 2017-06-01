package com.red.dao;

import java.util.List;

import com.red.beans.Article;
import com.red.dao.base.RedCoreDao;
import com.red.page.PageDiv;
public interface ArticleDao extends RedCoreDao<Article>
{
		/**
		 * 获取所有文章
		 * @param offSet  偏移量（在数据库开始找的条数）
		 * @param pageSize  每页显示多少条
		 * @return
		 */
	    public PageDiv<Article> getAllArticle(int offSet,int pageSize);
	  
	   /**
	    * 通过文章类别得到所有的文章，
	    * 所有文章排序规则为：
	    * 以isred升序
	    * 以sorts升序，以id隆序
	    * @param typeId
	    * @param offSet
	    * @param pageSize
	    * @return
	    */
	   public PageDiv<Article> getArticleByType(Integer typeId,int offSet,int pageSize);
	  
	   /**
	    * 找最新的文章
	    * @param topCount 显示条数
	    * @return
	    */
	   public List<Article> getArticleTop(int topCount);
	   /**
	    * 找某类文章的最新文章
	    * @param typeId
	    * @param topCount
	    * @return
	    */
	   public List<Article> getArticleByType(Integer typeId,int topCount);
	   /**
	    * 根据文单日id批量删除文章
	    * @param params 文章的ID(数组)
	    * @return
	    */
	   public int[] deleteBatch(Integer ... params);
	   /**
	    * 获取相关文章
	    * @param des  文章关键字
	    * @param topCount  最多显多少条相关文章默认10条
	    * @return
	    */
	   public List<Article> getArticleAbout(String des,int topCount);
	   /**
	    * 批量审核文章
	    * @param params
	    * @return
	    */
	   public int[] auditArticleBath(Integer ... params);
}

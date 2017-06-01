package com.red.dao;

import java.util.List;

import com.red.beans.ArticleType;
import com.red.dao.base.RedCoreDao;

public interface ArticleTypeDao extends RedCoreDao<ArticleType>
{
   /**
    * 查找所有文章类别
    * @return
    */
   public List<ArticleType> getAllArticleType();
   /**
    * 判断类别下有没有文章
    * @param articletTypeid
    * @return
    */
   public boolean hasArticle(Integer articletTypeid);
   /**
    * 得到除网站公告和新闻以外的文章
    * @return
    */
   public List<ArticleType> getPartArticleType();
   
   
}

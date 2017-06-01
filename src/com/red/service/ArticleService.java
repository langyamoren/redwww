package com.red.service;

import java.util.List;

import com.red.beans.Article;
import com.red.beans.ArticleType;
import com.red.page.PageDiv;

public interface ArticleService //extends ServiceBase
{
  /*********************文章类别相关方法***********************************/
   public boolean addArticleTypes(ArticleType types);  //增加类别
   public boolean deleteArticleTypeById(Integer id);//删 除类别
   public boolean updateArticleType(ArticleType types);//更新类别
   public ArticleType getArticleTypeById(Integer id);//加载一个类别实体
   public List<ArticleType> getAllArticleType();//得到所有类别，父类和子类（有序的）
   public List<ArticleType> getPartArticleType();// 除网站公告和新闻以外的类别
   public boolean hasArticle(Integer typeId);
 
   /*********************文章相关方法***********************************/
   
   public boolean addArticle(Article article);//增加文章
   public boolean deletyArticleById(Integer id);//删 除文章
   public boolean updateArticle(Article article);//更新文章
   public Article getArticleById(Integer id);//加载文章
   public boolean deleteBatchById(Integer...params);//批量删除文章
   public boolean auditArticleBathById(Integer ...params);//批量审核
   
   /**
    * 取指定类别下的所有文章
    * 如果类别id为0或小于0则取所有类别
    * 
    * @param typeId
    * @param offSet
    * @param pageSize
    * @return
    */
   public PageDiv<Article> getArticleByType(Integer typeId,int offSet,int pageSize);
   /**
    * 查找所有文章
    * @param offSet
    * @param pageSize
    * @return
    */
   public PageDiv<Article> getAllArticle(int offSet,int pageSize);
   /**
    * 指定类别下，要显示的文章
    * @param typeId
    * @param topCount
    * @return
    */
   public List<Article> getArticleByTop(int typeId,int topCount);

   /**
    * 找到相关文章
    * @param des
    * @param topCount
    * @return
    */
   public List<Article> getAboutArticle(String des,int topCount);
      
}

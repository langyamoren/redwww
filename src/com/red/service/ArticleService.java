package com.red.service;

import java.util.List;

import com.red.beans.Article;
import com.red.beans.ArticleType;
import com.red.page.PageDiv;

public interface ArticleService //extends ServiceBase
{
  /*********************���������ط���***********************************/
   public boolean addArticleTypes(ArticleType types);  //�������
   public boolean deleteArticleTypeById(Integer id);//ɾ �����
   public boolean updateArticleType(ArticleType types);//�������
   public ArticleType getArticleTypeById(Integer id);//����һ�����ʵ��
   public List<ArticleType> getAllArticleType();//�õ�������𣬸�������ࣨ����ģ�
   public List<ArticleType> getPartArticleType();// ����վ�����������������
   public boolean hasArticle(Integer typeId);
 
   /*********************������ط���***********************************/
   
   public boolean addArticle(Article article);//��������
   public boolean deletyArticleById(Integer id);//ɾ ������
   public boolean updateArticle(Article article);//��������
   public Article getArticleById(Integer id);//��������
   public boolean deleteBatchById(Integer...params);//����ɾ������
   public boolean auditArticleBathById(Integer ...params);//�������
   
   /**
    * ȡָ������µ���������
    * ������idΪ0��С��0��ȡ�������
    * 
    * @param typeId
    * @param offSet
    * @param pageSize
    * @return
    */
   public PageDiv<Article> getArticleByType(Integer typeId,int offSet,int pageSize);
   /**
    * ������������
    * @param offSet
    * @param pageSize
    * @return
    */
   public PageDiv<Article> getAllArticle(int offSet,int pageSize);
   /**
    * ָ������£�Ҫ��ʾ������
    * @param typeId
    * @param topCount
    * @return
    */
   public List<Article> getArticleByTop(int typeId,int topCount);

   /**
    * �ҵ��������
    * @param des
    * @param topCount
    * @return
    */
   public List<Article> getAboutArticle(String des,int topCount);
      
}

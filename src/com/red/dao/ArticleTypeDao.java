package com.red.dao;

import java.util.List;

import com.red.beans.ArticleType;
import com.red.dao.base.RedCoreDao;

public interface ArticleTypeDao extends RedCoreDao<ArticleType>
{
   /**
    * ���������������
    * @return
    */
   public List<ArticleType> getAllArticleType();
   /**
    * �ж��������û������
    * @param articletTypeid
    * @return
    */
   public boolean hasArticle(Integer articletTypeid);
   /**
    * �õ�����վ������������������
    * @return
    */
   public List<ArticleType> getPartArticleType();
   
   
}

package com.red.dao;

import java.util.List;

import com.red.beans.Article;
import com.red.dao.base.RedCoreDao;
import com.red.page.PageDiv;
public interface ArticleDao extends RedCoreDao<Article>
{
		/**
		 * ��ȡ��������
		 * @param offSet  ƫ�����������ݿ⿪ʼ�ҵ�������
		 * @param pageSize  ÿҳ��ʾ������
		 * @return
		 */
	    public PageDiv<Article> getAllArticle(int offSet,int pageSize);
	  
	   /**
	    * ͨ���������õ����е����£�
	    * ���������������Ϊ��
	    * ��isred����
	    * ��sorts������id¡��
	    * @param typeId
	    * @param offSet
	    * @param pageSize
	    * @return
	    */
	   public PageDiv<Article> getArticleByType(Integer typeId,int offSet,int pageSize);
	  
	   /**
	    * �����µ�����
	    * @param topCount ��ʾ����
	    * @return
	    */
	   public List<Article> getArticleTop(int topCount);
	   /**
	    * ��ĳ�����µ���������
	    * @param typeId
	    * @param topCount
	    * @return
	    */
	   public List<Article> getArticleByType(Integer typeId,int topCount);
	   /**
	    * �����ĵ���id����ɾ������
	    * @param params ���µ�ID(����)
	    * @return
	    */
	   public int[] deleteBatch(Integer ... params);
	   /**
	    * ��ȡ�������
	    * @param des  ���¹ؼ���
	    * @param topCount  ����Զ������������Ĭ��10��
	    * @return
	    */
	   public List<Article> getArticleAbout(String des,int topCount);
	   /**
	    * �����������
	    * @param params
	    * @return
	    */
	   public int[] auditArticleBath(Integer ... params);
}

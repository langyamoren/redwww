package com.red.service.imp;


import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.util.Assert;

import com.red.beans.Article;
import com.red.beans.ArticleType;
import com.red.page.PageDiv;
import com.red.service.ArticleService;
import com.red.service.base.ServiceTamlate;
import com.red.util.HtmlRegexpUtil;

public class ArticleServiceImp  extends ServiceTamlate implements ArticleService
{
	public static final Logger log=Logger.getLogger(QuestionServiceImp.class);
	/************************************����������ʵ�ַ���*******************************************/
	@Override
	public boolean addArticleTypes(ArticleType articleType) {
	   boolean re=false;
	   try {
             if(null!=articleType)
             {
            	 if(null==articleType.getSorts()||articleType.getSorts()<0)articleType.setSorts((byte)9);
            	 this.getArticleTypeDao().save(articleType);
            	 re=true;
   			  log.info("[ArticleServiceImp]:addArticleTypes:������ɹ���"+articleType.getName());
             } 
		} catch (Exception e) 
		{
			re=false;
			  log.error("[ArticleServiceImp]:addArticleTypes:����������ʧ��!:"+articleType.getName()+"\t"+e.getMessage());
			e.printStackTrace();
		}
		return re;
	}

	@Override
	public boolean deleteArticleTypeById(Integer id) {
		boolean re=false;
		try {
			if(0<id){this.getArticleTypeDao().deleteById(ArticleType.class, id);}
			re=true;
			log.info("[ArticleServiceImp]:deleteArticleTypeById:ɾ �����ɹ�!"+id);
		} catch (Exception e) {
			log.error("[ArticleServiceImp]:deleteArticleTypeById:ɾ���������ʧ��!:"+id+e.getMessage());
			e.printStackTrace();
		}
		return re;
	}

	@Override
	public boolean updateArticleType(ArticleType articleType) 
	{
	    boolean re=false;
	    try {
		     	Assert.notNull(articleType);
		       this.getArticleTypeDao().update(articleType);
		
		    	re=true;
		    	log.info("[ArticleServiceImp]:updateArticleType:�����������"+articleType.getId()+"�ɹ���");
		} catch (Exception e) {
		    log.error("[ArticleServiceImp]:updateArticleType:�����������ʧ�ܣ�"+articleType.getId()+"\t"+e.getMessage());
		    e.printStackTrace();
		}
		return re;
	}

	@Override
	public ArticleType getArticleTypeById(Integer id) {
		ArticleType tem=null;
		if(id>0)
		{
			tem=articleTypeDao.get(ArticleType.class, id);
		}
		return tem;
	}

	
	@Override
	public List<ArticleType> getAllArticleType() {
		List<ArticleType> tem=new ArrayList<ArticleType>();
		tem=articleTypeDao.getAllArticleType();
		return tem; 
	}
	@Override
	public boolean hasArticle(Integer typeId)
	{
		return articleTypeDao.hasArticle(typeId);
	}
	@Override
	public List<ArticleType> getPartArticleType() {
		// TODO Auto-generated method stub
		return articleTypeDao.getPartArticleType();
	}
	
	/************************************�������ʵ�ַ���*******************************************/

	@Override
	public boolean addArticle(Article article)
	{
		boolean re=false;
		try {
					Assert.notNull(article);
					//�ж�����id
					if(null!=article.getArticleType()&&null!=article.getArticleType().getId()&&article.getArticleType().getId()>0)
					{
									//���������������ʱ��ֻ�õ�����id,
								ArticleType articleType =articleTypeDao.get(ArticleType.class, article.getArticleType().getId());
									if(null!=articleType)
									{
										article.setArticleType(articleType);
									}

									article.setContentPic(HtmlRegexpUtil.getAllPics(article.getContent()));
									articleDao.save(article);//���
									//����������������HTML��̬�ļ�
					}else
					{
						log.info("[ArticleServiceImp]:addArticle:���������Ϊ�գ�");
						return false;
					}
					re=true;
					log.info("[ArticleServiceImp]:addArticle:������³ɹ���"+article.getId());
		} catch (Exception e)
		{
		    log.error("[ArticleServiceImp]:addArticle:�������ʧ�ܣ�"+e.getMessage());
			e.printStackTrace();
		}
		return re;
	}

	@Override
	public boolean deletyArticleById(Integer id) {
		boolean re=false;
		try {
			articleDao.deleteById(Article.class, id);
			re=true;
			log.info("[ArticleServiceImp]:deletyArticleById:ɾ�����³ɹ�"+id);
		} catch (Exception e)
		{
		   log.error("[ArticleServiceImp]:deletyArticleById:ɾ������ʧ�ܣ�"+id+"\t"+e.getMessage());
		   e.printStackTrace();
		}
		return re;
	}

	@Override
	public boolean updateArticle(Article article)
	{
		boolean re=false;
		try {
			articleDao.update(article);
			re=true;
			log.info("[ArticleServiceImp]:updateArticle:�޸�����"+article.getId()+"�ɹ���");
		} catch (Exception e) {
		    log.error("[ArticleServiceImp]:updateArticle:ɾ������"+article.getId()+"ʧ��!"+e.getMessage());
		    e.printStackTrace();
		}
		return re;
	}

	@Override
	public Article getArticleById(Integer id) {
		Article article=null;
		if(null!=id&&id>0)
		{
			article=articleDao.get(Article.class, id);
		}
		return article;
	}

	@Override
	public PageDiv<Article> getArticleByType(Integer typeId, int offSet,int pageSize)
	{
		PageDiv<Article> pd=null;
		if(0<=typeId)
		{
			pd=articleDao.getArticleByType(typeId, offSet, pageSize);
		}else
		{
			pd=articleDao.getAllArticle(offSet, pageSize);
		}
		return pd;
	}

	@Override
	public PageDiv<Article> getAllArticle(int offSet, int pageSize) {
		
		return articleDao.getAllArticle(offSet, pageSize);
	}

	@Override
	public boolean deleteBatchById(Integer... params) {
	   boolean re=false;
	    try {
	    	//for(Integer id:params)
	    	//this.deletyArticleById(id);
	    	int [] result=this.getArticleDao().deleteBatch(params);
	    	if(result.length>0)re=true;
	    	log.info("[ArticleServiceImp]:deleteBatchById:����ɾ�����³ɹ���");
		} catch (Exception e) {
			log.error("[ArticleServiceImp]:deleteBatchById:����ɾ������ʧ�ܣ�"+e.getMessage());
			e.printStackTrace();
		}
		return re;
	}
	@Override
	public boolean auditArticleBathById(Integer... params) {
		 boolean re=false;
		    try {
		    	//for(Integer id:params)
		    	//this.deletyArticleById(id);
		    	int [] result=this.getArticleDao().auditArticleBath(params);
		    	if(result.length>0)re=true;
		    	log.info("[ArticleServiceImp]:deleteBatchById:����ɾ�����³ɹ���");
			} catch (Exception e) {
				log.error("[ArticleServiceImp]:deleteBatchById:����ɾ������ʧ�ܣ�"+e.getMessage());
				e.printStackTrace();
			}
			return re;
	}
	
	@Override
	public List<Article> getArticleByTop(int typeId, int topCount) {
		// TODO Auto-generated method stub
		return articleDao.getArticleByType(typeId, topCount);
	}

	@Override
	public List<Article> getAboutArticle(String des, int topCount) {
		// TODO Auto-generated method stub
		return articleDao.getArticleAbout(des, topCount);
	}



}

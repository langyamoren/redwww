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
	/************************************文章类别相关实现方法*******************************************/
	@Override
	public boolean addArticleTypes(ArticleType articleType) {
	   boolean re=false;
	   try {
             if(null!=articleType)
             {
            	 if(null==articleType.getSorts()||articleType.getSorts()<0)articleType.setSorts((byte)9);
            	 this.getArticleTypeDao().save(articleType);
            	 re=true;
   			  log.info("[ArticleServiceImp]:addArticleTypes:添加类别成功！"+articleType.getName());
             } 
		} catch (Exception e) 
		{
			re=false;
			  log.error("[ArticleServiceImp]:addArticleTypes:添加文章类别失败!:"+articleType.getName()+"\t"+e.getMessage());
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
			log.info("[ArticleServiceImp]:deleteArticleTypeById:删 除类别成功!"+id);
		} catch (Exception e) {
			log.error("[ArticleServiceImp]:deleteArticleTypeById:删除文章类别失败!:"+id+e.getMessage());
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
		    	log.info("[ArticleServiceImp]:updateArticleType:更新文章类别"+articleType.getId()+"成功！");
		} catch (Exception e) {
		    log.error("[ArticleServiceImp]:updateArticleType:更新文章类别失败！"+articleType.getId()+"\t"+e.getMessage());
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
	
	/************************************文章相关实现方法*******************************************/

	@Override
	public boolean addArticle(Article article)
	{
		boolean re=false;
		try {
					Assert.notNull(article);
					//判断类别的id
					if(null!=article.getArticleType()&&null!=article.getArticleType().getId()&&article.getArticleType().getId()>0)
					{
									//关联类别，增加文章时，只得到类别的id,
								ArticleType articleType =articleTypeDao.get(ArticleType.class, article.getArticleType().getId());
									if(null!=articleType)
									{
										article.setArticleType(articleType);
									}

									article.setContentPic(HtmlRegexpUtil.getAllPics(article.getContent()));
									articleDao.save(article);//添加
									//别忘了在这里生成HTML静态文件
					}else
					{
						log.info("[ArticleServiceImp]:addArticle:文章类别不能为空！");
						return false;
					}
					re=true;
					log.info("[ArticleServiceImp]:addArticle:添加文章成功！"+article.getId());
		} catch (Exception e)
		{
		    log.error("[ArticleServiceImp]:addArticle:添加文章失败！"+e.getMessage());
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
			log.info("[ArticleServiceImp]:deletyArticleById:删除文章成功"+id);
		} catch (Exception e)
		{
		   log.error("[ArticleServiceImp]:deletyArticleById:删除文章失败！"+id+"\t"+e.getMessage());
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
			log.info("[ArticleServiceImp]:updateArticle:修改文章"+article.getId()+"成功！");
		} catch (Exception e) {
		    log.error("[ArticleServiceImp]:updateArticle:删除文章"+article.getId()+"失败!"+e.getMessage());
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
	    	log.info("[ArticleServiceImp]:deleteBatchById:批量删除文章成功！");
		} catch (Exception e) {
			log.error("[ArticleServiceImp]:deleteBatchById:批量删除文章失败！"+e.getMessage());
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
		    	log.info("[ArticleServiceImp]:deleteBatchById:批量删除文章成功！");
			} catch (Exception e) {
				log.error("[ArticleServiceImp]:deleteBatchById:批量删除文章失败！"+e.getMessage());
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

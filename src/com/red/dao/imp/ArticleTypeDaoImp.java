package com.red.dao.imp;

import java.util.List;
import com.red.beans.ArticleType;
import com.red.dao.ArticleTypeDao;
import com.red.dao.base.RedCoreImp;

public class ArticleTypeDaoImp extends RedCoreImp<ArticleType> implements ArticleTypeDao {
	
	@Override
	public List<ArticleType> getAllArticleType()
	{
	
		return this.getAll("from ArticleType as a order by a.sorts asc");
	}

	@Override
	public boolean hasArticle(Integer articletTypeid) {
		int count=0;
		count=this.getCountQuery("from Article as a where a.articleType.id=?",new Object[]{articletTypeid});
		if(count>0)
	    return true;
		else
		return false;
	}

	@Override
	public List<ArticleType> getPartArticleType() {
		String hql="from ArticleType as a  where a.id>2 order by a.sorts asc";
		return this.getAll(hql);
	}

}

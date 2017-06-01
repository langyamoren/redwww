package com.red.action.admin;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.Action;
import com.red.action.ActionBase;
import com.red.beans.ArticleType;

public class ArticleTypeAction extends ActionBase
{
	private static final long serialVersionUID = -3183399935534749728L;
	ArticleType articleType;
	List<ArticleType> atList=new ArrayList<ArticleType>();
	
	public String browseArticleType()throws Exception
	{
		atList=articleService.getAllArticleType();
		return Action.SUCCESS;
	}
	
     public String addArticleType()throws Exception
     {
    	 if(null!=articleType&&null!=articleType.getName()&&!"".equals(articleType.getName()))
    	 {
    		    articleType.setSorts((byte)9);
    		     if(articleService.addArticleTypes(articleType))
    		    	 this.addActionMessage("增加类别成功");
    		     else
    		    	 this.addActionError("增加类别失败"); 
    	 }else
    	 {
    		 this.addActionError("请完确定填完资料");
    	 }
    	 return browseArticleType();
     }
     public String updateArticleType()throws Exception
     {
    	 if(null!=articleType&&articleType.getId()>0)
    	 {
    		   ArticleType old=articleService.getArticleTypeById(articleType.getId());
    		   old.setName(articleType.getName());
    		   old.setSorts(articleType.getSorts());
    		     if(articleService.updateArticleType(old))
    		    	 this.addActionMessage("修改类别成功");
    		     else
    		    	 this.addActionError("修改类别失败"); 
    	 }else
    	 {
    		 this.addActionError("请完确定填完资料");
    	 }
    	 return browseArticleType();
     }
     
     public String deleteArticleType()throws Exception
     {
    	 if(null!=articleType&&articleType.getId()>0)
    	 {
    		     if(!articleService.hasArticle(articleType.getId())&&articleService.deleteArticleTypeById(articleType.getId()))
    		    	 this.addActionMessage("删除类别成功");
    		     else
    		    	 this.addActionError("删除类别失败"); 
    	 }else
    	 {
    		 this.addActionError("请完确定填完资料");
    	 }
    	 return browseArticleType();
     }
	public ArticleType getArticleType() {
		return articleType;
	}
	public void setArticleType(ArticleType articleType) {
		this.articleType = articleType;
	}

	public List<ArticleType> getAtList() {
		return atList;
	}

	public void setAtList(List<ArticleType> atList) {
		this.atList = atList;
	}
	
     
     
}

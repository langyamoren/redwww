package com.red.action.admin;

import java.io.File;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.Action;
import com.red.action.ActionBase;
import com.red.beans.Article;
import com.red.beans.ArticleType;
import com.red.page.PageDiv;
import com.red.page.Pager;
import com.red.util.HtmlGenerator;
import com.red.util.HtmlRegexpUtil;
public class ArticleAction extends ActionBase 
{
	
	 private static final long serialVersionUID = 6122128735977826056L;
     
	 private List<ArticleType> articleType=new ArrayList<ArticleType>();
	private Article article;
	   //存放所有类别列表的list
	private Pager pager;       //分页的page
	private int pageSize=20;    //每页大小
	private int totalCount=0;  //总记录数
	private int pageNo;        //当前页数
	private List<Article> articleList=new ArrayList<Article>();
	private Integer []ids; //批量删除的id
	/**
	 * 跳转至增加文章界面
	 * @return
	 * @throws Exception
	 */
	 public String addArticle()throws Exception
     {
		 articleType=articleService.getAllArticleType();
    	 return "add";
     }
	/**
	 * 添加文章
	 * @return
	 * @throws Exception
	 */
	 public String addSaveArticle()throws Exception
	 {
		 if(null!=article&&null!=article.getArticleType()&&article.getArticleType().getId()>0)
		 {
			      article.setIspass(true);
			     
				  articleService.addArticle(article);//添加文章
				 // this.createArticleHtml(article);//生成html文件
				 this.addActionMessage("添加文章成功！");  
		  }else
		  {
			 this.addActionError("添加文章失败！"); 
		  }
	
	  return this.addArticle();    
	 }
	
	/**
	 * 加载文章管理界面
	 * @return
	 * @throws Exception
	 */
	 public String browseArticle()throws Exception
	  {
		if(null==pager)pager=new Pager();
		if(null==article||null==article.getArticleType()||null==article.getArticleType().getId()||article.getArticleType().getId()<=0)
		  {
			  PageDiv<Article> pd=articleService.getAllArticle(pager.getOffset(), pageSize);
			  if(null!=pd)
			  {
				  articleList=pd.getList();
				  totalCount=pd.getTotalCount();
			  }
		  }else
		  {
			  PageDiv<Article> pd=articleService.getArticleByType(article.getArticleType().getId(),pager.getOffset(), pageSize);
			  if(null!=pd)
			  {
				  articleList=pd.getList();
				  totalCount=pd.getTotalCount();
			  }
		  }
		 articleType=articleService.getAllArticleType();
		  return Action.SUCCESS;
	  }
	 
	 
	 /**
	  * 跳转至修改页面
	  * @return
	  * @throws Exception
	  */
	 public String updateArticle()throws Exception
	  {
		  if(null!=article&&null!=article.getId()&&article.getId()>0)
		  {
			   //加载对象
			  article=articleService.getArticleById(article.getId()); 
			  articleType=articleService.getAllArticleType();
		  }
		  return "edite";
	  }
	 
	/**
	 * 修改文章
	 * @return
	 * @throws Exception
	 */
	 public String updateSaveArticle()throws Exception
	  {
		  if(null!=article&&null!=article.getId()&&article.getId()>0)
		  {
			    Article old=articleService.getArticleById(article.getId());
		    	article.setContentPic(HtmlRegexpUtil.getAllPics(article.getContent()));
		    	if(null!=old)
		    	{
		    		 old.setTitle(article.getTitle());
		    		 old.setSorts(article.getSorts());
		    		 old.setAbstracts(article.getAbstracts());
		    		 old.setAuthor(article.getAuthor());
		    		 old.setContent(article.getContent());
		    		 old.setFromaddr(article.getFromaddr());
		    		 old.setFromdesc(article.getFromdesc());
		    		 old.setIsred(article.getIsred());
		    		 old.setKeyword(article.getKeyword());
		    		 old.setArticleType(article.getArticleType());
		    		 old.setIspass(true);
		    		//处理内容图片
		    		if(null!=old.getContentPic()&&null!=article.getContentPic()&&(!article.getContentPic().equals(old.getContentPic())))
		    		{
		    			String orpath=ServletActionContext.getServletContext().getRealPath("res/upres/kind_pic");
		    			String oldpic=old.getContentPic();
		    			String files[]=oldpic.split("&&");
		    			for(int i=0;i<files.length;i++)
		    			{  
		    				if(article.getContentPic().indexOf(files[i])==-1)
		    				{
		    				File f=new File(orpath+File.separator+files[i]);
		    				if(f.exists())f.delete();
		    				}
		    			}
		    			old.setContentPic(article.getContentPic());
		    		}

		    		/*
		    		try {
						//快速复制源对象中的所有属性到目标对象中
		    			//将article赋值给old,国为 old在session中
						BeanUtils.copyProperties(old,article);
					} catch (Exception e) {
						e.printStackTrace();
					}
					

					*/
		    		
		    		
	        		if(articleService.updateArticle(old))
	        		{
	        			this.createArticleHtml(old);//生成html文件
	        			this.addActionMessage("修改文章成功");
	        		}else
	        		{
	        			this.addActionError("修改文章失败");
	        		}
		    	}
		    	
		  }else
		  {
			  this.addActionError("修改的对象不能为空！");
		  }
		  return browseArticle();
	  }
	 
	 /**
	  * 审核文章
	  * @return
	  * @throws Exception
	  */
	public String auditArticle()throws Exception
	{
	    if(this.audit(article))
	    {
	    	this.addActionMessage("审核成功");
	    }else
	    {
	    	this.addActionError("审核失败");
	    }
		  return browseArticle();
	}
	 /**
	  * 审核文章的方法封装
	  * @param article
	  * @return
	  */
	public boolean audit(Article article)
	{
		boolean re=false;
		 if(null!=article&&null!=article.getId()&&article.getId()>0)
		  {
			    Article old=articleService.getArticleById(article.getId());
			    old.setIspass(true);
		       re=articleService.updateArticle(old);
		  }
		 return re;
	}
	 /**
	  * 批量审核
	  * @return
	  * @throws Exception
	  */
	 public String auditBatchArticle()throws Exception
	 {
		 boolean result=true;
		 if(null!=ids&&ids.length>0)
		 {
			    for(int i=0;i<ids.length;i++)
			    {
			    	Article tem=articleService.getArticleById(ids[i]);
			    	 if(null==tem||!this.audit(tem))result=false;
			    }
		 }
		      if(result)
	    		{
	    			this.addActionMessage("批量审核成功");
	    		}
	    		else
	    		{
	    			this.addActionError("批量审核失败");
	    		}
		  return browseArticle();  
	 }
	 

	 /**
	  * 删除文章
	  * @return
	  * @throws Exception
	  */
	public String deleteArticle()throws Exception
	  {
			if(this.delete(article))
			 {
		         this.addActionMessage("删除文章成功！");
			 }else
			 {
				 this.addActionError("删除文章失败！");
			 }
		     return browseArticle();  
	  }
	 /**
	  * 删除文章的方法封装
	  * @param article
	  * @return
	  */
	public boolean delete(Article article)
	{
		  if(null!=article&&null!=article.getId()&&article.getId()>0)
		  {
				 Article tem=articleService.getArticleById(article.getId()); 
				 if(null!=tem&&null!=tem.getContentPic()&&!"".equals(tem.getContentPic()))
				 {
						String editorPath="res/upres/kind_pic";
						String tarEditorPath=ServletActionContext.getServletContext().getRealPath(editorPath);
						String [] files=tem.getContentPic().split("&&");
						for(String tt:files)
						{
							File f=new File(tarEditorPath+File.separator+tt);
							if(f.exists()) f.delete();
						}
				 }
                //删除文件
				
				  if(null!=article.getArticleType()&&null!=article.getArticleType().getId()&&article.getArticleType().getId()>0)
				  {
					  String realpath=ServletActionContext.getServletContext().getRealPath("html/article/a"+article.getArticleType().getId()+article.getId()+".html");
						  File parent=new File(realpath);
						 if(parent.exists()) parent.delete();
				  }
		  }  
		  return  articleService.deletyArticleById(article.getId());
	}
	/**
	 * 批量删除文章
	 * @return
	 * @throws Exception
	 */
	 public String deleteBatchArticle()throws Exception
	  {
		  boolean result=true;
		  if(null!=ids&&ids.length>0)
	    	{ 
			     for(int i=0;i<ids.length;i++)
			     {
			    	 Article tem=articleService.getArticleById(ids[i]);
			    	 if(null==tem||!this.delete(tem))result=false;
			     }
	    		if(result)
	    		{
	    			this.addActionMessage("批量删除成功");
	    		}
	    		else
	    		{
	    			this.addActionError("批量删除失败");
	    		}
	    	}
		  return browseArticle();  
	  }
	/**
	 * 批量生成html
	 * @return
	 * @throws Exception
	 */
	 public  String pubBatchArticle()throws Exception
	 {
		
		if(null!=ids&&ids.length>0)
		 {
			 for(int i=0;i<ids.length;i++)
			 {
				 Article tem=articleService.getArticleById(ids[i]);
				 if(null!=tem) this.createArticleHtml(tem);
			 }
		 }
		    this.addActionMessage("批量发布成功");
			 return browseArticle(); 
	 }
	 /**
	  * 生成文章的html页面
	  * @param article
	  * @throws IOException
	  */
	 public void createArticleHtml(Article article) throws IOException
		{
			//HttpServletRequest request = ServletActionContext.getRequest();
			//String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();				
			String basePath=this.getText("red.basePath");
			//String url=basePath+"/red/article/articleContent?article.id="+article.getId();
			String url=basePath+"/"+MessageFormat.format(this.getText("red.html.article.url"), article.getId());
			
			//创建静态页面生成器实例
			HtmlGenerator hg = new HtmlGenerator(basePath);
			String realPath=ServletActionContext.getServletContext().getRealPath("/"+this.getText("red.html.article.path")+"/a"+article.getArticleType().getId()+article.getId()+".html");
			//发布成静态页面
			if (hg.createHtmlPage(url,realPath))
			{
			  this.addActionMessage("生成html："+article.getArticleType().getId()+article.getId()+".html");				
			}
			/*  String modpath=ServletActionContext.getServletContext().getRealPath("res/html_temp/article_temp.html");
			  String modfile=FileUtils.readFileToString(new File(modpath), "gbk");
			  modfile= modfile.replaceAll("###title###", article.getTitle());
			  modfile= modfile.replaceAll("###author###", article.getAuthor());
			  modfile= modfile.replaceAll("###content###", article.getContent());
			  modfile= modfile.replaceAll("###fromaddr###", article.getFromaddr());
			  modfile= modfile.replaceAll("###fromdesc###", article.getFromdesc());
			  modfile= modfile.replaceAll("###articleType###", article.getArticleType().getName());
			  
			  SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			  modfile.replaceAll("###dates###",sf.format(new Date()) );
			  if(article.getKeyword().indexOf(" ")!=-1)
			  {
				  String allkey[]=article.getKeyword().split("\\s{1,}");
				  String str="";
				  for(int i=0;i<allkey.length;i++)
				  {
					  str=str+","+allkey[i];
				  }
				  modfile=modfile.replaceAll("###keyword###", str);
			  }else
			  {
				  modfile=modfile.replaceAll("###keyword###", article.getKeyword());
			  }
			  String outpath=ServletActionContext.getServletContext().getRealPath("res/article/a"+article.getArticleType().getId()+article.getId()+".html");
			  FileUtils.writeStringToFile(new File(outpath), modfile, "gbk");*/
		}

	 
	 
	 
	 
	/****************************GET AND　SET****************************************/ 
	public List<ArticleType> getArticleType() {
		return articleType;
	}
	public void setArticleType(List<ArticleType> articleType) {
		this.articleType = articleType;
	}
	public Article getArticle() {
		return article;
	}
	public void setArticle(Article article) {
		this.article = article;
	}
	
	
	public Pager getPager() {
		return pager;
	}

	public void setPager(Pager pager) {
		this.pager = pager;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public List<Article> getArticleList() {
		return articleList;
	}

	public void setArticleList(List<Article> articleList) {
		this.articleList = articleList;
	}

	public Integer[] getIds() {
		return ids;
	}

	public void setIds(Integer[] ids) {
		this.ids = ids;
	}

	
}

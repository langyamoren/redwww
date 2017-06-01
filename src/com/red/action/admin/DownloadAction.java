package com.red.action.admin;
import java.io.File;
import java.io.IOException;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.Action;
import com.red.action.ActionBase;
import com.red.beans.DownType;
import com.red.beans.Download;
import com.red.page.PageDiv;
import com.red.page.Pager;
import com.red.util.HtmlGenerator;

public class DownloadAction extends ActionBase
{
	private static final long serialVersionUID = 2619591578880387176L;
	private Download download;
    private List<DownType>  downType=new ArrayList<DownType>();
    private Pager pager;       //分页的page
    private int pageSize=20;    //每页大小
    private int totalCount=0;  //总记录数
    private int pageNo;        //当前页数
    private List<Download> downloadList=new ArrayList<Download>();
    private Integer []ids; //批量删除的id
	/**
	 * 跳至增加下载页
	 * @return
	 * @throws Exception
	 */
	public String addDownload()throws Exception
	{
		downType=downloadService.getTypesAll();
		return "add";
	}
	/**
	 * 增加下载
	 * @return
	 * @throws Exception
	 */
	public String addSaveDownload()throws Exception
	{
		  if(null!=download&&null!=download.getDownType()&&download.getDownType().getId()>0)
		  {   
			    download.setIspass(false);
			    download.setCounts(0);
			    download.setIspop(false);
			    downloadService.addDownload(download);
			    //this.createDownloadHtml(download);
			    this.addActionMessage("增加下载成功");
		  }else
		  {
			 this.addActionError("添加下载失败！"); 
		  }
	
	  return this.addDownload();  
	}
	/**
	 * 加载所有下载内容
	 * @return
	 * @throws Exception
	 */
	 public String browseDownload()throws Exception
	  {
		 if(null==pager)pager=new Pager();
			if(null==download||null==download.getDownType()||null==download.getDownType().getId()||download.getDownType().getId()<=0)
			  {
				  PageDiv<Download> pd=downloadService.getLastDownload(pager.getOffset(), pageSize);

				  if(null!=pd)
				  {
					  downloadList=pd.getList();
					  totalCount=pd.getTotalCount();
				  }
			  }else
			  {
				  PageDiv<Download> pd=downloadService.getMoreDownload(download.getDownType().getId(), pager.getOffset(), pageSize);
				  if(null!=pd)
				  {
					  downloadList=pd.getList();
					  totalCount=pd.getTotalCount();
				  }
			  }
			downType=downloadService.getTypesAll();
			  return Action.SUCCESS;
	  }
	
	/**
	 * 跳至修改页面
	 * @return
	 * @throws Exception
	 */
	  public String updateDownload()throws Exception
	  {
		  if(null!=download&&null!=download.getId()&&download.getId()>0)
		  {
			   //加载对象
			  download=downloadService.getDownloadById(download.getId());
			  downType=downloadService.getTypesAll();
		  }
		  return "edit";
	  }
	/**
	 * 保存修改
	 * @return
	 * @throws Exception
	 */
	  public String updateSaveDownload()throws Exception
	  {
		  if(null!=download&&null!=download.getId()&&download.getId()>0)
		  {
			    Download old=downloadService.getDownloadById(download.getId());
			   // download.setContentPic(HtmlRegexpUtil.getAllPics(article.getContent()));
		    	if(null!=old)
		    	{
		    		old.setTitle(download.getTitle());
		    		old.setContentType(download.getContentType());
		    		old.setDescs(download.getDescs());
		    		old.setDownType(download.getDownType());
		    		old.setIsfree(download.getIsfree());
		    		old.setIspass(true);
		    		old.setIspop(download.getIspop());
		    		old.setKeyword(download.getKeyword());
		    		old.setLanguage(download.getLanguage());
		    		old.setOldName(download.getOldName());
		    		if(null!=old&&null!=old.getPicture()&&!old.getPicture().equals(download.getPicture()))
					{
						//删以前的首页图
						String path="res/upres/soft_pic/"+old.getPicture();
						String realpath=ServletActionContext.getServletContext().getRealPath(path);
						File f=new File(realpath);
						if(f.exists())f.delete();
						old.setPicture(download.getPicture());
					}
		    		
		    		old.setPlatform(download.getPlatform());
		    		old.setSizes(download.getSizes());
	        		if(downloadService.updateDownload(old))
	        		{
	        			 this.createDownloadHtml(old);//生成html文件
	        			this.addActionMessage("修改下载成功");
	        		}else
	        		{
	        			this.addActionError("修改下载失败");
	        		}
		    		 
		    		}
 	
		  }else
		  {
			  this.addActionError("修改的对象不能为空！");
		  }
		  return browseDownload();
	  }
	
	  
		 /**
		  * 审核下载
		  * @return
		  * @throws Exception
		  */
		public String auditDownload()throws Exception
		{
		    if(this.audit(download))
		    {
		    	this.addActionMessage("审核成功");
		    }else
		    {
		    	this.addActionError("审核失败");
		    }
			  return browseDownload();
		}
		 /**
		  * 审核下载的方法封装
		  * @param article
		  * @return
		  */
		public boolean audit(Download download)
		{
			boolean re=false;
			 if(null!=download&&null!=download.getId()&&download.getId()>0)
			  {
				    Download old=downloadService.getDownloadById(download.getId());
				    old.setIspass(true);
			       re=downloadService.updateDownload(old);
			  }
			 return re;
		}
		 /**
		  * 批量审核
		  * @return
		  * @throws Exception
		  */
		 public String auditBatchDownload()throws Exception
		 {
			 boolean result=true;
			 if(null!=ids&&ids.length>0)
			 {
				    for(int i=0;i<ids.length;i++)
				    {
				    	 Download tem=downloadService.getDownloadById(ids[i]);
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
			  return browseDownload();  
		 }
		 
	  /**
	   * 删除下载
	   * @return
	   * @throws Exception
	   */
	  public String deleteDownload()throws Exception
	  {
		  if(this.delete(download))
		  {
			  this.addActionMessage("删除下载成功");
		  }else
		  {
			  this.addActionError("删除下载失败");
		  }
		  return browseDownload();
	  }
		 /**
		  * 删除下载的方法封装
		  * @param article
		  * @return
		  */
		public boolean delete(Download down)
		{
			  if(null!=down&&null!=down.getId()&&down.getId()>0)
			  {
				 	//删除文件
					  if(null!=down.getDownType()&&null!=down.getDownType().getId()&&down.getDownType().getId()>0)
					  {
						  String realpath=ServletActionContext.getServletContext().getRealPath("res/download/d"+down.getDownType().getId()+down.getId()+".html");
							  File parent=new File(realpath);
							 if(parent.exists()) parent.delete();
					  }
			  }  
			  return  downloadService.deletyDownloadById(down.getId());
		}
	  /**
	   * 批量删除
	   * @return
	   * @throws Exception
	   */
	  public String deleteBatchDownload()throws Exception
	  {
		  boolean result=true;
		  if(null!=ids&&ids.length>0)
	    	{ 
			     for(int i=0;i<ids.length;i++)
			     {
			    	 Download tem=downloadService.getDownloadById(ids[i]);
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
		  return browseDownload(); 
	  }
	  
	  /**
		 * 批量生成html
		 * @return
		 * @throws Exception
		 */
		 public  String pubBatchDownload()throws Exception
		 {
			
			if(null!=ids&&ids.length>0)
			 {
				 for(int i=0;i<ids.length;i++)
				 {
					 Download tem=downloadService.getDownloadById(ids[i]);
					 if(null!=tem) this.createDownloadHtml(tem);
				 }
			 }
			    this.addActionMessage("批量发布成功");
				 return browseDownload(); 
		 }
	  
	  /**
		  * 生成下载的html页面
		  * @param article
		  * @throws IOException
		  */
		 public void createDownloadHtml(Download down) throws IOException
			{
			   String basePath=this.getText("red.basePath");
				//String url=basePath+"/red/article/articleContent?article.id="+article.getId();
				String url=basePath+"/"+MessageFormat.format(this.getText("red.html.down.url"), down.getId());
				
				//创建静态页面生成器实例
				HtmlGenerator hg = new HtmlGenerator(basePath);
				String realPath=ServletActionContext.getServletContext().getRealPath("/"+this.getText("red.html.down.path")+"/d"+down.getDownType().getId()+down.getId()+".html");
				//发布成静态页面
				if (hg.createHtmlPage(url,realPath))
				{
				  this.addActionMessage("生成html："+down.getDownType().getId()+down.getId()+".html");				
				}
			    /* if(null!=down.getDownType()&&down.getDownType().getId()>0)
			    	 down.setDownType(downloadService.getDownType(down.getDownType().getId()));
				 String modpath=ServletActionContext.getServletContext().getRealPath("res/html_temp/download_temp.html");
				  String modfile=FileUtils.readFileToString(new File(modpath), "gbk");
				  modfile= modfile.replaceAll("###title###",down.getTitle());
				  modfile= modfile.replaceAll("###desc###", down.getDescs());
				  modfile= modfile.replaceAll("###language###", down.getLanguage());
				  modfile= modfile.replaceAll("###picture###", null==down.getPicture()?"":down.getPicture());
				  modfile= modfile.replaceAll("###size###", down.getSizes());
				  modfile= modfile.replaceAll("###downType###",down.getDownType().getName());
				  modfile= modfile.replaceAll("###softFile###", down.getSoftFile());
				  modfile= modfile.replaceAll("###count###", down.getCounts().toString());
				  modfile= modfile.replaceAll("###id###", down.getId().toString());
				  modfile= modfile.replaceAll("###isfree###", down.getIsfree().toString());
				  
				  SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				  modfile.replaceAll("###dates###",sf.format(new Date()) );
				  
				  
				  if(down.getKeyword().indexOf(" ")!=-1)
				  {
					  String allkey[]=down.getKeyword().split("\\s{1,}");
					  String str="";
					  for(int i=0;i<allkey.length;i++)
					  {
						  str=str+","+allkey[i];
					  }
					  modfile=modfile.replaceAll("###keyword###", str);
				  }else
				  {
					  modfile=modfile.replaceAll("###keyword###", down.getKeyword());
				  }
				  
				  String outpath=ServletActionContext.getServletContext().getRealPath("res/download/d"+down.getDownType().getId()+down.getId()+".html");
				  FileUtils.writeStringToFile(new File(outpath), modfile, "gbk");*/
			}

/*******************GET AND　SET******************************/  
	public Download getDownload() {
		return download;
	}

	public void setDownload(Download download) {
		this.download = download;
	}

	public List<DownType> getDownType() {
		return downType;
	}

	public void setDownType(List<DownType> downType) {
		this.downType = downType;
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

	public List<Download> getDownloadList() {
		return downloadList;
	}

	public void setDownloadList(List<Download> downloadList) {
		this.downloadList = downloadList;
	}

	public Integer[] getIds() {
		return ids;
	}

	public void setIds(Integer[] ids) {
		this.ids = ids;
	}

}

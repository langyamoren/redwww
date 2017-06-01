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
    private Pager pager;       //��ҳ��page
    private int pageSize=20;    //ÿҳ��С
    private int totalCount=0;  //�ܼ�¼��
    private int pageNo;        //��ǰҳ��
    private List<Download> downloadList=new ArrayList<Download>();
    private Integer []ids; //����ɾ����id
	/**
	 * ������������ҳ
	 * @return
	 * @throws Exception
	 */
	public String addDownload()throws Exception
	{
		downType=downloadService.getTypesAll();
		return "add";
	}
	/**
	 * ��������
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
			    this.addActionMessage("�������سɹ�");
		  }else
		  {
			 this.addActionError("�������ʧ�ܣ�"); 
		  }
	
	  return this.addDownload();  
	}
	/**
	 * ����������������
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
	 * �����޸�ҳ��
	 * @return
	 * @throws Exception
	 */
	  public String updateDownload()throws Exception
	  {
		  if(null!=download&&null!=download.getId()&&download.getId()>0)
		  {
			   //���ض���
			  download=downloadService.getDownloadById(download.getId());
			  downType=downloadService.getTypesAll();
		  }
		  return "edit";
	  }
	/**
	 * �����޸�
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
						//ɾ��ǰ����ҳͼ
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
	        			 this.createDownloadHtml(old);//����html�ļ�
	        			this.addActionMessage("�޸����سɹ�");
	        		}else
	        		{
	        			this.addActionError("�޸�����ʧ��");
	        		}
		    		 
		    		}
 	
		  }else
		  {
			  this.addActionError("�޸ĵĶ�����Ϊ�գ�");
		  }
		  return browseDownload();
	  }
	
	  
		 /**
		  * �������
		  * @return
		  * @throws Exception
		  */
		public String auditDownload()throws Exception
		{
		    if(this.audit(download))
		    {
		    	this.addActionMessage("��˳ɹ�");
		    }else
		    {
		    	this.addActionError("���ʧ��");
		    }
			  return browseDownload();
		}
		 /**
		  * ������صķ�����װ
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
		  * �������
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
		    			this.addActionMessage("������˳ɹ�");
		    		}
		    		else
		    		{
		    			this.addActionError("�������ʧ��");
		    		}
			  return browseDownload();  
		 }
		 
	  /**
	   * ɾ������
	   * @return
	   * @throws Exception
	   */
	  public String deleteDownload()throws Exception
	  {
		  if(this.delete(download))
		  {
			  this.addActionMessage("ɾ�����سɹ�");
		  }else
		  {
			  this.addActionError("ɾ������ʧ��");
		  }
		  return browseDownload();
	  }
		 /**
		  * ɾ�����صķ�����װ
		  * @param article
		  * @return
		  */
		public boolean delete(Download down)
		{
			  if(null!=down&&null!=down.getId()&&down.getId()>0)
			  {
				 	//ɾ���ļ�
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
	   * ����ɾ��
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
	    			this.addActionMessage("����ɾ���ɹ�");
	    		}
	    		else
	    		{
	    			this.addActionError("����ɾ��ʧ��");
	    		}
	    	}
		  return browseDownload(); 
	  }
	  
	  /**
		 * ��������html
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
			    this.addActionMessage("���������ɹ�");
				 return browseDownload(); 
		 }
	  
	  /**
		  * �������ص�htmlҳ��
		  * @param article
		  * @throws IOException
		  */
		 public void createDownloadHtml(Download down) throws IOException
			{
			   String basePath=this.getText("red.basePath");
				//String url=basePath+"/red/article/articleContent?article.id="+article.getId();
				String url=basePath+"/"+MessageFormat.format(this.getText("red.html.down.url"), down.getId());
				
				//������̬ҳ��������ʵ��
				HtmlGenerator hg = new HtmlGenerator(basePath);
				String realPath=ServletActionContext.getServletContext().getRealPath("/"+this.getText("red.html.down.path")+"/d"+down.getDownType().getId()+down.getId()+".html");
				//�����ɾ�̬ҳ��
				if (hg.createHtmlPage(url,realPath))
				{
				  this.addActionMessage("����html��"+down.getDownType().getId()+down.getId()+".html");				
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

/*******************GET AND��SET******************************/  
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

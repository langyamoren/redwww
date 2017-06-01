package com.red.action.web;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.Action;
import com.red.action.ActionBase;
import com.red.beans.DownType;
import com.red.beans.Download;
import com.red.page.PageDiv;
import com.red.page.Pager;

public class DownloadListAction extends ActionBase
{
    /**
	 * 
	 */
	private static final long serialVersionUID = -2584583939218052100L;
	private Integer typeId;
	private DownType downType;
	private List<Download> downloadList=new ArrayList<Download>();
	
	//�����������б��list
    private Pager pager;       //��ҳ��page
    private int pageSize=30;    //ÿҳ��С
    private int totalCount=0;  //�ܼ�¼��
    private int pageNo=1;        //��ǰҳ��
    
    
    
	@Override
	public String execute() throws Exception 
	{

		if(null==pager) pager=new Pager();
		PageDiv<Download> pd=null;
		if(null!=typeId&&typeId>0)
		{
			downType=downloadService.getDownType(typeId);
		  pd=downloadService.getMoreDownload(typeId, pager.getOffset(), pageSize);
		}
		  if(null!=pd&&null!=pd.getList()&&pd.getList().size()>0)
		  {
			  downloadList=pd.getList();
			  totalCount=pd.getTotalCount();
		  }
		  
		return Action.SUCCESS;
	}
	
	
	public Integer getTypeId() {
		return typeId;
	}
	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}
	public List<Download> getDownloadList() {
		return downloadList;
	}
	public void setDownloadList(List<Download> downloadList) {
		this.downloadList = downloadList;
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


	public DownType getDownType() {
		return downType;
	}


	public void setDownType(DownType downType) {
		this.downType = downType;
	}
    
    
    
}

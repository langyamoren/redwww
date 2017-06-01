package com.red.action.web;

import com.opensymphony.xwork2.Action;
import com.red.action.ActionBase;
import com.red.beans.Download;


public class DownloadDescAction extends ActionBase
{
	private static final long serialVersionUID = 8834675014557929520L;
	private Download download;
	private Integer downId;
	@Override
	public String execute() throws Exception 
	{
		if(null!=downId&&downId>0)
		{
			download=downloadService.getDownloadById(downId);
			//long sizem=Long.parseLong(download.getSizes());
			
			//download.setSizes(new java.text.DecimalFormat("###.##").format(sizem/1024/1024.0));
		}
		return Action.SUCCESS;
	}
	public Download getDownload() {
		return download;
	}
	public void setDownload(Download download) {
		this.download = download;
	}
	public Integer getDownId() {
		return downId;
	}
	public void setDownId(Integer downId) {
		this.downId = downId;
	}
	
	

}

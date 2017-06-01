package com.red.action.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.red.action.ActionBase;
import com.red.beans.Download;
public class DownloadFileAction extends ActionBase 
{
	private static final long serialVersionUID = 7097202653252468718L;
	private Integer downId;
	private String inputPath;
	private Download download;
	private InputStream fileStream;
	@Override
	public String execute() throws Exception 
	{
		String re=Action.SUCCESS;
		if(null!=downId&&downId>0)
		{
			download=downloadService.getDownloadById(downId);
			download.setCounts(download.getCounts()+1);
			downloadService.updateDownload(download);
			inputPath=ServletActionContext.getServletContext().getRealPath("/res/upres/soft")+File.separator+download.getSoftFile();
			download.setOldName(new String(download.getOldName().getBytes(), "ISO8859-1"));
		}
		return re;
	}

	public InputStream getFileStream()throws Exception
	{
		//System.out.println(ServletActionContext.getServletContext().getResourceAsStream("D:\\develop\\JavaEE\\workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\red_www3\\upload\\soft\\20101213085015828.zip"));
		File file=new File(inputPath);
		if(file.exists())
		return new FileInputStream(inputPath);
		else
		return null;
	}
	
	public Integer getDownId() {
		return downId;
	}
	public void setDownId(Integer downId) {
		this.downId = downId;
	}
	public String getInputPath() {
		return inputPath;
	}
	public void setInputPath(String inputPath) {
		this.inputPath = inputPath;
	}
	public Download getDownload() {
		return download;
	}
	public void setDownload(Download download) {
		this.download = download;
	}
}

package com.red.action.ajax;

import java.io.File;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.red.action.ActionBase;

public class DeleteTemFileAction extends ActionBase 
{

	private static final long serialVersionUID = 1672926112386904213L;
	private String fileName;
	private String upPath;
	@Override
	public String execute() throws Exception 
	{
		if(null!=fileName&&!"".equals(fileName))
		{
			   String realPath=ServletActionContext.getServletContext().getRealPath(upPath+"/"+fileName);
			   File f=new File(realPath);
			   if(f.exists())f.delete();
		}
		return Action.SUCCESS;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getUpPath() {
		return upPath;
	}
	public void setUpPath(String upPath) {
		this.upPath = upPath;
	}
	

}

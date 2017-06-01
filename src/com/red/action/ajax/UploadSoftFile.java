package com.red.action.ajax;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.json.annotations.JSON;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
public class UploadSoftFile extends ActionSupport
{
	private static final long serialVersionUID = -3064772575460915774L;
	   private File soft;  //文件域名称
	   private String softContentType;//文件类型 
	   private String softFileName;//文件名
       private String upFileName=null;//上传到服务器上的文件名
       private String upPath;//上传到服务器的路径
       private String fileSize;
       @Override
       public String execute() throws Exception 
       {
    	   DecimalFormat df  = new DecimalFormat("##0.00");
    	   fileSize=df.format(soft.length()/1024.0/1024.0);
       		FileInputStream fi=new FileInputStream(soft);
       		SimpleDateFormat sf=new SimpleDateFormat("yyyyMMddHHmmssSSS");
       		String randName=sf.format(new Date());
       	    int index=softFileName.indexOf(".");
       		String ext=softFileName.substring(index);
       		String newfile=randName+ext;
       		upFileName=newfile;
       		String upload=ServletActionContext.getServletContext().getRealPath(upPath);
       		File path=new File(upload);
       		if(!path.exists())path.mkdirs();
       		File f=new File(path,newfile);
       		FileOutputStream fo=new FileOutputStream(f);
       		BufferedInputStream bi=new BufferedInputStream(fi);
       		BufferedOutputStream bo=new BufferedOutputStream(fo);
       		byte []tem=new byte[4096];
       		int len=0;
       		while((len=bi.read(tem))>0)
       		{
       			bo.write(tem,0,len);
       		}
       		bi.close();
       		bo.close();
       		//-------生成缩略图----------      		
       	return Action.SUCCESS;
       }
      
       public File getSoft() {
		return soft;
	}

	public void setSoft(File soft) {
		this.soft = soft;
	}

	public String getSoftContentType() {
		return softContentType;
	}

	public void setSoftContentType(String softContentType) {
		this.softContentType = softContentType;
	}

	public String getSoftFileName() {
		return softFileName;
	}

	public void setSoftFileName(String softFileName) {
		this.softFileName = softFileName;
	}

	public String getUpFileName() {
		return upFileName;
	}

	public void setUpFileName(String upFileName) {
		this.upFileName = upFileName;
	}

       @JSON(serialize=false)
       public String getUpPath() {
       	return upPath;
       }
       public void setUpPath(String upPath) {
       	this.upPath = upPath;
       }

	public String getFileSize() {
		return fileSize;
	}

	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}
        
}

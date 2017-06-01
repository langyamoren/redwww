package com.red.action.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.red.action.ActionBase;
import com.red.beans.Chapter;



public class DownloadVodAction extends ActionBase 
{
	private static final long serialVersionUID = 7097202653252468718L;
	private String  inputPath;	
	private String contentType;
	private String originalName;
	private Integer  chapterId;
	private String vodName;
 	private InputStream fileStream;
	private Integer index;
	@Override
	public String execute() throws Exception 
	{
	   //HttpServletResponse response =ServletActionContext.getResponse();
	   String re=Action.SUCCESS;
	   /*¶ÁÈ¡ÎÄ¼þ*/
	   if(null!=vodName&&vodName.length()>0)
		{
		
		if(null!=vodName&&vodName.length()>0)
		{
			inputPath=ServletActionContext.getServletContext().getRealPath("res/upres/vod")+File.separator+vodName;
			System.out.println("EEE"+inputPath);
			File f=new File(inputPath);
			if(f.exists()&&chapterId>0)
			{
			  Chapter chapter=courseService.getChapterById(chapterId);
		      int inx=vodName.lastIndexOf('.');
		      String extfile=vodName.substring(inx);
			  
			  originalName=new String((chapter.getTitle()+index+extfile).getBytes(), "ISO8859-1");
			}else
			{
				re="novod";
			}
		}else
		{
			re="novod";
		}
	}
		return re;
		
	}
	public InputStream getFileStream() throws Exception
	{
		return new FileInputStream(inputPath);

	}

	public String getInputPath() {
		return inputPath;
	}
	public void setInputPath(String inputPath) {
		this.inputPath = inputPath;
	}
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	public String getOriginalName() {
		return originalName;
	}
	public void setOriginalName(String originalName) {
		this.originalName = originalName;
	}
	public Integer getChapterId() {
		return chapterId;
	}
	public void setChapterId(Integer chapterId) {
		this.chapterId = chapterId;
	}
/* public void setFileStream(InputStream fileStream) {
		this.fileStream = fileStream;
	}*/
	public String getVodName() {
		return vodName;
	}
	public void setVodName(String vodName) {
		this.vodName = vodName;
	}
	public Integer getIndex() {
		return index;
	}
	public void setIndex(Integer index) {
		this.index = index;
	}
	

}

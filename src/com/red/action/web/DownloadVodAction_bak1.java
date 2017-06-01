package com.red.action.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.red.action.ActionBase;
import com.red.beans.Chapter;



public class DownloadVodAction_bak1 extends ActionBase 
{
	private static final long serialVersionUID = 7097202653252468718L;
	private Integer  chapterId;
	private String vodName;
	private Integer index;

	@Override
	public String execute() throws Exception 
	{
        HttpServletResponse res=ServletActionContext.getResponse();
        /*读取文件*/
	   if(null!=vodName&&vodName.length()>0)
		{
			String inputPath=ServletActionContext.getServletContext().getRealPath("res/upres/vod")+File.separator+vodName;
			File file=new File(inputPath);
	       
	        /*如果文件存在*/
			if(file.exists()&&chapterId>0)
			{
			  Chapter chapter=courseService.getChapterById(chapterId);
		      int inx=vodName.lastIndexOf('.');
		      String extfile=vodName.substring(inx);
	            //String filename = URLEncoder.encode(file.getName(), enc);
	            //response.reset();
	            res.setContentType("application/octet-stream");
	            //application/octet-stream
	            res.addHeader("Content-Disposition", "attachment; filename=\"" + new String((chapter.getTitle()+index+extfile).getBytes(), "ISO8859-1") + "\"");
	            int fileLength = (int) file.length();
	            res.setContentLength(fileLength);
	            /*如果文件长度大于0*/
	            if (fileLength != 0)
	            {
	                /*创建输入流*/
	                InputStream inStream = new FileInputStream(file);
	                byte[] buf = new byte[4096];
	                /*创建输出流*/
	                ServletOutputStream servletOS = res.getOutputStream();
	                int readLength;
	                while (((readLength = inStream.read(buf)) != -1)) 
	                {
	                    servletOS.write(buf, 0, readLength);
	                }
	                
	                inStream.close();
	                servletOS.close();
	            }
	            
			}
		}
                return null;
	}

	public Integer getChapterId() {
		return chapterId;
	}

	public void setChapterId(Integer chapterId) {
		this.chapterId = chapterId;
	}

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

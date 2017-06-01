package com.red.action.ajax;


import java.io.File;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;
import org.json.simple.JSONObject;
import com.opensymphony.xwork2.ActionSupport;
import com.red.util.FileUploadUtil;


public class EditorUploadFile extends ActionSupport
{

	   private static final long serialVersionUID = 1L;
	   private File imgFile;  //文件域名称
	   private String imgFileContentType;//文件类型 
	   private String imgFileFileName;//文件名  
       private int width;//宽度
       private int height;//高度
       private String upPath;//上传到服务器的路径
@SuppressWarnings("unchecked")
@Override
public String execute() throws Exception 
{
    HttpServletResponse response=ServletActionContext.getResponse();
	response.setContentType("text/html; charset=UTF-8");
	PrintWriter out=response.getWriter();

		 String upload=ServletActionContext.getServletContext().getRealPath(upPath);
		 File upFile= FileUploadUtil.UploadFile(imgFile, imgFileFileName, upload);
		 
		 File small= FileUploadUtil.createSamllPic(width, height, upFile);
	    
		 if(null!=small&&small.exists())upFile.delete(); 
	  
	        String url=ServletActionContext.getRequest().getContextPath()+"/"+upPath+"/"+small.getName();
			JSONObject obj = new JSONObject();
			obj.put("error", 0);
			obj.put("url", url);
			out.println(obj.toJSONString());
		out.close();
	return null;
}



public File getImgFile() {
	return imgFile;
}
public void setImgFile(File imgFile) {
	this.imgFile = imgFile;
}
public String getImgFileContentType() {
	return imgFileContentType;
}
public void setImgFileContentType(String imgFileContentType) {
	this.imgFileContentType = imgFileContentType;
}
public String getImgFileFileName() {
	return imgFileFileName;
}
public void setImgFileFileName(String imgFileFileName) {
	this.imgFileFileName = imgFileFileName;
}

public int getWidth() {
	return width;
}
public void setWidth(int width) {
	this.width = width;
}
public int getHeight() {
	return height;
}
public void setHeight(int height) {
	this.height = height;
}
public String getUpPath() {
	return upPath;
}
public void setUpPath(String upPath) {
	this.upPath = upPath;
}

@SuppressWarnings({ "unused", "unchecked" })
private String getError(String message) {
	JSONObject obj = new JSONObject();
	obj.put("error", 1);
	obj.put("message", message);
	return obj.toJSONString();
}
  
}

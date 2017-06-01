package com.red.action.ajax;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.imageio.ImageIO;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.json.annotations.JSON;
import com.red.util.ImageIOUtil;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
public class UploadDownLoadIndexPic extends ActionSupport
{
	private static final long serialVersionUID = -3064772575460915774L;
	   private File pic;  //�ļ�������
	   private String picContentType;//�ļ����� 
	   private String picFileName;//�ļ���
       private String upFileName=null;//�ϴ����������ϵ��ļ���
       private int width;//���
       private int height;//�߶�
       private String upPath;//�ϴ�����������·��
@Override
public String execute() throws Exception 
{
		FileInputStream fi=new FileInputStream(pic);
		SimpleDateFormat sf=new SimpleDateFormat("yyyyMMddHHmmssSSS");
		String randName=sf.format(new Date());
	    int index=picFileName.indexOf(".");
		String ext=picFileName.substring(index);
		String newfile=randName+ext;
		
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
		//-------��������ͼ----------
        InputStream in = new FileInputStream(f);
        BufferedImage src = ImageIO.read(in);

        String small=path+"/"+randName+"s"+ext;
        ImageIOUtil.write(width, height,small,in, src);
		upFileName=randName+"s"+ext;
		if(f.exists())f.delete();
		
	return Action.SUCCESS;
}
public String getUpFileName() {
	return upFileName;
}
@JSON(serialize=false)
public File  getPic() {
	return pic;
}
public void setPic(File  pic) {
	this.pic = pic;
}
@JSON(serialize=false)
public String getPicContentType() {
	return picContentType;
}
public void setPicContentType(String  picContentType) {
	this.picContentType = picContentType;
}
@JSON(serialize=false)
public String  getPicFileName() {
	return picFileName;
}
public void setPicFileName(String picFileName) {
	this.picFileName = picFileName;
}
@JSON(serialize=false)
public int getWidth() {
	return width;
}

public void setWidth(int width) {
	this.width = width;
}
@JSON(serialize=false)
public int getHeight() {
	return height;
}
public void setHeight(int height) {
	this.height = height;
}
@JSON(serialize=false)
public String getUpPath() {
	return upPath;
}
public void setUpPath(String upPath) {
	this.upPath = upPath;
}
 
}

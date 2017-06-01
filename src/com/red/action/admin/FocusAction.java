package com.red.action.admin;

import java.io.File;
import java.util.List;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.Action;
import com.red.action.ActionBase;
import com.red.beans.Focus;
import com.red.util.FileUploadUtil;

public class FocusAction extends ActionBase 
{
   /**
	 * 
	 */
	private static final long serialVersionUID = -8617036118458567617L;
	
   private Focus focus;
   private List<Focus> focusList;
   
   private File pic;	//�ϴ����ļ�
	private String picContentType;	//�ϴ��ļ�������
	private String picFileName;		//�ϴ��ļ����ļ���
	
	public String upPath;
	public int width;
	public int height;
   
   public String addFocus()throws Exception
   {
	   if(null!=focus)
		  {
			  if(null!=pic&&null!=picFileName&&null!=picContentType)
				  {
					//�����ҳͼƬ��Ϊ�����ϴ�
					String uploadPath=(null!=upPath&&!"".equals(upPath))?upPath:"/upload/focus_pic";
					String targetPath=ServletActionContext.getServletContext().getRealPath(uploadPath);
					//�ϴ�ͼƬ
					File upFile= FileUploadUtil.UploadFile(pic, picFileName, targetPath);
					width=0==width?200:width;
					height=0==height?100:height;
					//��������ͼ
				   // File small= FileUploadUtil.createSamllPic(width, height, upFile);
				    //ɾ ��ԭͼ
			      // if(null!=small&&small.exists())upFile.delete();
					//if(null!=upFile&&upFile.exists())upFile.delete();
	                //�����ϴ���Ƭ�����ƴ������ݿ�
			       focus.setPicture(upFile.getName());
				  }
				  adminService.addFocus(focus);
				  
				 this.addActionMessage("��ӽ�����ɹ���");  
		  }else
		  {
			 this.addActionError("��ӽ�����ʧ�ܣ�"); 
		  }
	
	  return this.browseFocus();  
   }
   public String updateFocus()throws Exception
   {
	   if(null!=focus&&null!=focus.getId()&&focus.getId()>0)
		  {
			    Focus old=adminService.getFocusById(focus.getId());
		    	
		    	if(null!=old)
		    	{
		    		//�������ҳͼƬ�����ϴ�
					  if(null!=pic&&null!=picFileName&&null!=picContentType)
					  {
						//�����ҳͼƬ��Ϊ�����ϴ�
						String uploadPath=(null!=upPath&&!"".equals(upPath))?upPath:"/upload/index_pic";
						String targetPath=ServletActionContext.getServletContext().getRealPath(uploadPath);
						//�ϴ�ͼƬ
						File upFile= FileUploadUtil.UploadFile(pic, picFileName, targetPath);
						width=0==width?200:width;
						height=0==height?100:height;
						//��������ͼ
					   // File small= FileUploadUtil.createSamllPic(width, height, upFile);
					    //ɾ ��ԭͼ
				       //if(null!=small&&small.exists())upFile.delete();
		                //�����ϴ���Ƭ�����ƴ������ݿ�
				       focus.setPicture(upFile.getName());
					  }
		    		//������ҳͼƬ
		    		if(null!=old.getPicture()&&null!=focus.getPicture()&&(!focus.getPicture().equals(old.getPicture())))
		    		{
		    			String orpath=ServletActionContext.getServletContext().getRealPath("upload/focus_pic");
		    			//ɾ��ԭ�ļ�
		    			File f=new File(orpath+File.separator+old.getPicture());
		    			if(f.exists())f.delete();
		    			
		    		}
		    		if((null!=old.getPicture()||!"".equals(old.getPicture()))&&(null==focus.getPicture()||"".equals(focus.getPicture())))
		    		{
		    			focus.setPicture(old.getPicture());
		    		}
	        		if(adminService.updateFocus(focus))
	        		{
	        			this.addActionMessage("�޸Ľ�����ɹ�");
	        		}else
	        		{
	        			this.addActionError("�޸Ľ�����ʧ��");
	        		}
		    	}
		    	
		  }else
		  {
			  this.addActionError("�޸ĵĶ�����Ϊ�գ�");
		  }
	   
	   
	   return browseFocus();
   } 
   public String deleteFocus()throws Exception
   {
	   if(null!=focus&&null!=focus.getId()&&focus.getId()>0)
		  {
				 Focus tem=adminService.getFocusById(focus.getId());
				 if(null!=tem&&null!=tem.getPicture()&&!"".equals(tem.getPicture()))
				 {
					 String indexPath="/res/upres/focus";
					 String tarPath=ServletActionContext.getServletContext().getRealPath(indexPath)+File.separator+tem.getPicture();
					 File f=new File(tarPath);
					 if(f.exists())f.delete();
				 }
				
				 
			 if(adminService.deleteFocusById(focus.getId()))
			 {
		         this.addActionMessage("ɾ��������ɹ���");
			 }else
			 {
				 this.addActionError("ɾ��������ʧ�ܣ�");
			 }
		  }
		  
	   return browseFocus();
   }
   public String browseFocus()throws Exception
   {
	   focusList=adminService.getAllFocus();
	   return Action.SUCCESS;
   }
public Focus getFocus() {
	return focus;
}
public void setFocus(Focus focus) {
	this.focus = focus;
}
public List<Focus> getFocusList() {
	return focusList;
}
public void setFocusList(List<Focus> focusList) {
	this.focusList = focusList;
}
public File getPic() {
	return pic;
}
public void setPic(File pic) {
	this.pic = pic;
}
public String getPicContentType() {
	return picContentType;
}
public void setPicContentType(String picContentType) {
	this.picContentType = picContentType;
}
public String getPicFileName() {
	return picFileName;
}
public void setPicFileName(String picFileName) {
	this.picFileName = picFileName;
}
public String getUpPath() {
	return upPath;
}
public void setUpPath(String upPath) {
	this.upPath = upPath;
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
   
   
   
}

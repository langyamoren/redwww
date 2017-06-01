package com.red.action.admin;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.red.action.ActionBase;
import com.red.beans.Chapter;
import com.red.beans.Course;
public class ChapterAction extends ActionBase 
{
	private static final long serialVersionUID = -3455642619666603340L;
	private List<Chapter> chapterList=new ArrayList<Chapter>();
	private Chapter chapter;
	private Course course;
	private String actionMsg;
	private String soft;//û������
	/**
	 * ����
	 * @return
	 * @throws Exception
	 */
    public String addChapter()throws Exception
    {
    	if(null==chapter||null==chapter.getCourse()||chapter.getCourse().getId()<=0)
    	{
    		this.addActionError("����ȷ��������");
    	}
    	return "add";
    }
    /**
     * ����γ�����
     * @return
     * @throws Exception
     */
    public String addSaveChapter()throws Exception
    {
    	if(null==chapter||null==chapter.getCourse()||chapter.getCourse().getId()<=0)
    	{
    		actionMsg="����ȷ��������";
    	}else
    	{
    		if(courseService.addChapter(chapter))
    		{
    			actionMsg="���ӿγ����ݳɹ�";
    			course=courseService.getCourseById(chapter.getCourse().getId());
    		}else
    		{
    			actionMsg="���ӿγ�����ʧ��";
    		}
    	}
    	return Action.SUCCESS;
    }
    
    public String updateChapter()throws Exception
    {
    	
    	if(null!=chapter&&chapter.getId()>0)
    	{
    		chapter=courseService.getChapterById(chapter.getId());
    	}
    	return "edit";
    }
    public String updateSaveChapter()throws Exception
    {
    	if(null!=chapter&&null!=chapter.getCourse()&&chapter.getCourse().getId()>0)
    	{
    		  Chapter old=courseService.getChapterById(chapter.getId());
    		  old.setContent(chapter.getContent());
    		  old.setAbstracts(chapter.getAbstracts());
    		  old.setCourse(chapter.getCourse());
    		  old.setIsFree(chapter.getIsFree());
    		  old.setKeywords(chapter.getKeywords());
    		  old.setTitle(chapter.getTitle());
    		  if(!old.getVodPath().equals(chapter.getVodPath()))
    		  {
    			  old.setVodPath(chapter.getVodPath());
    		  }
    		//��������ͼƬ
	    		if(null!=old.getContentPic()&&null!=chapter.getContentPic()&&(!chapter.getContentPic().equals(old.getContentPic())))
	    		{
	    			String orpath=ServletActionContext.getServletContext().getRealPath("res/upres/chapter_pic");
	    			String oldpic=old.getContentPic();
	    			String files[]=oldpic.split("||");
	    			for(int i=0;i<files.length;i++)
	    			{  
	    				if(chapter.getContentPic().indexOf(files[i])==-1)
	    				{
	    				File f=new File(orpath+File.separator+files[i]);
	    				if(f.exists())f.delete();
	    				}
	    			}
	    			old.setContentPic(chapter.getContentPic());
	    		}
    		  
	    		course=chapter.getCourse();
    		  if(courseService.updateChapter(old))
    		  {
    			  actionMsg="�޸Ŀγ����ݳɹ�";
    		  }else
    		  {
    			  actionMsg="�޸Ŀγ�����ʧ��"; 
    		  }
    	}
    	return Action.SUCCESS;
    }
    
    public String deleteChapter()throws Exception
    {
    	if(null!=chapter&&chapter.getId()>0)
    	{
    		Chapter tem=courseService.getChapterById(chapter.getId());
  		   course=tem.getCourse();
  		 //ɾ��ͼƬ 
				 if(null!=tem&&null!=tem.getContentPic()&&!"".equals(tem.getContentPic()))
				 {
					 String editorPath="res/upres/chapter_pic";	
					 this.deleteFiles(editorPath, tem.getContentPic());
				 }
			//ɾ����Ƶ
				 if(null!=tem&&null!=tem.getVodPath()&&!"".equals(tem.getVodPath()))
				 {
					
					 this.deleteFiles("res/upres/vod", tem.getVodPath());
						 
				 }	
	    		if(courseService.deleteChapterById(chapter.getId()))
	    		{
	    			
							 actionMsg="ɾ���γ����ݳɹ�";
	    		}else
	    		{
	    			actionMsg="ɾ���γ�����ʧ��";
	    		}
    	}else
    	{
    		actionMsg="��������������";
    	}
    	return Action.SUCCESS;
    }
    
    public void deleteFiles(String path,String allFileName)
    {
    	//String editorPath="res/upres/chapter_pic";
		String tarEditorPath=ServletActionContext.getServletContext().getRealPath(path);
		String [] files=allFileName.split("[|]{2}");
		for(String tt:files)
		{
			File f=new File(tarEditorPath+File.separator+tt);
			if(f.exists()) f.delete();
		}
    	
    }
	public List<Chapter> getChapterList() {
		return chapterList;
	}
	public void setChapterList(List<Chapter> chapterList) {
		this.chapterList = chapterList;
	}
	public Chapter getChapter() {
		return chapter;
	}
	public void setChapter(Chapter chapter) {
		this.chapter = chapter;
	}
	public String getActionMsg() {
		return actionMsg;
	}
	public void setActionMsg(String actionMsg) {
		this.actionMsg = actionMsg;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public String getSoft() {
		return soft;
	}
	public void setSoft(String soft) {
		this.soft = soft;
	}
    
    

}
